package com.agutierg.comuniopuntos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;

public class Jornada extends Activity {

	// Submenú
	private ImageView btnInfo;
	private ImageView btnAyuda;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private WebView wvResultados;
	private WebView wvClasificacion;
	private WebView wvProxJorn;

	private TabHost tabHostJornada;

	private ProgressDialog pDialog;
	private TareaInicialBDTask tareaWeb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// Para que no salga el teclado...
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		setContentView(R.layout.activity_jornada);

		/**
		 * Elementos y acciones de los elementos
		 */

		Resources res = getResources();
		// Para el tabHost
		tabHostJornada = (TabHost) findViewById(R.id.tabhostJorn);
		tabHostJornada.setup();

		TabSpec specRes = tabHostJornada.newTabSpec("Resultados");
		specRes.setContent(R.id.svResultados);
		specRes.setIndicator("", res.getDrawable(R.drawable.resultados));
		tabHostJornada.addTab(specRes);

		TabSpec specClas = tabHostJornada.newTabSpec("Clasificacion");
		specClas.setContent(R.id.svClasificacion);
		specClas.setIndicator("", res.getDrawable(R.drawable.clasificacion));
		tabHostJornada.addTab(specClas);

		TabSpec specProxJorn = tabHostJornada.newTabSpec("Próxima Jornada");
		specProxJorn.setContent(R.id.svProxJorn);
		specProxJorn.setIndicator("", res.getDrawable(R.drawable.proxjornada));
		tabHostJornada.addTab(specProxJorn);

		tabHostJornada.setCurrentTab(0);

		wvResultados = (WebView) findViewById(R.id.wvResultados);
		wvClasificacion = (WebView) findViewById(R.id.wvClasificacion);
		wvProxJorn = (WebView) findViewById(R.id.wvProxJorn);

		btnInfo = (ImageView) findViewById(R.id.btnInfoJO);
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaJO);
		btnVolver = (ImageView) findViewById(R.id.btnVolverJO);
		btnRss = (ImageView) findViewById(R.id.btnRssJO);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntJO);

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

		// AYUDA
		btnAyuda.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaAyuda = new Intent(view.getContext(), Ayuda.class);
				startActivityForResult(vistaAyuda,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_AYUDA));
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

		/**
		 * 
		 * 
		 * TAREA
		 * 
		 */
		pDialog = new ProgressDialog(Jornada.this);
		pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pDialog.setMessage(ConstantesParametros.DESCARGANDO_INFO);
		pDialog.setCancelable(false);
		pDialog.setMax(100);

		pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						pDialog.dismiss();
						finish();
					}
				});
		pDialog.show();

		tareaWeb = new TareaInicialBDTask();
		tareaWeb.execute();
		/**
		 * 
		 * 
		 * TAREA
		 * 
		 */

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

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

			// Variables
			HttpClient httpclient = new DefaultHttpClient();
			String resString = null;
			HttpResponse response = null;
			InputStream is = null;
			BufferedReader reader = null;
			String line = null;

			// Create HTTP Client
			HttpGet httpget = new HttpGet(
					ConstantesParametros.DIRECCION_WEB_JORNADA);
			try {
				response = httpclient.execute(httpget);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Executeit
			HttpEntity entity = response.getEntity();
			try {
				is = entity.getContent();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Create an
			// InputStream with
			// the response
			try {
				reader = new BufferedReader(new InputStreamReader(is,
						"iso-8859-15"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StringBuilder sb = new StringBuilder();
			try {
				while ((line = reader.readLine()) != null) {
					// Read line by line
					sb.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resString = sb.toString();
			//
			// Result is here
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return resString;

		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			// La cadena a analizar
			String cadena = result;

			// Extraemos la información
			extraerInfo(cadena);
			// Cerramos
			pDialog.dismiss();
		}

		private void extraerInfo(String cadena) {
			// Obtenemos la informacion
			Pattern patronClasificacion = Pattern
					.compile(ConstantesParametros.CLASIFICACION);
			Matcher matcherClasificacion = patronClasificacion.matcher(cadena);
			if (matcherClasificacion.find()) {
				String clasificacion = matcherClasificacion.group(1);
				wvClasificacion.loadDataWithBaseURL(null, clasificacion,
						"text/html", "UTF-8", null);
			}

			Pattern patronResultados = Pattern
					.compile(ConstantesParametros.RESULTADOS);
			Matcher matcherResultados = patronResultados.matcher(cadena);
			if (matcherResultados.find()) {
				String resultados = matcherResultados.group(1);
				wvResultados.loadDataWithBaseURL(null, resultados, "text/html",
						"UTF-8", null);
			}

			Pattern patronProxJorn = Pattern
					.compile(ConstantesParametros.PROX_JORNADA);
			Matcher matcherProxJorn = patronProxJorn.matcher(cadena);
			if (matcherProxJorn.find()) {
				String proxJornada = matcherProxJorn.group(1);
				wvProxJorn.loadDataWithBaseURL(null, proxJornada, "text/html",
						"UTF-8", null);
			}

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

}
