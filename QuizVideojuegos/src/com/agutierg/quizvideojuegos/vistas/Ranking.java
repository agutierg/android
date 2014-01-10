package com.agutierg.quizvideojuegos.vistas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ListView;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;
import com.agutierg.quizvideojuegos.database.QuizGameSQLite;
import com.agutierg.quizvideojuegos.dto.Jugador;
import com.agutierg.quizvideojuegos.utils.JugadoresFunctions;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;

public class Ranking extends Activity implements AdListener {

	private ListView listRanking;
	private LazyAdapterRanking adapter;

	private List<Jugador> listaJugadores;

	private QuizGameSQLite baseDatosQG;
	private Jugador jugBaseDatos;

	private ProgressDialog pDialog;
	private Tarea tarea;
	private TareaJugadores tareaJugadores;

	private boolean hayError;

	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_ranking);

		listRanking = (ListView) findViewById(R.id.listRanking);

		// Crear la adView
		// Create the interstitial
		interstitial = new InterstitialAd(this, "a15138747ee3473");

		// Create ad request
		AdRequest adRequest = new AdRequest();

		// Begin loading your interstitial
		interstitial.loadAd(adRequest);

		// Set Ad Listener to use the callbacks below
		interstitial.setAdListener(this);

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosQG = new QuizGameSQLite(this, "DBQuizGames", null, 2);

		recuperarPuntosJugador();

	}

	@Override
	public void onReceiveAd(Ad ad) {
		Log.d("OK", "Received ad");
		if (ad == interstitial) {
			interstitial.show();
		}
	}

	private void recuperarPuntosJugador() {

		boolean existe = recuperarJugador();

		if (existe) {
			SQLiteDatabase db = baseDatosQG.getWritableDatabase();
			// Si hemos abierto correctamente la base de datos
			if (db != null) {
				Cursor mCount = db
						.rawQuery(
								"select count(*) from Juego where isRespondido=1",
								null);
				if (mCount.moveToNext()) {
					mCount.moveToFirst();
					int score = mCount.getInt(0);
					jugBaseDatos.setAciertos(score);
					// Actualizamos el jugador en base de datos
					db.execSQL("UPDATE Jugador SET aciertos="
							+ jugBaseDatos.getAciertos() + " WHERE idJugador="
							+ jugBaseDatos.getIdJugador());
					// Actualizamos arriba en la BD
					tarea = new Tarea();
					tarea.execute();
				}
			}
		} else {
			finish();
		}
	}

	private boolean recuperarJugador() {

		boolean existe = true;
		// Recuperamos las niveles
		SQLiteDatabase db = baseDatosQG.getReadableDatabase();
		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			Cursor resJugador = null;
			try {
				// RECUPERAMOS EL JUGADOR
				resJugador = db.query("Jugador", null, null, null, null, null,
						null);
				// Si hay resultados
				if (resJugador.moveToNext()) {
					jugBaseDatos = new Jugador();
					jugBaseDatos.setIdJugador(resJugador.getInt(0));
					jugBaseDatos.setNombreJugador(resJugador.getString(1));
					jugBaseDatos.setAciertos(resJugador.getInt(2));
					existe = true;
				} else {
					Intent vistaLog = new Intent(getApplicationContext(),
							Loguearse.class);
					startActivityForResult(vistaLog,
							Integer.valueOf(ConstantesParametros.VISTA_LOG));
					existe = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Cerramos la base de datos
			db.close();
		}

		return existe;
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
	 * ------------------------------------------
	 * -------------------------------ASYNC TASK
	 * ------------------------------------------
	 * 
	 * 
	 * 
	 * 
	 */
	public class Tarea extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... uri) {

			JugadoresFunctions jugadorF = new JugadoresFunctions();
			hayError = jugadorF.actualizarJugador(jugBaseDatos);
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if (hayError) {
				finalizar();
			} else {
				ejecutarTareaJugadores();
			}
		}

		@Override
		protected void onPreExecute() {
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
		}

	}

	public void finalizar() {
		this.finish();
	}

	/**
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
	 */
	public class TareaJugadores extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... uri) {

			JugadoresFunctions jugadorF = new JugadoresFunctions();
			listaJugadores = jugadorF.recuperarJugadores();
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if (listaJugadores != null && listaJugadores.size() > 0) {
				pDialog.dismiss();
				pintarLista();
			} else {
				pDialog.dismiss();
				finalizar();
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

	private void pintarLista() {

		List<Jugador> listaPintar = new ArrayList<Jugador>();

		// Recorremos la lista hasta encontrar el jugador logado
		for (Jugador jugador : listaJugadores) {
			// Si es el logado, lo ponemos el primero
			if (jugador.getNombreJugador().equals(
					jugBaseDatos.getNombreJugador())) {
				listaPintar.add(jugador);
				break;
			}
		}

		int longitud = listaJugadores.size();
		if (longitud > 49) {
			longitud = 49;
		}
		// Solo mostramos los 50 primeros
		for (int i = 0; i < longitud; i++) {
			Jugador jug = listaJugadores.get(i);
			// Si no es el actual lo añadimos
			if (!jug.getNombreJugador().equals(jugBaseDatos.getNombreJugador())) {
				listaPintar.add(jug);
			}
		}
		// Getting adapter by passing xml data ArrayList
		adapter = new LazyAdapterRanking(this, listaPintar);
		listRanking.setAdapter(adapter);
	}

	public void ejecutarTareaJugadores() {

		/**
		 * 
		 * 
		 * TAREA
		 * 
		 */
		pDialog = new ProgressDialog(this);
		pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pDialog.setMessage("Uploading Data...");
		pDialog.setCancelable(false);
		pDialog.setMax(100);

		pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						pDialog.dismiss();
					}
				});
		pDialog.show();

		tareaJugadores = new TareaJugadores();
		tareaJugadores.execute();
		/**
		 * 
		 * 
		 * TAREA
		 * 
		 */
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
}
