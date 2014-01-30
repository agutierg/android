package com.agutierg.hits2013.vistas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

import com.agutierg.hits2013.R;
import com.agutierg.hits2013.constants.ConstantesParametros;
import com.agutierg.hits2013.constants.ConsultasSQL;
import com.agutierg.hits2013.database.Temazos2013SQLite;
import com.agutierg.hits2013.dto.Cancion;
import com.agutierg.hits2013.dto.ListaCanciones;
import com.agutierg.hits2013.utils.CancionFunctions;

public class Main extends Activity {

	private Temazos2013SQLite baseDatosTemazos;

	private Button btnBest;
	private Button btnNew;
	private Button btnHits;
	private Button btnLatin;
	private Button btnFreak;
	private Button btnQuiz;
	private Button btnRequest;
	private Button btnLinks;

	private ProgressDialog pDialog;
	private TareaInicialBDTask tarea;

	private List<Cancion> listaCancionesDBRemota;
	private boolean hayCanciones;

	private Context contexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		contexto = this;

		/**
		 * LISTENERS
		 */
		btnBest = (Button) findViewById(R.id.btnBest);
		btnNew = (Button) findViewById(R.id.btnNew);
		btnHits = (Button) findViewById(R.id.btnHits);
		btnLatin = (Button) findViewById(R.id.btnLatin);
		btnFreak = (Button) findViewById(R.id.btnFreak);
		btnQuiz = (Button) findViewById(R.id.btnQuiz);
		btnRequest = (Button) findViewById(R.id.btnRequest);
		btnLinks = (Button) findViewById(R.id.btnLinks);

		/**
		 * LISTENERS
		 */

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosTemazos = new Temazos2013SQLite(this, "DBTemazos", null, 2);
		SQLiteDatabase db = baseDatosTemazos.getWritableDatabase();

