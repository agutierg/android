package com.agutierg.pollitopio.vistas;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.agutierg.pollitopio.R;
import com.agutierg.pollitopio.constants.ConstantesParametros;
import com.google.android.gms.ads.MobileAds;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.UserMessagingPlatform;

public class Main extends Activity {

	// Preferencias para controlar cuándo pedir la valoración
	private static final String PREFS = "pollito_prefs";
	private static final String KEY_REPRODUCCIONES = "reproducciones";

	// URL/ID de la otra app propia para promoción cruzada
	private static final String PEQUELETRAS_ID = "com.agutierg.pequeletras";

	private Button btnPlay;
	private Button btnShare;
	private Button btnWall;
	private Button btnTono;
	private Button btnPequeLetras;

	private ConsentInformation consentInformation;
	// Evita inicializar el SDK de anuncios dos veces
	private final AtomicBoolean adsInicializados = new AtomicBoolean(false);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) {
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}

		setContentView(R.layout.layout_main);

		// Consentimiento GDPR (obligatorio en la UE desde 2024).
		// Muestra el formulario si hace falta y después inicializa los anuncios.
		ConsentRequestParameters params = new ConsentRequestParameters.Builder().build();
		consentInformation = UserMessagingPlatform.getConsentInformation(this);
		consentInformation.requestConsentInfoUpdate(this, params,
				() -> UserMessagingPlatform.loadAndShowConsentFormIfRequired(
						Main.this, formError -> {
							if (consentInformation.canRequestAds()) {
								inicializarAds();
							}
						}),
				requestError -> {
					// Sin red o fallo del formulario: si ya había consentimiento previo, seguimos
					if (consentInformation.canRequestAds()) {
						inicializarAds();
					}
				});

		// Si ya se obtuvo consentimiento en una sesión anterior, no hay que esperar
		if (consentInformation.canRequestAds()) {
			inicializarAds();
		}

		btnPlay = (Button) findViewById(R.id.btnPlay);
		btnShare = (Button) findViewById(R.id.btnShare);
		btnWall = (Button) findViewById(R.id.btnWallpaper);
		btnTono = (Button) findViewById(R.id.btnTono);
		btnPequeLetras = (Button) findViewById(R.id.btnPequeLetras);

		btnPequeLetras.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				abrirPequeLetras();
			}
		});

		btnTono.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				establecerTono();
			}
		});

		btnPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaPlayer = new Intent(view.getContext(),
						VideoViewDemo.class);
				startActivityForResult(vistaPlayer,
						Integer.valueOf(ConstantesParametros.VISTA_PLAYER));
			}
		});

		btnShare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				final Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT,
						"https://www.youtube.com/watch?v=dhsy6epaJGs");
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				view.getContext().startActivity(
						Intent.createChooser(intent, "Compartir con"));
			}
		});

		btnWall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaWall = new Intent(view.getContext(),
						SetWallpaper.class);
				startActivityForResult(vistaWall,
						Integer.valueOf(ConstantesParametros.VISTA_WALL));
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// Al volver de reproducir el vídeo (momento positivo) contamos la
		// reproducción y, cada cierto número de veces, pedimos la valoración.
		if (requestCode == Integer.valueOf(ConstantesParametros.VISTA_PLAYER)) {
			SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
			int veces = prefs.getInt(KEY_REPRODUCCIONES, 0) + 1;
			prefs.edit().putInt(KEY_REPRODUCCIONES, veces).apply();

			// Pedimos valoración en la 2ª reproducción y luego cada 15.
			// Google decide (cuotas) si muestra realmente el diálogo.
			if (veces == 2 || veces % 15 == 0) {
				solicitarValoracion();
			}
		}
	}

	/**
	 * Abre la ficha de la otra app propia (PequeLetras) en Google Play.
	 * Usa el esquema market:// y, si no hay tienda instalada, cae al navegador.
	 */
	private void abrirPequeLetras() {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("market://details?id=" + PEQUELETRAS_ID));
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
					"https://play.google.com/store/apps/details?id=" + PEQUELETRAS_ID));
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		}
	}

	/**
	 * Lanza el flujo oficial de valoración dentro de la app (In-App Review API).
	 * No sabemos si el usuario valora ni si se muestra el diálogo: Google lo
	 * gestiona con cuotas. Por eso no hay que mostrar mensajes ni recompensas.
	 */
	private void solicitarValoracion() {
		final ReviewManager manager = ReviewManagerFactory.create(this);
		manager.requestReviewFlow().addOnCompleteListener(request -> {
			if (request.isSuccessful()) {
				ReviewInfo reviewInfo = request.getResult();
				manager.launchReviewFlow(Main.this, reviewInfo)
						.addOnCompleteListener(flow -> {
							// Flujo terminado; nada más que hacer.
						});
			}
		});
	}

	/**
	 * Copia la canción a la carpeta de tonos del sistema y la establece
	 * como tono de llamada. Necesita el permiso especial WRITE_SETTINGS.
	 */
	private void establecerTono() {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
			Toast.makeText(this, R.string.tono_no_disponible, Toast.LENGTH_LONG).show();
			return;
		}

		if (!Settings.System.canWrite(this)) {
			Toast.makeText(this, R.string.tono_permiso, Toast.LENGTH_LONG).show();
			Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
					Uri.parse("package:" + getPackageName()));
			startActivity(intent);
			return;
		}

		new Thread(() -> {
			try {
				ContentValues valores = new ContentValues();
				valores.put(MediaStore.MediaColumns.DISPLAY_NAME, "pollito_pio.m4a");
				valores.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp4");
				valores.put(MediaStore.MediaColumns.TITLE, "Pollito Pio");
				valores.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_RINGTONES);
				valores.put(MediaStore.Audio.Media.IS_RINGTONE, true);

				Uri uri = getContentResolver().insert(
						MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY),
						valores);

				try (InputStream in = getResources().openRawResource(R.raw.pio_tono);
						OutputStream out = getContentResolver().openOutputStream(uri)) {
					byte[] buffer = new byte[8192];
					int leidos;
					while ((leidos = in.read(buffer)) > 0) {
						out.write(buffer, 0, leidos);
					}
				}

				RingtoneManager.setActualDefaultRingtoneUri(Main.this,
						RingtoneManager.TYPE_RINGTONE, uri);

				runOnUiThread(() -> Toast.makeText(Main.this,
						R.string.tono_ok, Toast.LENGTH_LONG).show());
			} catch (Exception e) {
				runOnUiThread(() -> Toast.makeText(Main.this,
						R.string.tono_error, Toast.LENGTH_LONG).show());
			}
		}).start();
	}

	private void inicializarAds() {
		if (adsInicializados.getAndSet(true)) {
			return;
		}
		MobileAds.initialize(this, initializationStatus -> {
		});
	}
}
