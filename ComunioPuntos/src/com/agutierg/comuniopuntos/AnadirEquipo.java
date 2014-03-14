package com.agutierg.comuniopuntos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.agutierg.comuniopuntos.components.JugadorButton;
import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.database.PuntosComunioSQLite;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;

public class AnadirEquipo extends Activity implements AdListener {

	// Componentes pantalla
	private EditText etNombreEqu;
	private Spinner spiEquipo;
	private Spinner spiPosicion;
	private Spinner spiJugador;
	private Button btnAnadirJug;
	private Button btnGuardar;

	private LinearLayout llPorteroEJ;
	private LinearLayout llDefensaEJ;
	private LinearLayout llCentrocampistaEJ;
	private LinearLayout llDelanteroEJ;

	// Variables globales
	private String equipoSelec;
	private String posicionSelec;
	private String jugadorSelec;

	private Integer idBtnJugador = 0;
	private List<Button> listjbnPortero = new ArrayList<Button>();
	private List<Button> listjbnDefensa = new ArrayList<Button>();
	private List<Button> listjbnMedio = new ArrayList<Button>();
	private List<Button> listjbnDelantero = new ArrayList<Button>();

	private Button btnEliminar;

	// Submenú
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

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

		setContentView(R.layout.activity_anadir_equipo);

		actividad = this;

		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		// Recuperamos los Spinners
		spiEquipo = (Spinner) findViewById(R.id.spiEquipo);
		spiPosicion = (Spinner) findViewById(R.id.spiPosicion);
		spiJugador = (Spinner) findViewById(R.id.spiJugador);

		// Añadimos los equipos al Spinner de Equipos
		List<String> listaEquipos = construyeListaEquipos();
		addItemsOnSpinner(spiEquipo, listaEquipos);
		// Añadimos el listener
		spiEquipo.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos el equipo por defecto
		equipoSelec = spiEquipo.getItemAtPosition(0).toString();

		// Añadimos las posiciones al Spinner de Posicion
		List<String> listaPosiciones = construyeListaPosiciones();
		addItemsOnSpinner(spiPosicion, listaPosiciones);
		// Añadimos el listener
		spiPosicion.setOnItemSelectedListener(spinerSelectedListener);

		// Añadimos el listener
		spiJugador.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos la posicion por defecto
		posicionSelec = spiPosicion.getItemAtPosition(0).toString();

		// Los layouts
		llPorteroEJ = (LinearLayout) findViewById(R.id.llPorteroEJ);
		llDefensaEJ = (LinearLayout) findViewById(R.id.llDefensaEJ);
		llCentrocampistaEJ = (LinearLayout) findViewById(R.id.llCentrocampistaEJ);
		llDelanteroEJ = (LinearLayout) findViewById(R.id.llDelanteroEJ);

		// Para el boton de añadir jugadores
		btnAnadirJug = (Button) findViewById(R.id.btnAnadirJug);

