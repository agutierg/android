package com.agutierg.comuniopuntos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.database.PuntosComunioSQLite;
import com.agutierg.comuniopuntos.dto.EquiPuntDTO;
import com.agutierg.comuniopuntos.dto.EquiPuntJugDTO;
import com.agutierg.comuniopuntos.dto.EquiPuntSerializable;
import com.agutierg.comuniopuntos.dto.EquiPuntSerializableJug;
import com.agutierg.comuniopuntos.dto.FutJugDTO;
import com.agutierg.comuniopuntos.dto.JugPuntDTO;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

/**
 * 
 */
public class PaginaPrincipal extends Activity {

	private AdView adView;

	// Menú principal
	private Button btnMisEqui;
	private Button btnPuntGen;
	private Button btnAnaEqu;
	private Button btnModEqu;
	private Button btnElimEqu;
	private Button btnInfoJug;

	// Submenú
	private ImageView btnExit;
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private ProgressDialog pDialog;
	private TareaInicialBDTask tareaWeb;
	private PuntosComunioSQLite baseDatosComunio;
	private List<EquiPuntDTO> listaEquiposCP;
	private String jornada = null;
	private String vistaAbrir;

	private View vistaGeneral;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_pagina_principal);

		/**
		 * Añadimos el banner
		 */
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a151115e5f5581f");
		adView.setGravity(Gravity.CENTER);

		// Buscar el LinearLayout suponiendo que se le haya asignado
		// el atributo android:id="@+id/mainLayout"
		LinearLayout layoutP = (LinearLayout) findViewById(R.id.layoutP);

		// Añadirle la adView
		layoutP.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());
		/**
		 * 
		 */

		/**
		 * Elementos y acciones de los elementos
		 */
		btnMisEqui = (Button) findViewById(R.id.btnMisEqui);
		btnPuntGen = (Button) findViewById(R.id.btnPuntGen);
		btnAnaEqu = (Button) findViewById(R.id.btnAnaEqu);
		btnModEqu = (Button) findViewById(R.id.btnModEqu);
		btnElimEqu = (Button) findViewById(R.id.btnElimEqu);
		btnInfoJug = (Button) findViewById(R.id.btnInfoJug);

		btnAyuda = (ImageView) findViewById(R.id.btnAyuda);
		btnExit = (ImageView) findViewById(R.id.btnExit);
		btnInfo = (ImageView) findViewById(R.id.btnInfo);
		btnJornada = (ImageView) findViewById(R.id.btnJornada);
		btnRss = (ImageView) findViewById(R.id.btnRss);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPunt);

		// MIS EQUIPOS
		btnMisEqui.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				if (listaEquiposCP == null || listaEquiposCP.size() == 0) {
					vistaAbrir = ConstantesParametros.CODE_VISTA_MIS_EQUIPOS;
					vistaGeneral = view;
					// Recuperamos los puntos atacando a la WEB

					pDialog = new ProgressDialog(PaginaPrincipal.this);
					pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					pDialog.setMessage(ConstantesParametros.DESCARGANDO_PUNTOS);
					pDialog.setCancelable(false);
					pDialog.setMax(100);

					pDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
							"Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									pDialog.dismiss();
									listaEquiposCP = new ArrayList<EquiPuntDTO>();
									vistaAbrir = null;
								}
							});
					pDialog.show();

					tareaWeb = new TareaInicialBDTask();
					tareaWeb.execute();
				} else {
					// ABRO LA PANTALLA
					abrirMisEquipos(view);
				}

			}

		});

		// PUNTUACIONES GENERALES
		btnPuntGen.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				if (listaEquiposCP == null || listaEquiposCP.size() == 0) {
					vistaAbrir = ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES;
					vistaGeneral = view;
					// Recuperamos los puntos atacando a la WEB

					pDialog = new ProgressDialog(PaginaPrincipal.this);
					pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					pDialog.setMessage(ConstantesParametros.DESCARGANDO_PUNTOS);
					pDialog.setCancelable(false);
					pDialog.setMax(100);

					pDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
							"Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									pDialog.dismiss();
									listaEquiposCP = new ArrayList<EquiPuntDTO>();
									vistaAbrir = null;
								}
							});
					pDialog.show();

					tareaWeb = new TareaInicialBDTask();
					tareaWeb.execute();
				} else {

					// ABRO LA PANTALLA
					abrirPuntuacionesGenerales(view);
				}

			}

		});

		// AÑADIR EQUIPOS
		btnAnaEqu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaAnadirEqu = new Intent(view.getContext(),
						AnadirEquipo.class);
				startActivityForResult(
						vistaAnadirEqu,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_ANADIR_EQUIPO));
			}

		});

		// MODIFICAR EQUIPOS
		btnModEqu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				final SQLiteDatabase db = baseDatosComunio
						.getWritableDatabase();
				if (db != null) {
					Cursor res = null;
					try {
						res = db.query("EquipoJugador", null, null, null, null,
								null, null);
						// Si hay resultados
						if (res.moveToNext()) {
							Intent vistaModificarEqu = new Intent(view
									.getContext(), ModificarEquipo.class);
							startActivityForResult(
									vistaModificarEqu,
									Integer.valueOf(ConstantesParametros.CODE_VISTA_MODIFICAR_EQUIPO));
						} else {
							// NO HAY EQUIPOS ELIMINAR
							CharSequence text = ConstantesParametros.ERROR_ANADE_EQUIPO;
							Toast toast = Toast.makeText(view.getContext(),
									text, Toast.LENGTH_SHORT);
							toast.show();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}

		});

		// ELIMINAR EQUIPO
		btnElimEqu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				final SQLiteDatabase db = baseDatosComunio
						.getWritableDatabase();
				if (db != null) {
					Cursor res = null;
					try {
						res = db.query("EquipoJugador", null, null, null, null,
								null, null);
						// Si hay resultados
						if (res.moveToNext()) {
							Intent vistaEliminarEqu = new Intent(view
									.getContext(), EliminarEquipo.class);
							startActivityForResult(
									vistaEliminarEqu,
									Integer.valueOf(ConstantesParametros.CODE_VISTA_ELIMINAR_EQUIPO));
						} else {
							// NO HAY EQUIPOS ELIMINAR
							CharSequence text = ConstantesParametros.ERROR_ANADE_EQUIPO;
							Toast toast = Toast.makeText(view.getContext(),
									text, Toast.LENGTH_SHORT);
							toast.show();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}

		});

		// INFORMACIÓN JUGADORES
		btnInfoJug.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaInfoJug = new Intent(view.getContext(),
						InfoJugadores.class);
				startActivityForResult(
						vistaInfoJug,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_INFO_JUGADORES));

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

		// CERRAR APLICACIÓN
		btnExit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);
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

		/**
		 * Elementos y acciones de los elementos
		 */

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosComunio = new PuntosComunioSQLite(this, "DBComunioPuntos",
				null, 11);

		SQLiteDatabase db = baseDatosComunio.getWritableDatabase();

		// Si hemos abierto correctamente la base de datos
		if (db != null) {

			// Cerramos la base de datos
			db.close();
		}

		// Recuperamos los puntos atacando a la WEB

		// pDialog = new ProgressDialog(PaginaPrincipal.this);
		// pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		// pDialog.setMessage(ConstantesParametros.DESCARGANDO_PUNTOS);
		// pDialog.setCancelable(false);
		// pDialog.setMax(100);
		//
		// pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
		// new DialogInterface.OnClickListener() {
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// pDialog.dismiss();
		// finish();
		// }
		// });
		// pDialog.show();
		//
		// tareaWeb = new TareaInicialBDTask();
		// tareaWeb.execute();
		/**
		 * 
		 */

	}

	// Método que abre la vista de mis equipos
	private void abrirMisEquipos(View view) {

		Intent vistaPuntGen = new Intent(view.getContext(), MisEquipos.class);
		// recuperamos puntos y jugadores
		List<EquiPuntJugDTO> listaEquJug = construyeListaEquJug();
		// Lo pasamos por parámetro
		if (listaEquJug != null && listaEquJug.size() > 0) {
			EquiPuntSerializableJug param = new EquiPuntSerializableJug(
					listaEquJug);
			vistaPuntGen.putExtra(
					ConstantesParametros.EQUIPOS_Y_PUNTOS_JUGADOR, param);
			startActivityForResult(
					vistaPuntGen,
					Integer.valueOf(ConstantesParametros.CODE_VISTA_MIS_EQUIPOS));
		} else {
			// NOMBRE AÑADE EQUIPO
			CharSequence text = ConstantesParametros.ERROR_ANADE_EQUIPO;
			Toast toast = Toast.makeText(view.getContext(), text,
					Toast.LENGTH_LONG);
			toast.show();
		}
		vistaAbrir = null;
	}

	// Método que abre la vista de puntuaciones generales
	private void abrirPuntuacionesGenerales(View view) {
		Intent vistaPuntGen = new Intent(view.getContext(),
				PuntosGenerales.class);
		// Pasamos los equipos y sus puntos
		EquiPuntSerializable puntosYEquipos = new EquiPuntSerializable();
		puntosYEquipos.setListaEquPuntos(listaEquiposCP);
		if (listaEquiposCP != null && listaEquiposCP.size() > 0) {
			vistaPuntGen.putExtra(ConstantesParametros.EQUIPOS_Y_PUNTOS,
					puntosYEquipos);
			startActivityForResult(
					vistaPuntGen,
					Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES));
		} else {
			// NOMBRE AÑADE EQUIPO
			CharSequence text = ConstantesParametros.ERROR_NO_JUG_NINGUN_EQUIPO;
			Toast toast = Toast.makeText(view.getContext(), text,
					Toast.LENGTH_LONG);
			toast.show();
		}
		vistaAbrir = null;
	}

	// Método que construye la lista con los jugadores de cada equipo del
	// jugador
	private List<EquiPuntJugDTO> construyeListaEquJug() {

		List<EquiPuntJugDTO> listaEquJug = new ArrayList<EquiPuntJugDTO>();
		// Recuperamos los Ids de los equipos del jugador y los nombres
		SQLiteDatabase db = baseDatosComunio.getWritableDatabase();

		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			// INICIO: RECUPERAMOS LOS EQUIPOS
			HashMap<Integer, String> hashEquipos = new HashMap<Integer, String>();
			Cursor resEquipos = null;
			try {
				// RECUPERAMOS LOS EQUIPOS
				resEquipos = db.query("Equipo", null, null, null, null, null,
						null);
				// Si hay resultados
				while (resEquipos.moveToNext()) {
					hashEquipos.put(resEquipos.getInt(0),
							resEquipos.getString(2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// FIN: RECUPERAMOS LOS EQUIPOS

			Cursor resEquJug = null;
			try {
				// INICIO: RECUPERAMOS LOS EQUIPOS DE ESE JUGADOR
				resEquJug = db.query("EquipoJugador", null, null, null, null,
						null, null);
				// Si hay resultados
				while (resEquJug.moveToNext()) {
					Integer equJugId = resEquJug.getInt(0);
					String equJugNombre = resEquJug.getString(1);
					List<FutJugDTO> listaJugEqu = new ArrayList<FutJugDTO>();

					// INICIO: RECUPERAMOS LOS FUTBOLISTAS DE ESE JUGADOR
					String[] campos = new String[] { equJugId.toString() };
					String query = "SELECT a.nombreFut, a.equipoFut, a.posFut FROM Futbolista a INNER JOIN EquJugFutbolista b ON a.futId = b.futbolistaId WHERE b.equJugId = ?";
					try {
						// Ejecutamos la query
						Cursor resFutJug = db.rawQuery(query, campos);
						// Si hemos encontrado registros
						while (resFutJug.moveToNext()) {
							// Añadimos un nuevo futbolista
							FutJugDTO futbolistaJug = new FutJugDTO();
							futbolistaJug.setNombreJugador(resFutJug
									.getString(0));
							futbolistaJug.setPosicion(resFutJug.getString(2));
							// Guardamos la info que necesitamos
							String aliasEquFut = hashEquipos.get(resFutJug
									.getInt(1));
							String nombreFut = resFutJug.getString(0);
							// Con el alias del equipo y el nombre del jugador,
							// recuperamos el resto de informacion
							futbolistaJug = recuperarPunYOnce(futbolistaJug,
									aliasEquFut, nombreFut);
							// Añadimos el futbolista
							listaJugEqu.add(futbolistaJug);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					/**
					 * Creamos el equipo
					 */
					EquiPuntJugDTO equipo = new EquiPuntJugDTO();
					// Seteamos el nombre
					equipo.setNombreEquipo(equJugNombre);
					// Añadimos los futbolistas
					equipo.setListaJugPuntos(listaJugEqu);
					// Jornada
					// equipo.setJornada(Integer.valueOf(jornada));
					// Puntuacion total
					equipo.setPuntEquipo(calculaPuntosEquJug(listaJugEqu));
					// FIN: RECUPERAMOS LOS FUTBOLISTAS DE ESE JUGADOR
					listaEquJug.add(equipo);
				}

				// FIN: RECUPERAMOS LOS EQUIPOS DE ESE JUGADOR
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Cerramos la base de datos
			db.close();
		}

		return listaEquJug;
	}

	private int calculaPuntosEquJug(List<FutJugDTO> listaJugPunt) {

		int puntosEquipo = 0;
		if (listaJugPunt != null && listaJugPunt.size() > 0) {
			for (FutJugDTO jugPuntDTO : listaJugPunt) {
				// Si no es null o NO HA JUGADO
				if (jugPuntDTO.getPuntosJugador() != null
						&& !jugPuntDTO.getPuntosJugador().equals(
								ConstantesParametros.NO_HA_JUGADO)) {
					puntosEquipo = puntosEquipo
							+ Integer.valueOf(jugPuntDTO.getPuntosJugador());
				}
			}
		}
		return puntosEquipo;
	}

	private FutJugDTO recuperarPunYOnce(FutJugDTO futbolistaJug,
			String aliasEquFut, String nombreFut) {

		String puntos = ConstantesParametros.NO_HA_JUGADO;
		boolean onceIdeal = false;

		// Recorremos la lista de equipos y puntuaciones que tenemos
		for (EquiPuntDTO equiPuntDTO : listaEquiposCP) {
			// Si encontramos el equipo
			if (equiPuntDTO.getNombreEquipo().equals(aliasEquFut)) {
				List<JugPuntDTO> listaJugPunt = equiPuntDTO.getListaJugPuntos();
				if (listaJugPunt != null && listaJugPunt.size() > 0) {
					// Recorremos la lista hasta encontrar el jugador
					for (JugPuntDTO jugPuntDTO : listaJugPunt) {
						// Si es el que buscamos
						if (jugPuntDTO.getNombreJugador().equals(nombreFut)) {
							puntos = jugPuntDTO.getPuntosJugador();
							onceIdeal = jugPuntDTO.isOnceIdeal();
							break;
						}
					}
				}
				break;
			}
		}

		futbolistaJug.setOnceIdeal(onceIdeal);
		futbolistaJug.setPuntosJugador(puntos);
		futbolistaJug.setEquipo(aliasEquFut);
		return futbolistaJug;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onDestroy() {
		adView.destroy();
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
			HttpGet httpget = new HttpGet(ConstantesParametros.DIRECCION_WEB);
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
				reader = new BufferedReader(new InputStreamReader(is, "UTF8"));
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
			// Extraemos los puntos
			listaEquiposCP = extraerPuntos(cadena);
			// Persistimos en Base de Datos
			// persistirPuntos(listaEquiposCP);
			// Cerramos
			pDialog.dismiss();

			if (listaEquiposCP != null && listaEquiposCP.size() > 0) {
				if (vistaAbrir != null) {
					// Abrimos la vista que toque
					if (ConstantesParametros.CODE_VISTA_MIS_EQUIPOS
							.equals(vistaAbrir)) {
						abrirMisEquipos(vistaGeneral);
					} else {
						abrirPuntuacionesGenerales(vistaGeneral);
					}
				}
			} else {
				// NOMBRE AÑADE EQUIPO
				CharSequence text = ConstantesParametros.ERROR_NO_JUG_NINGUN_EQUIPO;
				Toast toast = Toast.makeText(vistaGeneral.getContext(), text,
						Toast.LENGTH_LONG);
				toast.show();
			}
		}

		/**
		 * Método que persiste los puntos en Base de Datos
		 * 
		 * @param listaEquiposCP
		 */
		private void persistirPuntos(List<EquiPuntDTO> listaEquiposCP) {

			SQLiteDatabase db = baseDatosComunio.getWritableDatabase();

			// Si hemos abierto correctamente la base de datos
			if (db != null) {

				for (EquiPuntDTO equiPuntDTO : listaEquiposCP) {

					// Recorremos los equipos y guardamos los puntos
					insertPuntos(db, equiPuntDTO);
				}

				// Cerramos la base de datos
				db.close();
			}
		}

		/**
		 * Método que persiste los puntos de un Equipo
		 * 
		 * @param db
		 * @param equiPuntDTO
		 */
		private void insertPuntos(SQLiteDatabase db, EquiPuntDTO equiPuntDTO) {

			List<JugPuntDTO> listaJugPunt = equiPuntDTO.getListaJugPuntos();
			// for (JugPuntDTO jugPuntDTO : listaJugPunt) {
			// db.execSQL("INSERT INTO Puntos (futId,puntosFut,jornada) VALUES ((SELECT futId FROM Futbolista WHERE nombreFut = '"
			// + jugPuntDTO.getNombreJugador()
			// + "'),'"
			// + jugPuntDTO.getPuntosJugador()
			// + "',"
			// + equiPuntDTO.getJornada() + ")");
			// }
		}

		@Override
		protected void onPreExecute() {
			pDialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			pDialog.setProgress(values[0]);
		}

		private List<EquiPuntDTO> extraerPuntos(String cadena) {
			// Variables
			List<EquiPuntDTO> listaEquipos = new ArrayList<EquiPuntDTO>();
			List<JugPuntDTO> listaOnceIdeal = new ArrayList<JugPuntDTO>();
			EquiPuntDTO equipoOnceIdeal = new EquiPuntDTO();

			// Obtenemos la jornada
			Pattern patronJornada = Pattern
					.compile(ConstantesParametros.COMIENZO_Y_FIN_JORNADA);
			Matcher matcherJornada = patronJornada.matcher(cadena);
			if (matcherJornada.find()) {
				String jor = matcherJornada.group(1);
				// Cogemos el primer caracter
				char primerCaracter = jor.charAt(0);
				char segundoCaracter = 0;
				if (jor.charAt(1) != '\'') {
					segundoCaracter = jor.charAt(1);
					jornada = String.valueOf(primerCaracter)
							+ String.valueOf(segundoCaracter);
				} else {
					jornada = String.valueOf(primerCaracter);
				}
			}

			// Primero dividimos el texto que queremos tratar. Por equipos
			String[] textoCortado = cadena
					.split(ConstantesParametros.CADENA_PARTIR_TEXTO_INICIAL);

			Pattern patronEquipo = Pattern
					.compile(ConstantesParametros.COMIENZO_Y_FIN_EQUIPOS);
			Pattern patronJugadorNombre = Pattern
					.compile(ConstantesParametros.COMIENZO_JUGADOR);
			Pattern patronJugadorPuntos = Pattern
					.compile(ConstantesParametros.COMIENZO_PUNTOS);

			// Recorremos cada uno de los textos (por equipo). El primero no lo
			// queremos
			if (textoCortado != null && textoCortado.length > 1) {
				for (int i = 1; i < textoCortado.length; i++) {
					// Variables
					EquiPuntDTO equipo = new EquiPuntDTO();
					List<JugPuntDTO> listaJugPunt = new ArrayList<JugPuntDTO>();

					String cadenaCortada = textoCortado[i];
					// Buscamos el equipo
					Matcher matcherEquipo = patronEquipo.matcher(cadenaCortada);
					if (matcherEquipo.find()) {
						String nombreEquipo = matcherEquipo.group(1);
						// Seteamos el nombre del equipo
						equipo.setNombreEquipo(nombreEquipo);
					}

					// Variables
					String puntosJugador = null;
					String jugador = null;

					// Ahora buscamos cada uno de los jugadores de ese equipo
					// Matcher matcherJugadores = patronJugadorNombre
					// .matcher(cadenaCortada);
					String[] textoCortadoJugador = cadenaCortada
							.split(ConstantesParametros.COMIENZO_JUGADOR);

					for (int j = 1; j < textoCortadoJugador.length; j = j + 2) {
						// Variables
						JugPuntDTO jugPunt = new JugPuntDTO();
						boolean isOnceIdeal = false;

						String textoJ = textoCortadoJugador[j];
						// Partimos el String por "</a>"
						String[] jugadorSolo = textoJ
								.split(ConstantesParametros.FIN_JUGADOR);
						// Nos quedamos con el primero que es el nombre del
						// jugador
						jugador = jugadorSolo[0];
						// Si tiene <br> se lo quitamos
						// jugador = jugador.replace(
						// ConstantesParametros.SEPARADOR_APELLIDOS, " ");
						// Lo borramos de la busqueda
						// textoJ = textoJ.replaceFirst(jugadorSolo[0], "");

						String textoPuntos = textoCortadoJugador[j + 1];
						// Ahora los puntos de ese jugador
						Matcher matcherPuntos = patronJugadorPuntos
								.matcher(textoPuntos);
						if (matcherPuntos.find()) {
							String textoP = matcherPuntos.group(1);
							String[] splitJugador = textoP
									.split("<span class='numeroPuntos' style='color:");

							if (splitJugador[0]
									.contains("once_ideal/fondo.png")) {
								isOnceIdeal = true;
							}

							String textoJugCortado = splitJugador[1].substring(
									0, 10);
							// Si tiene dos digitos
							if (textoJugCortado.charAt(9) == '<') {
								puntosJugador = textoJugCortado.substring(7, 9);
							} else {
								// Sino
								puntosJugador = textoJugCortado.substring(7, 8);
							}

						}

						// Volvemos a aplicar la regla para buscar el siguiente
						// jugador
						// del equipo
						// matcherJugadores = patronJugadorNombre
						// .matcher(cadenaCortada);

						// Seteamos los valores obtenidos
						jugPunt.setNombreJugador(jugador);
						jugPunt.setPuntosJugador(puntosJugador);
						jugPunt.setOnceIdeal(isOnceIdeal);

						// Si está en el once lo añadimos al equipo del once
						// ideal
						if (isOnceIdeal) {
							listaOnceIdeal.add(jugPunt);
						}

						// Y añadimos el jugador con su puntuacion a la lista de
						// ese
						// equipo
						listaJugPunt.add(jugPunt);
					}

					// Ahora que ya tenemos todos los jugadores con sus
					// puntuaciones,
					// los añadimos al equipo
					equipo.setListaJugPuntos(listaJugPunt);
					// Calculamos los puntos
					int pntEqui = calculaPuntos(listaJugPunt);
					equipo.setPuntEquipo(pntEqui);
					// Seteamos la jornada
					// equipo.setJornada(Integer.valueOf(jornada));
					// Añadimos el equipo a la lista
					listaEquipos.add(equipo);
				}
			}
			// Equipo once ideal
			if (jornada != null) {
				equipoOnceIdeal.setJornada(Integer.valueOf(jornada));
			}
			if (listaOnceIdeal != null && listaOnceIdeal.size() > 0) {
				equipoOnceIdeal.setListaJugPuntos(listaOnceIdeal);
				// Calculamos los puntos
				int pntEqui = calculaPuntos(listaOnceIdeal);
				equipoOnceIdeal.setPuntEquipo(pntEqui);
				equipoOnceIdeal
						.setNombreEquipo(ConstantesParametros.EQUIPO_ONCE_IDEAL);
				listaEquipos.add(equipoOnceIdeal);
			}

			return listaEquipos;
		}

		private int calculaPuntos(List<JugPuntDTO> listaJugPunt) {

			int puntosEquipo = 0;
			if (listaJugPunt != null && listaJugPunt.size() > 0) {
				for (JugPuntDTO jugPuntDTO : listaJugPunt) {
					if (jugPuntDTO.getPuntosJugador() != null) {
						puntosEquipo = puntosEquipo
								+ Integer
										.valueOf(jugPuntDTO.getPuntosJugador());
					}
				}
			}
			return puntosEquipo;
		}
	}
}
