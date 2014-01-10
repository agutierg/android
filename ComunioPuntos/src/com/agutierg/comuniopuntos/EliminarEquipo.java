package com.agutierg.comuniopuntos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.database.PuntosComunioSQLite;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;

public class EliminarEquipo extends Activity implements AdListener {

	// Componentes pantalla
	private Spinner spiEquJugEL;
	private Button btnEliminar;

	// Submenú
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private PuntosComunioSQLite baseDatosComunio;
	private HashMap<String, Integer> hashEquJug = null;

	private String equiJugSelec;

	private InterstitialAd interstitial;
	private Activity actividad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// Para que no salga el teclado...
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		setContentView(R.layout.activity_eliminar_equipo);

		actividad = this;

		baseDatosComunio = new PuntosComunioSQLite(this, "DBComunioPuntos",
				null, 10);

		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */
		spiEquJugEL = (Spinner) findViewById(R.id.spiEquJugEL);

		// Añadimos los equipos del jugador al spinner
		List<String> listaEquJugador = construyeListaEquJugador();
		addItemsOnSpinner(spiEquJugEL, listaEquJugador);
		// Añadimos el listener
		spiEquJugEL.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos el equipo por defecto
		equiJugSelec = spiEquJugEL.getItemAtPosition(0).toString();

		// Para el boton de añadir jugadores
		btnEliminar = (Button) findViewById(R.id.btnEliminar);

		btnEliminar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				// Crear la adView
				// Create the interstitial
				interstitial = new InterstitialAd(actividad, "a151115e5f5581f");

				// Create ad request
				AdRequest adRequest = new AdRequest();

				// Begin loading your interstitial
				interstitial.loadAd(adRequest);

				// Set Ad Listener to use the callbacks below
				interstitial.setAdListener((AdListener) actividad);

				// Recuperamos el Id del equipo de la Hash
				Integer equJugId = hashEquJug.get(equiJugSelec);
				/**
				 * 
				 * BASE DE DATOS
				 */
				final SQLiteDatabase db = baseDatosComunio
						.getWritableDatabase();

				if (db != null) {
					// Borramos los jugadores de ese equipo
					try {
						db.execSQL("DELETE FROM EquJugFutbolista WHERE equJugId = "
								+ equJugId);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// Borramos el equipo
					try {
						db.execSQL("DELETE FROM EquipoJugador WHERE equJugId = "
								+ equJugId);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// Cerramos la base de datos
					db.close();
					// Cerramos la ventana
					finish();
					// Mostramos mensaje de todo OK
					CharSequence text = ConstantesParametros.ELIMINAR_EQUIPO_JUG_OK;
					Toast toast = Toast.makeText(view.getContext(), text,
							Toast.LENGTH_SHORT);
					toast.show();
				}
			}

		});
		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaEE);
		btnInfo = (ImageView) findViewById(R.id.btnInfoEE);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaEE);
		btnVolver = (ImageView) findViewById(R.id.btnVolverEE);
		btnRss = (ImageView) findViewById(R.id.btnRssEE);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntEE);

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
	}

	// Listeners para los SPINNERS
	private OnItemSelectedListener spinerSelectedListener = new Spinner.OnItemSelectedListener() {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {

			// Si hemos seleccionado un equipo
			if (parent.getId() == R.id.spiEquJugEL) {
				// Recogemos el valor
				equiJugSelec = parent.getItemAtPosition(pos).toString();
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};

	private List<String> construyeListaEquJugador() {
		List<String> listaEquJug = new ArrayList<String>();

		/**
		 * 
		 * BASE DE DATOS
		 */
		final SQLiteDatabase db = baseDatosComunio.getWritableDatabase();
		hashEquJug = new HashMap<String, Integer>();
		if (db != null) {
			Cursor res = null;
			try {
				res = db.query("EquipoJugador", null, null, null, null, null,
						null);
				// Si hay resultados
				while (res.moveToNext()) {
					String nombreEq = res.getString(1);
					listaEquJug.add(nombreEq);
					// Añadimos a la hash de Equipos del jugador
					hashEquJug.put(nombreEq, res.getInt(0));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaEquJug;
	}

	// Método que añade los equipos a un Spinner
	private void addItemsOnSpinner(Spinner spiner, List<String> listaItems) {

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, listaItems);
		spiner.setAdapter(adapter);
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