		btnAnadirJug.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				idBtnJugador++;
				int duration = Toast.LENGTH_SHORT;
				// Creamos el jugador
				JugadorButton jButtonEJ = new JugadorButton();
				Button btnJugadorEJ = jButtonEJ.devuelveBotonJugadorEJ(
						view.getContext(), idBtnJugador, equipoSelec,
						jugadorSelec);
				anadirJugador(view, duration, btnJugadorEJ);
			}

		});

		// Para guardar
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		etNombreEqu = (EditText) findViewById(R.id.etNombreEqu);

		btnGuardar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// Si hay once jugadores
				if (contarTotalJugadores() == 11) {

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

					String nombreEquipo = etNombreEqu.getText().toString();
					// Si esta rellenado
					if (nombreEquipo != null && !nombreEquipo.equals("")) {

						/**
						 * 
						 * BASE DE DATOS
						 */
						PuntosComunioSQLite baseDatosComunio = new PuntosComunioSQLite(
								view.getContext(), "DBComunioPuntos", null, 13);
						final SQLiteDatabase db = baseDatosComunio
								.getWritableDatabase();
						Integer idEquipoJug = null;
						if (db != null) {
							String[] campos = new String[] { "equJugId" };
							String condicion = "nombreEJ='" + nombreEquipo
									+ "'";
							Cursor res = null;
							try {
								res = db.query("EquipoJugador", campos,
										condicion, null, null, null, null);
							} catch (Exception e) {
								e.printStackTrace();
							}
							// Si ese nombre no está insertado
							if (!res.moveToNext()) {
								// Insertamos el equipo
								db.execSQL("INSERT INTO EquipoJugador (nombreEJ,valorEJ) VALUES ('"
										+ nombreEquipo + "', '500')");
								// Recuperamos el Id del Equipo
								campos = new String[] { "equJugId" };
								condicion = "nombreEJ='" + nombreEquipo + "'";
								try {
									Cursor resultado = db.query(
											"EquipoJugador", campos, condicion,
											null, null, null, null);
									// Si hemos encontrado registros
									if (resultado.moveToFirst()) {
										idEquipoJug = resultado.getInt(0);
									}
									// Insertamos los jugadores
									insertarJugadores(db, listjbnPortero,
											idEquipoJug);
									insertarJugadores(db, listjbnDefensa,
											idEquipoJug);
									insertarJugadores(db, listjbnMedio,
											idEquipoJug);
									insertarJugadores(db, listjbnDelantero,
											idEquipoJug);
									/**
									 * 
									 */
								} catch (Exception e) {
									e.printStackTrace();
								}
							} else {
								// NOMBRE EQUIPO REPETIDO
								CharSequence text = ConstantesParametros.ERROR_NOMBRE_EQUIPO_REPETIDO;
								Toast toast = Toast.makeText(view.getContext(),
										text, Toast.LENGTH_SHORT);
								toast.show();
							}
							// Cerramos la base de datos
							db.close();
							// Cerramos la ventana
							finish();
							// Mostramos mensaje de todo OK
							CharSequence text = ConstantesParametros.INSERT_EQUIPO_JUG_OK;
							Toast toast = Toast.makeText(view.getContext(),
									text, Toast.LENGTH_SHORT);
							toast.show();
						}
					} else {
						// NOMBRE EQUIPO
						CharSequence text = ConstantesParametros.ERROR_NOMBRE_EQUIPO;
						Toast toast = Toast.makeText(view.getContext(), text,
								Toast.LENGTH_SHORT);
						toast.show();
					}
				} else {
					// FALTAN JUGADORES
					CharSequence text = ConstantesParametros.ERROR_FALTAN_JUG;
					Toast toast = Toast.makeText(view.getContext(), text,
							Toast.LENGTH_SHORT);
					toast.show();
				}
			}

		});

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaAE);
		btnInfo = (ImageView) findViewById(R.id.btnInfoAE);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaAE);
		btnVolver = (ImageView) findViewById(R.id.btnVolverAE);
		btnRss = (ImageView) findViewById(R.id.btnRssAE);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntAE);

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
		 * LISTENERS Y COMPONENTES
		 * 
		 */

	}

	protected void insertarJugadores(SQLiteDatabase db, List<Button> listjbn,
			Integer idEquipoJug) {

		if (db != null) {

			for (Button button : listjbn) {
				Integer futbId = null;
				String[] texto = button.getText().toString().split(":\n");

				String[] campos = new String[] { "futId" };
				String condicion = "nombreFut='" + texto[1] + "'";
				try {
					Cursor resultado = db.query("Futbolista", campos,
							condicion, null, null, null, null);
					if (resultado.moveToFirst()) {
						futbId = resultado.getInt(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (futbId != null) {
					db.execSQL("INSERT INTO EquJugFutbolista (equJugId,futbolistaId) VALUES ("
							+ idEquipoJug + ", " + futbId + ")");
				}
			}
		}
	}

	private void anadirJugador(View view, int duration, Button btnJugadorEJ) {

		// Comprobamos que ese jugador no ha sido añadido
		if (!comprobarJugador()) {
			boolean isAnadido = false;
			if (contarTotalJugadores() < 11) {
				// Dependiendo de la posición de la posición
				if ((ConstantesParametros.POSICION_PORTERO_LONG)
						.equals(posicionSelec)) {
					int numPortAnadidos = llPorteroEJ.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numPortAnadidos == 0) {
						llPorteroEJ.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnPortero.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_PORTEROS;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				} else if ((ConstantesParametros.POSICION_DEFENSA_LONG)
						.equals(posicionSelec)) {
					int numDefAnadidos = llDefensaEJ.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numDefAnadidos < 5) {
						llDefensaEJ.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnDefensa.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_DEFENSAS;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				} else if ((ConstantesParametros.POSICION_MEDIO_LONG)
						.equals(posicionSelec)) {
					int numCenAnadidos = llCentrocampistaEJ.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numCenAnadidos < 6) {
						llCentrocampistaEJ.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnMedio.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_CENTRO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				} else if ((ConstantesParametros.POSICION_DELANTERO_LONG)
						.equals(posicionSelec)) {
					int numDelAnadidos = llDelanteroEJ.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numDelAnadidos < 4) {
						llDelanteroEJ.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnDelantero.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_DELANTEROS;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			} else {
				// MÁS DE 11 JUGADORES
				CharSequence text = ConstantesParametros.ERROR_ONCE_JUGADORES;
				Toast toast = Toast.makeText(view.getContext(), text, duration);
				toast.show();
			}

			// Si he añadido el boton añado el Listener
			if (isAnadido) {
				btnJugadorEJ.setOnLongClickListener(new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						btnEliminar = (Button) v;
						// Creamos el menú contextual
						AlertDialog.Builder builder = new AlertDialog.Builder(v
								.getContext());
						builder.setMessage(ConstantesParametros.MENU_CONTEX_TEX);
						builder.setCancelable(true);
						builder.setPositiveButton(
								ConstantesParametros.MENU_CONTEX_OK,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										eliminarBoton();
									}
								});
						builder.setNegativeButton(
								ConstantesParametros.MENU_CONTEX_CANCEL,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										noEliminarBoton();
									}
								});
						AlertDialog alert = builder.create();
						alert.show();
						return true;
					}
				});
			}
		} else {
			// JUGADOR YA AÑADIDO
			CharSequence text = ConstantesParametros.ERROR_JUGADOR_YA_ANADIDO;
			Toast toast = Toast.makeText(view.getContext(), text, duration);
			toast.show();
		}
	}

	private int contarTotalJugadores() {

		return llPorteroEJ.getChildCount() + llDefensaEJ.getChildCount()
				+ llCentrocampistaEJ.getChildCount()
				+ llDelanteroEJ.getChildCount();
	}

	private void eliminarBoton() {
		if (btnEliminar != null) {
			if (listjbnPortero != null && listjbnPortero.contains(btnEliminar)) {
				llPorteroEJ.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnPortero = new ArrayList<Button>();
			} else if (listjbnDefensa != null
					&& listjbnDefensa.contains(btnEliminar)) {
				llDefensaEJ.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnDefensa.remove(btnEliminar);
			} else if (listjbnMedio != null
					&& listjbnMedio.contains(btnEliminar)) {
				llCentrocampistaEJ.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnMedio.remove(btnEliminar);
			} else if (listjbnDelantero != null
					&& listjbnDelantero.contains(btnEliminar)) {
				llDelanteroEJ.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnDelantero.remove(btnEliminar);
			}
			btnEliminar = null;
		}
	}

	private void noEliminarBoton() {
		btnEliminar = null;
	}

	private boolean comprobarJugador() {

		boolean isJugadorAnadido = false;

		// Dependiendo de la posición de la posición, para el portero no hace
		// falta porq solo hay uno
		if ((ConstantesParametros.POSICION_DEFENSA_LONG).equals(posicionSelec)
				&& llDefensaEJ.getChildCount() > 0) {
			// Recorremos la lista de botones de defensas
			for (Button btnDef : listjbnDefensa) {
				String[] texto = btnDef.getText().toString().split(":\n");
				// Si es el mismo no lo anadimos
				if (equipoSelec.equals(texto[0])
						&& jugadorSelec.equals(texto[1])) {
					isJugadorAnadido = true;
					break;
				}
			}
		} else if ((ConstantesParametros.POSICION_MEDIO_LONG)
				.equals(posicionSelec)
				&& llCentrocampistaEJ.getChildCount() > 0) {
			// Recorremos la lista de botones de defensas
			for (Button btnDef : listjbnMedio) {
				String[] texto = btnDef.getText().toString().split(":\n");
				// Si es el mismo no lo anadimos
				if (equipoSelec.equals(texto[0])
						&& jugadorSelec.equals(texto[1])) {
					isJugadorAnadido = true;
					break;
				}
			}

		} else if ((ConstantesParametros.POSICION_DELANTERO_LONG)
				.equals(posicionSelec) && llDelanteroEJ.getChildCount() > 0) {
			// Recorremos la lista de botones de defensas
			for (Button btnDef : listjbnDelantero) {
				String[] texto = btnDef.getText().toString().split(":\n");
				// Si es el mismo no lo anadimos
				if (equipoSelec.equals(texto[0])
						&& jugadorSelec.equals(texto[1])) {
					isJugadorAnadido = true;
					break;
				}
			}
		}

		return isJugadorAnadido;
	}

	// Listeners para los SPINNERS
	private OnItemSelectedListener spinerSelectedListener = new Spinner.OnItemSelectedListener() {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {

			// Si hemos seleccionado un equipo
			if (parent.getId() == R.id.spiEquipo) {
				// Recogemos el valor
				equipoSelec = parent.getItemAtPosition(pos).toString();
				cargarSpinerJug();
			} // Si hemos seleccionado una posicion
			else if (parent.getId() == R.id.spiPosicion) {
				// Recogemos el valor
				posicionSelec = parent.getItemAtPosition(pos).toString();
				cargarSpinerJug();
			} // Si hemos seleccionado un jugador
			else if (parent.getId() == R.id.spiJugador) {
				jugadorSelec = parent.getItemAtPosition(pos).toString();
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};

	// Método para cargar el spiner de Jugadores
	private void cargarSpinerJug() {

		if (equipoSelec != null && posicionSelec != null) {
			List<String> listaJugadores = new ArrayList<String>();
			// Ponemos la posición buena
			String pos = null;
			if ((ConstantesParametros.POSICION_PORTERO_LONG)
					.equals(posicionSelec)) {
				pos = ConstantesParametros.POSICION_PORTERO;
			} else if ((ConstantesParametros.POSICION_DEFENSA_LONG)
					.equals(posicionSelec)) {
				pos = ConstantesParametros.POSICION_DEFENSA;
			} else if ((ConstantesParametros.POSICION_MEDIO_LONG)
					.equals(posicionSelec)) {
				pos = ConstantesParametros.POSICION_MEDIO;
			} else if ((ConstantesParametros.POSICION_DELANTERO_LONG)
					.equals(posicionSelec)) {
				pos = ConstantesParametros.POSICION_DELANTERO;
			}
			/**
			 * 
			 * BASE DE DATOS
			 */
			PuntosComunioSQLite baseDatosComunio = new PuntosComunioSQLite(
					this, "DBComunioPuntos", null, 13);
			final SQLiteDatabase db = baseDatosComunio.getWritableDatabase();
			if (db != null) {
				String[] campos = new String[] { pos, equipoSelec };
				String query = "SELECT a.nombreFut FROM Futbolista a INNER JOIN Equipo b ON a.equipoFut=b.equId WHERE a.posFut=? AND b.aliasEqu=?";
				try {
					// Ejecutamos la query
					Cursor resultado = db.rawQuery(query, campos);
					// Si hemos encontrado registros
					while (resultado.moveToNext()) {
						// Añadimos el jugador a la lista
						listaJugadores.add(resultado.getString(0));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				db.close();

				// Insertamos los nuevos
				addItemsOnSpinner(spiJugador, listaJugadores);
			}
		}

	}

	// Método que añade los equipos a una lista
	private List<String> construyeListaEquipos() {
		List<String> listaEquipos = new ArrayList<String>();

		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_ATHLETIC);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_ATLETICO);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_BARCELONA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_BETIS);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_CELTA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_ALMERIA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_ESPANOL);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_GETAFE);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_GRANADA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_LEVANTE);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_MALAGA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_ELCHE);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_OSASUNA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_RAYO);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_RMADRID);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_RSOCIEDAD);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_SEVILLA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_VALENCIA);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_VALLADOLID);
		listaEquipos.add(ConstantesParametros.EQUIPO_SEL_VILLARREAL);

		return listaEquipos;
	}

	// Método que añade las posiciones a una lista
	private List<String> construyeListaPosiciones() {
		List<String> listaPosiciones = new ArrayList<String>();

		listaPosiciones.add(ConstantesParametros.POSICION_PORTERO_LONG);
		listaPosiciones.add(ConstantesParametros.POSICION_DEFENSA_LONG);
		listaPosiciones.add(ConstantesParametros.POSICION_MEDIO_LONG);
		listaPosiciones.add(ConstantesParametros.POSICION_DELANTERO_LONG);

		return listaPosiciones;
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
