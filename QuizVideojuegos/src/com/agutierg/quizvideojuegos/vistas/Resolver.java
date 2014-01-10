package com.agutierg.quizvideojuegos.vistas;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;
import com.agutierg.quizvideojuegos.database.QuizGameSQLite;
import com.agutierg.quizvideojuegos.dto.Juego;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Resolver extends Activity {

	private Button btnBack;
	private Button btnHint;
	private Button btnSolve;

	private EditText etSolve;

	private ImageView ivGame;

	private Juego juegoSeleccionado;
	private QuizGameSQLite baseDatosQG;

	private AdView adView;
	private LinearLayout llResolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_resolver);

		/**
		 * Añadimos el banner
		 */
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a15138747ee3473");
		adView.setGravity(Gravity.CENTER);

		llResolver = (LinearLayout) findViewById(R.id.llResolver);

		// LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
		// LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		// params.gravity = Gravity.TOP;
		// params.weight = 1;

		// Añadirle la adView
		llResolver.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosQG = new QuizGameSQLite(this, "DBQuizGames", null, 2);

		// Recogemos los puntos de los equipos que vienen por parámetro
		Bundle bundle = getIntent().getExtras();

		if (bundle != null
				&& bundle
						.getSerializable(ConstantesParametros.JUEGO_SELECCIONADO) != null) {
			juegoSeleccionado = (Juego) bundle
					.getSerializable(ConstantesParametros.JUEGO_SELECCIONADO);
		}

		/**
		 * LISTENERS Y COMPONENTES
		 */
		btnBack = (Button) findViewById(R.id.btnBack);
		btnHint = (Button) findViewById(R.id.btnHint);
		btnSolve = (Button) findViewById(R.id.btnSolve);

		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				cerrarTeclado();
				finish();
			}
		});

		btnHint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if (juegoSeleccionado != null) {
					// PISTA
					CharSequence text = juegoSeleccionado.getPistaJuego();
					LayoutInflater inflater = getLayoutInflater();
					View layout = inflater.inflate(R.layout.custom_toast,
							(ViewGroup) findViewById(R.id.toast_layout_root));
					TextView tvToast = (TextView) layout
							.findViewById(R.id.tvToast);
					tvToast.setText(text);
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 180);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(layout);
					toast.show();
				}
			}
		});

		btnSolve.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Editable editable = etSolve.getText();
				if (editable != null) {
					String textoInsertado = editable.toString();
					if (textoInsertado != null && !("").equals(textoInsertado)) {
						textoInsertado = textoInsertado.toUpperCase();
						String textoBueno = juegoSeleccionado.getNombreJuego();
						// Si son iguales...
						if (textoBueno.equals(textoInsertado)) {
							// MAS O MENOS
							CharSequence text = ConstantesParametros.CORRECT;
							LayoutInflater inflater = getLayoutInflater();
							View layout = inflater
									.inflate(
											R.layout.custom_toast,
											(ViewGroup) findViewById(R.id.toast_layout_root));
							TextView tvToast = (TextView) layout
									.findViewById(R.id.tvToast);
							tvToast.setText(text);
							ImageView ivToast = (ImageView) layout
									.findViewById(R.id.ivToast);
							ivToast.setImageResource(R.drawable.solve);
							Toast toast = new Toast(getApplicationContext());
							toast.setGravity(Gravity.TOP, 0, 180);
							toast.setDuration(Toast.LENGTH_LONG);
							toast.setView(layout);
							toast.show();

							// HACEMOS EL UPDATE
							// Recuperamos los juegos
							SQLiteDatabase db = baseDatosQG
									.getWritableDatabase();
							// Si hemos abierto correctamente la base de datos
							if (db != null) {
								try {
									db.execSQL("UPDATE Juego SET isRespondido = 1 WHERE idJuego = "
											+ juegoSeleccionado.getIdJuego());
								} catch (Exception e) {
									e.printStackTrace();
								}
								// Cerramos la base de datos
								db.close();
							}
							cerrarTeclado();
							finish();
						}
						// Si son parecidos
						else if (textoBueno.contains(textoInsertado)
								|| textoInsertado.contains(textoBueno)) {
							// MAS O MENOS
							CharSequence text = ConstantesParametros.MORE_LESS;
							LayoutInflater inflater = getLayoutInflater();
							View layout = inflater
									.inflate(
											R.layout.custom_toast,
											(ViewGroup) findViewById(R.id.toast_layout_root));
							TextView tvToast = (TextView) layout
									.findViewById(R.id.tvToast);
							tvToast.setText(text);
							Toast toast = new Toast(getApplicationContext());
							toast.setGravity(Gravity.TOP, 0, 180);
							toast.setDuration(Toast.LENGTH_LONG);
							toast.setView(layout);
							toast.show();
						}
						// No se parecen
						else {
							// MAS O MENOS
							CharSequence text = ConstantesParametros.TRY_AGAIN;
							LayoutInflater inflater = getLayoutInflater();
							View layout = inflater
									.inflate(
											R.layout.custom_toast,
											(ViewGroup) findViewById(R.id.toast_layout_root));
							TextView tvToast = (TextView) layout
									.findViewById(R.id.tvToast);
							tvToast.setText(text);
							Toast toast = new Toast(getApplicationContext());
							toast.setGravity(Gravity.TOP, 0, 180);
							toast.setDuration(Toast.LENGTH_LONG);
							toast.setView(layout);
							toast.show();
						}

					}
				}

			}
		});

		etSolve = (EditText) findViewById(R.id.etSolve);

		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(etSolve, InputMethodManager.SHOW_IMPLICIT);

		ivGame = (ImageView) findViewById(R.id.ivGame);
		if (juegoSeleccionado != null) {
			Bitmap bmp = BitmapFactory.decodeResource(
					getResources(),
					getResources().getIdentifier(
							juegoSeleccionado.getIdDrawable(), "drawable",
							this.getApplicationContext().getPackageName()));
			ivGame.setImageBitmap(bmp);
		}

		// Si ya está acertado, todo deshabilitado
		if (juegoSeleccionado != null && juegoSeleccionado.isRespondido()) {
			etSolve.setText(juegoSeleccionado.getNombreJuego());
			etSolve.setEnabled(false);
			btnHint.setEnabled(false);
			btnSolve.setEnabled(false);

			Bitmap bmpAntigua = ((BitmapDrawable) ivGame.getDrawable())
					.getBitmap();
			Bitmap bmp1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.checkgrande);
			Bitmap mezcla = overlay(bmpAntigua, bmp1);
			ivGame.setImageBitmap(mezcla);
		}
	}

	public void cerrarTeclado() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(etSolve.getWindowToken(), 0);
	}

	public Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
		Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(),
				bmp1.getHeight(), bmp1.getConfig());
		Canvas canvas = new Canvas(bmOverlay);
		canvas.drawBitmap(bmp1, 0, 0, null);
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(bmp2,
				bmp1.getWidth() - 10, bmp1.getHeight() - 10, true);
		canvas.drawBitmap(scaledBitmap, 10, 10, null);
		return bmOverlay;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
