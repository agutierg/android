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
import android.widget.ProgressBar;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;

public class PosiblesPuntuaciones extends Activity implements AdListener {

	// Submenú
	private ImageView btnVolver;
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnRss;

	private WebView wvPP;
	private ProgressBar progressbarPP;

	private Activity actividad;
	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_posibles_puntos);

		actividad = this;

		/**
		 * Elementos y acciones de los elementos
		 */

		btnAyuda = (ImageView) findViewById(R.id.btnAyudaPP);
		btnVolver = (ImageView) findViewById(R.id.btnVolverPP);
		btnInfo = (ImageView) findViewById(R.id.btnInfoPP);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaPP);
		btnRss = (ImageView) findViewById(R.id.btnRssPP);

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

		// RSS
		btnRss.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaRss = new Intent(v.getContext(), Rss.class);
				startActivityForResult(vistaRss,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_RSS));
			}
		});

		// Cargamos la página
		wvPP = (WebView) findViewById(R.id.wvPP);

		wvPP.getSettings().setJavaScriptEnabled(true);
		wvPP.getSettings().setBuiltInZoomControls(true);

		wvPP.loadUrl(ConstantesParametros.WEB_POSIBLES_PUNTUACIONES);

		wvPP.setWebViewClient(new WebViewClient() {
			// evita que los enlaces se abran fuera nuestra app en el navegador
			// de android
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}
		});

		progressbarPP = (ProgressBar) findViewById(R.id.progressbarPP);

		wvPP.setWebChromeClient(new WebChromeClient()

		{

			@Override
			public void onProgressChanged(WebView view, int progress) {
				progressbarPP.setProgress(0);
				progressbarPP.setVisibility(View.VISIBLE);
				PosiblesPuntuaciones.this.setProgress(progress * 1000);
				progressbarPP.incrementProgressBy(progress);
				if (progress == 100) {
					progressbarPP.setVisibility(View.GONE);
				}
			}

		});

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						// Crear la adView
						// Create the interstitial
						interstitial = new InterstitialAd(actividad,
								"a151115e5f5581f");

						// Create ad request
						AdRequest adRequest = new AdRequest();

						// Begin loading your interstitial
						interstitial.loadAd(adRequest);

						// Set Ad Listener to use the callbacks below
						interstitial.setAdListener((AdListener) actividad);
					}
				});
			}
		}).start();

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDismissScreen(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLeaveApplication(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPresentScreen(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onReceiveAd(Ad ad) {
		if (ad == interstitial) {
			interstitial.show();
		}
	}

}
