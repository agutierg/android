package com.agutierg.comuniopuntos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.google.ads.AdView;

public class Rss extends Activity {

	// Submenú
	private ImageView btnVolver;
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnPosPunt;

	private WebView wvRss;
	private ProgressBar progressBar;

	private LinearLayout llLayoutRss;
	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// Para que no salga el teclado...
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		setContentView(R.layout.activity_rss);

		// Crear la adView
		// adView = new AdView(this, AdSize.BANNER, "a151115e5f5581f");
		// adView.setGravity(Gravity.BOTTOM);

		// Buscar el LinearLayout suponiendo que se le haya asignado
		// el atributo android:id="@+id/mainLayout"
		// llLayoutRss = (LinearLayout) findViewById(R.id.llLayoutRss);

		// Añadirle la adView
		// llLayoutRss.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		// adView.loadAd(new AdRequest());

		/**
		 * Elementos y acciones de los elementos
		 */

		btnAyuda = (ImageView) findViewById(R.id.btnAyudaRSS);
		btnVolver = (ImageView) findViewById(R.id.btnVolverRSS);
		btnInfo = (ImageView) findViewById(R.id.btnInfoRSS);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaRSS);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntRSS);

		// AYUDA
		btnAyuda.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaAyuda = new Intent(view.getContext(), Ayuda.class);
				startActivityForResult(vistaAyuda,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_AYUDA));
			}

		});

		// INFORMACIÓN DE LA APLICACIÓN
		btnInfo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaInfoAplicacion = new Intent(v.getContext(),
						InfoAplicacion.class);
				startActivityForResult(
						vistaInfoAplicacion,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_INFO_APLICACION));
			}
		});

		// VOLVER
		btnVolver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		// JORNADA
		btnJornada.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaJornada = new Intent(v.getContext(), Jornada.class);
				startActivityForResult(vistaJornada, Integer
						.valueOf(ConstantesParametros.CODE_VISTA_JORNADA));
			}
		});

		// POSIBLES PUNTUACIONES
		btnPosPunt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaPosPunt = new Intent(v.getContext(),
						PosiblesPuntuaciones.class);
				startActivityForResult(vistaPosPunt, Integer
						.valueOf(ConstantesParametros.CODE_VISTA_POSIBLES_PUNT));
			}
		});

		// Cargamos la página
		wvRss = (WebView) findViewById(R.id.wvRss);

		wvRss.getSettings().setJavaScriptEnabled(true);
		wvRss.getSettings().setBuiltInZoomControls(true);

		wvRss.loadUrl(ConstantesParametros.WEB_RSS);

		wvRss.setWebViewClient(new WebViewClient() {
			// evita que los enlaces se abran fuera nuestra app en el navegador
			// de android
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}
		});

		progressBar = (ProgressBar) findViewById(R.id.progressbar);

		wvRss.setWebChromeClient(new WebChromeClient()

		{

			@Override
			public void onProgressChanged(WebView view, int progress) {
				progressBar.setProgress(0);
				progressBar.setVisibility(View.VISIBLE);
				Rss.this.setProgress(progress * 1000);
				progressBar.incrementProgressBy(progress);
				if (progress == 100) {
					progressBar.setVisibility(View.GONE);
				}
			}

		});

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