		btnBest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaP = new Intent(view.getContext(),
						VistaPrincipal.class);
				vistaP.putExtra(ConstantesParametros.BOTON_PULSADO,
						ConstantesParametros.CANCIONES_BEST);
				ListaCanciones lista = new ListaCanciones(
						listaCancionesDBRemota);
				vistaP.putExtra(ConstantesParametros.LISTA_CANCIONES, lista);
				startActivityForResult(vistaP,
						Integer.valueOf(ConstantesParametros.CANCIONES_NEW));
			}
		});

		btnNew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaP = new Intent(view.getContext(),
						VistaPrincipal.class);
				vistaP.putExtra(ConstantesParametros.BOTON_PULSADO,
						ConstantesParametros.CANCIONES_NEW);
				ListaCanciones lista = new ListaCanciones(
						listaCancionesDBRemota);
				vistaP.putExtra(ConstantesParametros.LISTA_CANCIONES, lista);
				startActivityForResult(vistaP,
						Integer.valueOf(ConstantesParametros.CANCIONES_NEW));
			}
		});

		btnHits.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaP = new Intent(view.getContext(),
						VistaPrincipal.class);
				vistaP.putExtra(ConstantesParametros.BOTON_PULSADO,
						ConstantesParametros.CANCIONES);
				ListaCanciones lista = new ListaCanciones(
						listaCancionesDBRemota);
				vistaP.putExtra(ConstantesParametros.LISTA_CANCIONES, lista);
				startActivityForResult(vistaP,
						Integer.valueOf(ConstantesParametros.CANCIONES));
			}
		});

		btnLatin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaP = new Intent(view.getContext(),
						VistaPrincipal.class);
				vistaP.putExtra(ConstantesParametros.BOTON_PULSADO,
						ConstantesParametros.CANCIONES_LATIN);
				ListaCanciones lista = new ListaCanciones(
						listaCancionesDBRemota);
				vistaP.putExtra(ConstantesParametros.LISTA_CANCIONES, lista);
				startActivityForResult(vistaP,
						Integer.valueOf(ConstantesParametros.CANCIONES_LATIN));
			}
		});

		btnFreak.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaP = new Intent(view.getContext(),
						VistaPrincipal.class);
				vistaP.putExtra(ConstantesParametros.BOTON_PULSADO,
						ConstantesParametros.CANCIONES_FREAK);
				ListaCanciones lista = new ListaCanciones(
						listaCancionesDBRemota);
				vistaP.putExtra(ConstantesParametros.LISTA_CANCIONES, lista);
				startActivityForResult(vistaP,
						Integer.valueOf(ConstantesParametros.CANCIONES_FREAK));
			}
		});

		btnRequest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaR = new Intent(view.getContext(), Request.class);
				startActivityForResult(vistaR,
						Integer.valueOf(ConstantesParametros.CANCIONES_REQUEST));
			}
		});

		btnLinks.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaL = new Intent(view.getContext(), Links.class);
				startActivityForResult(vistaL,
						Integer.valueOf(ConstantesParametros.CANCIONES_LINKS));
			}
		});

		btnQuiz.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/details?id=com.agutierg.quizvideojuegos&feature=search_result#?t=W251bGwsMSwxLDEsImNvbS5hZ3V0aWVyZy5xdWl6dmlkZW9qdWVnb3MiXQ..")));
			}
		});

		// Primero miramos si ya hemos entrado hoy
		listaCancionesDBRemota = recuperarCanciones();
		boolean ejecutarTarea = true;

		if (listaCancionesDBRemota != null && listaCancionesDBRemota.size() > 0) {
			hayCanciones = true;
			// Cogemos la primera y vemos la fecha
			Cancion alAzar = listaCancionesDBRemota.get(0);
			Date fechaInsert = alAzar.getInsertDate();
			if (fechaInsert != null) {
				Calendar fechaActual = Calendar.getInstance();
				Calendar fechaI = Calendar.getInstance();
				fechaI.setTime(fechaInsert);

				fechaActual.add(Calendar.DAY_OF_MONTH, -1);

				int mesActual = fechaActual.get(Calendar.MONTH);
				int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);

				int mesInsert = fechaI.get(Calendar.MONTH);
				int diaInsert = fechaI.get(Calendar.DAY_OF_MONTH);

				// Si son iguales, nos quedamos con la base de datos
				if ((mesActual == mesInsert) && (diaActual <= diaInsert)) {
					ejecutarTarea = false;
				} else {
					ejecutarTarea = true;
				}
			}
		} else {
			hayCanciones = false;
			ejecutarTarea = true;
		}

		// Si hay que ejecutar la tarea
		if (ejecutarTarea) {
			/**
			 * 
			 * 
			 * TAREA
			 * 
			 */
			pDialog = new ProgressDialog(Main.this);
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setMessage("Downloading Data...");
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

			tarea = new TareaInicialBDTask();
			tarea.execute();
			/**
			 * 
			 * 
			 * TAREA
			 * 
			 */
		}
	}

	private List<Cancion> recuperarCanciones() {
		List<Cancion> listaReturn = new ArrayList<Cancion>();

		// Recuperamos las publicaciones del tipo que nos hayan pasado
		SQLiteDatabase db = baseDatosTemazos.getWritableDatabase();
		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			Cursor resCanciones = null;
			try {
				// RECUPERAMOS LAS CANCIONES
				resCanciones = db.query("Cancion", null, null, null, null,
						null, null);
				// Si hay resultados
				while (resCanciones.moveToNext()) {
					Cancion cancion = new Cancion();
					cancion.setIdCancion(resCanciones.getInt(0));
					cancion.setTitulo(resCanciones.getString(1));
					cancion.setUrl(resCanciones.getString(2));
					cancion.setCantante(resCanciones.getString(3));
					cancion.setDuracion(resCanciones.getString(4));
					cancion.setTipo(resCanciones.getString(5));
					cancion.setUrlDescarga(resCanciones.getString(6));
					cancion.setVotos(resCanciones.getInt(7));
					String fecha = resCanciones.getString(8);
					Date fechaInsert = new SimpleDateFormat("yyyy-MM-dd",
							Locale.ENGLISH).parse(fecha);
					cancion.setInsertDate(fechaInsert);
					listaReturn.add(cancion);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Cerramos la base de datos
			db.close();
		}
		return listaReturn;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onBackPressed() {

		// Creamos el menú contextual
		AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
		builder.setMessage(getApplicationContext().getString(
				R.string.preguntaapp));
		builder.setCancelable(true);
		builder.setPositiveButton(ConstantesParametros.MENU_CONTEX_OK,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						startActivity(new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("https://play.google.com/store/apps/details?id=com.agutierg.hits2013")));
					}
				});
		builder.setNegativeButton(ConstantesParametros.MENU_CONTEX_CANCEL,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						finish();
						System.exit(0);
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
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

			CancionFunctions canciones = new CancionFunctions();
			listaCancionesDBRemota = canciones.obtenerCanciones();
			return null;

		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			SQLiteDatabase db = baseDatosTemazos.getWritableDatabase();
			if (listaCancionesDBRemota != null
					&& listaCancionesDBRemota.size() > 0) {
				borrarCanciones(db);
				insertCanciones(db, listaCancionesDBRemota);
				db.close();
			} else {
				if (!hayCanciones) {
					// Si no hay canciones del servidor
					insertCancionesFreaks(db);
					insertCanciones2(db);
					insertCancionesNew(db);
					insertCancionesLatin(db);
				}
				db.close();
			}
			// Cerramos
			pDialog.dismiss();
		}

		private void borrarCanciones(SQLiteDatabase db) {
			String deleteSQL = "DELETE FROM Cancion";
			db.execSQL(deleteSQL);
		}

		private void insertCanciones(SQLiteDatabase db,
				List<Cancion> listaCanciones) {

			for (Cancion cancion : listaCanciones) {
				db.execSQL("INSERT INTO Cancion (idCancion,cantante,url,titulo,duracion,tipo,urlDescarga,votos,insertDate) VALUES ("
						+ cancion.getIdCancion()
						+ ",'"
						+ cancion.getCantante()
						+ "','"
						+ cancion.getUrl()
						+ "','"
						+ cancion.getTitulo()
						+ "','"
						+ cancion.getDuracion()
						+ "','"
						+ cancion.getTipo()
						+ "','"
						+ cancion.getUrlDescarga()
						+ "',"
						+ cancion.getVotos()
						+ ",current_timestamp)");
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

	/**
	 * 
	 * Inserts de los Freaks
	 */
	private void insertCancionesFreaks(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_CHIP_TORRES);
		db.execSQL(ConsultasSQL.INSERT_CANCION_COBRA_TAKA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_GALLO_KENTUCKY);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PETER_ANGUILA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PIO);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PSY);
		db.execSQL(ConsultasSQL.INSERT_CANCION_RAFA_MORA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_SOY_CANI);
		db.execSQL(ConsultasSQL.INSERT_CANCION_CACHICHURRIS);
		db.execSQL(ConsultasSQL.INSERT_CANCION_COMO_SE_MATA_GUSANO);
		db.execSQL(ConsultasSQL.INSERT_CANCION_CRL_ALT);
		db.execSQL(ConsultasSQL.INSERT_CANCION_KO);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LA_VACA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_MAZORKA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_OLA_KASE);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PAJEA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_SANTA_CLAUS);
		db.execSQL(ConsultasSQL.INSERT_CANCION_TOCAME_EL_WINDOWS);
		db.execSQL(ConsultasSQL.INSERT_CANCION_UN_BYTE);
	}

	/**
	 * 
	 * Inserts de las Canciones
	 */
	private void insertCanciones2(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_1);
		db.execSQL(ConsultasSQL.INSERT_CANCION_2);
		db.execSQL(ConsultasSQL.INSERT_CANCION_3);
		db.execSQL(ConsultasSQL.INSERT_CANCION_4);
		db.execSQL(ConsultasSQL.INSERT_CANCION_5);
		db.execSQL(ConsultasSQL.INSERT_CANCION_6);
		db.execSQL(ConsultasSQL.INSERT_CANCION_7);
		db.execSQL(ConsultasSQL.INSERT_CANCION_8);
		db.execSQL(ConsultasSQL.INSERT_CANCION_9);
		db.execSQL(ConsultasSQL.INSERT_CANCION_10);
		db.execSQL(ConsultasSQL.INSERT_CANCION_11);
		db.execSQL(ConsultasSQL.INSERT_CANCION_12);
		db.execSQL(ConsultasSQL.INSERT_CANCION_13);
		db.execSQL(ConsultasSQL.INSERT_CANCION_14);
		db.execSQL(ConsultasSQL.INSERT_CANCION_15);
		db.execSQL(ConsultasSQL.INSERT_CANCION_16);
		db.execSQL(ConsultasSQL.INSERT_CANCION_17);
		db.execSQL(ConsultasSQL.INSERT_CANCION_18);
		db.execSQL(ConsultasSQL.INSERT_CANCION_19);
		db.execSQL(ConsultasSQL.INSERT_CANCION_20);
		db.execSQL(ConsultasSQL.INSERT_CANCION_21);
		db.execSQL(ConsultasSQL.INSERT_CANCION_22);
		db.execSQL(ConsultasSQL.INSERT_CANCION_23);
		db.execSQL(ConsultasSQL.INSERT_CANCION_24);
		db.execSQL(ConsultasSQL.INSERT_CANCION_25);
		db.execSQL(ConsultasSQL.INSERT_CANCION_26);
		db.execSQL(ConsultasSQL.INSERT_CANCION_27);
		db.execSQL(ConsultasSQL.INSERT_CANCION_28);
		db.execSQL(ConsultasSQL.INSERT_CANCION_29);
		db.execSQL(ConsultasSQL.INSERT_CANCION_30);
		db.execSQL(ConsultasSQL.INSERT_CANCION_31);
		db.execSQL(ConsultasSQL.INSERT_CANCION_32);
	}

	/**
	 * 
	 * Inserts de las Canciones Nuevas
	 */
	private void insertCancionesNew(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_1);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_2);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_3);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_4);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_5);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_6);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_7);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_8);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_9);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_10);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_11);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_12);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_13);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_14);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_15);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_16);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_17);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_18);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_19);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_20);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_21);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_22);

	}

	/**
	 * 
	 * Inserts de las Canciones Nuevas
	 */
	private void insertCancionesLatin(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_1);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_2);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_3);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_4);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_5);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_6);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_7);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_8);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_9);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_10);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_11);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_12);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_13);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_14);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_15);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_16);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_17);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_18);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_19);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_20);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_21);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_22);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_23);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_24);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_25);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_26);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_27);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_28);

	}
}
