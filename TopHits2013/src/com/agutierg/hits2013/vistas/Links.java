package com.agutierg.hits2013.vistas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.agutierg.hits2013.R;
import com.agutierg.hits2013.utils.CancionFunctions;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;

public class Links extends Activity implements AdListener {

	private Button btSendL;
	private EditText etRequestL;

	private ProgressDialog pDialog;
	private TareaInicialBDTask tarea;

	private String peticion;
	private AdView adView;

	private RelativeLayout rlVistaL;

	private InterstitialAd interstitial;

	private Activity actividad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_links);

		actividad = this;

		adView = new AdView(this, AdSize.BANNER,
				"ca-app-pub-3391184176179743/8651174511");

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);

		rlVistaL = (RelativeLayout) findViewById(R.id.rlVistaL);

		// Añadirle la adView
		rlVistaL.addView(adView, params);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		btSendL = (Button) findViewById(R.id.btSendL);
		etRequestL = (EditText) findViewById(R.id.etRequestL);

		btSendL.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				peticion = etRequestL.getText().toString();
				if (peticion != null && !peticion.equals("")) {

					// Crear la adView
					// Create the interstitial
					interstitial = new InterstitialAd(actividad,
							"ca-app-pub-3391184176179743/5278905715");

					// Create ad request
					AdRequest adRequest = new AdRequest();

					// Begin loading your interstitial
					interstitial.loadAd(adRequest);

					// Set Ad Listener to use the callbacks below
					interstitial.setAdListener((AdListener) actividad);

					/**
					 * 
					 * 
					 * TAREA
					 * 
					 */
					pDialog = new ProgressDialog(view.getContext());
					pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					pDialog.setMessage(view.getContext().getString(
							R.string.uploading));
					pDialog.setCancelable(false);
					pDialog.setMax(100);

					pDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
							"Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									pDialog.dismiss();
								}
							});
					pDialog.show();

					tarea = new TareaInicialBDTask();
					tarea.execute();
					/**
					 * 
					 * 
					 * TAREA
					 * 
					 */
					// OK
					CharSequence text = view.getContext().getString(
							R.string.peticionrecogida);
					Toast toast = Toast.makeText(view.getContext(), text,
							Toast.LENGTH_SHORT);
					toast.show();
				} else {
					// Introduce algo
					CharSequence text = view.getContext().getString(
							R.string.something);
					Toast toast = Toast.makeText(view.getContext(), text,
							Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ------------------------------------------
	 * -------------------------------ASYNC TASK
	 * ------------------------------------------
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public class TareaInicialBDTask extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... uri) {

			CancionFunctions cancionF = new CancionFunctions();
			cancionF.enviarLink(peticion);
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			finalizar();
		}

		@Override
		protected void onPreExecute() {
			pDialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			pDialog.setProgress(values[0]);
		}

	}

	public void finalizar() {
		this.finish();
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
