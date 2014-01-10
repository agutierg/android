package com.agutierg.comuniopuntos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class ModificarEquipo extends Activity implements AdListener {

	// Componentes pantalla
	private Spinner spiEquJugMD;
	private Spinner spiEquipoMD;
	private Spinner spiPosicionMD;
	private Spinner spiJugadorMD;
	private Button btnAnadirJugMD;
	private Button btnGuardarMD;

	// Submenú
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private LinearLayout llPorteroMD;
	private LinearLayout llDefensaMD;
	private LinearLayout llCentrocampistaMD;
	private LinearLayout llDelanteroMD;

	// Variables globales
	private String equipoSelec;
	private String posicionSelec;
	private String jugadorSelec;
	private String equiJugSelec;

	private Integer idBtnJugador = 0;
	private List<Button> listjbnPortero = new ArrayList<Button>();
	private List<Button> listjbnDefensa = new ArrayList<Button>();
	private List<Button> listjbnMedio = new ArrayList<Button>();
	private List<Button> listjbnDelantero = new ArrayList<Button>();

	private Button btnEliminar;

	private PuntosComunioSQLite baseDatosComunio;
	private HashMap<String, Integer> hashEquJug = null;
	private HashMap<Integer, String> hashEquipos = null;

	// Pantalla del dialogo
	private String equipoSelecDia;
	private String posicionSelecDia;
	private String jugadorSelecDia;
	private Spinner spiEquipoDia;
	private Spinner spiPosicionDia;
	private Spinner spiJugadorDia;
	private Button btnEliminarDia;

	private Context contexto;

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

		setContentView(R.layout.activity_modificar_equipo);

		baseDatosComunio = new PuntosComunioSQLite(this, "DBComunioPuntos",
				null, 10);

		contexto = this;

		actividad = this;

		// Recuperamos los equipos
		recuperarEquiposGeneral();
		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */
		// Los layouts
		llPorteroMD = (LinearLayout) findViewById(R.id.llPorteroMD);
		llDefensaMD = (LinearLayout) findViewById(R.id.llDefensaMD);
		llCentrocampistaMD = (LinearLayout) findViewById(R.id.llCentrocampistaMD);
		llDelanteroMD = (LinearLayout) findViewById(R.id.llDelanteroMD);

		// Recuperamos los Spinners
		spiEquipoMD = (Spinner) findViewById(R.id.spiEquipoMD);
		spiPosicionMD = (Spinner) findViewById(R.id.spiPosicionMD);
		spiJugadorMD = (Spinner) findViewById(R.id.spiJugadorMD);
		spiEquJugMD = (Spinner) findViewById(R.id.spiEquJugMD);

		// Añadimos los equipos del jugador al spinner
		List<String> listaEquJugador = construyeListaEquJugador();
		addItemsOnSpinner(spiEquJugMD, listaEquJugador);
		// Añadimos el listener
		spiEquJugMD.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos el equipo por defecto
		equiJugSelec = spiEquJugMD.getItemAtPosition(0).toString();

		// Añadimos los equipos al Spinner de Equipos
		List<String> listaEquipos = construyeListaEquipos();
		addItemsOnSpinner(spiEquipoMD, listaEquipos);
		// Añadimos el listener
		spiEquipoMD.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos el equipo por defecto
		equipoSelec = spiEquipoMD.getItemAtPosition(0).toString();

		// Añadimos las posiciones al Spinner de Posicion
		List<String> listaPosiciones = construyeListaPosiciones();
		addItemsOnSpinner(spiPosicionMD, listaPosiciones);
		// Añadimos el listener
		spiPosicionMD.setOnItemSelectedListener(spinerSelectedListener);

		// Añadimos el listener
		spiJugadorMD.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos la posicion por defecto
		posicionSelec = spiPosicionMD.getItemAtPosition(0).toString();

		// Para el boton de añadir jugadores
		btnAnadirJugMD = (Button) findViewById(R.id.btnAnadirJugMD);

		btnAnadirJugMD.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				idBtnJugador++;
				int duration = Toast.LENGTH_SHORT;
				// Creamos el jugador
				JugadorButton jButtonEJ = new JugadorButton();
				Button btnJugadorEJ = jButtonEJ.devuelveBotonJugadorEJ(
						view.getContext(), idBtnJugador, equipoSelec,
						jugadorSelec);
				anadirJugadorBoton(view, duration, btnJugadorEJ);
			}

		});

		// Para guardar
		btnGuardarMD = (Button) findViewById(R.id.btnGuardarMD);

		btnGuardarMD.setOnClickListener(new OnClickListener() {

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

						// Insertamos los jugadores
						insertarJugadores(db, listjbnPortero, equJugId);
						insertarJugadores(db, listjbnDefensa, equJugId);
						insertarJugadores(db, listjbnMedio, equJugId);
						insertarJugadores(db, listjbnDelantero, equJugId);

						// Cerramos la base de datos
						db.close();
						// Cerramos la ventana
						finish();
						// Mostramos mensaje de todo OK
						CharSequence text = ConstantesParametros.MODIF_EQUIPO_JUG_OK;
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
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaMOD);
		btnInfo = (ImageView) findViewById(R.id.btnInfoMOD);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaMOD);
		btnVolver = (ImageView) findViewById(R.id.btnVolverMOD);
		btnRss = (ImageView) findViewById(R.id.btnRssMOD);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntMOD);

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

	private void recuperarEquiposGeneral() {
		// Recuperamos los Ids de los equipos del jugador y los nombres
		SQLiteDatabase db = baseDatosComunio.getWritableDatabase();

		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			// INICIO: RECUPERAMOS LOS EQUIPOS
			hashEquipos = new HashMap<Integer, String>();
			Cursor resEquipos = null;
			try {
				// RECUPERAMOS LOS EQUIPOS DE ESE JUGADOR
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
			// Cerramos la base de datos
			db.close();
		}
	}

	// Método que carga los jugadores de un equipo
	private void cargarEquipoJugador() {

		// Recuperamos los Ids de los equipos del jugador y los nombres
		SQLiteDatabase db = baseDatosComunio.getWritableDatabase();
		int duration = Toast.LENGTH_SHORT;

		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			// Recuperamos el Id del equipo de la Hash
			Integer equJugId = hashEquJug.get(equiJugSelec);

			// INICIO: RECUPERAMOS LOS FUTBOLISTAS DE ESE JUGADOR
			String[] campos = new String[] { equJugId.toString() };
			String query = "SELECT a.nombreFut, a.equipoFut, a.posFut FROM Futbolista a INNER JOIN EquJugFutbolista b ON a.futId = b.futbolistaId WHERE b.equJugId = ?";
			try {
				// Ejecutamos la query
				Cursor resFutJug = db.rawQuery(query, campos);
				// Si hemos encontrado registros
				while (resFutJug.moveToNext()) {
					String nombreJug = resFutJug.getString(0);
					String pos = resFutJug.getString(2);
					String aliasEquFut = hashEquipos.get(resFutJug.getInt(1));

					// Añadimos el futbolista
					idBtnJugador++;
					// Creamos el jugador
					JugadorButton jButtonEJ = new JugadorButton();
					Button btnJugadorEJ = jButtonEJ.devuelveBotonJugadorEJ(
							this, idBtnJugador, aliasEquFut, nombreJug);
					anadirJugador(this, duration, btnJugadorEJ, pos,
							aliasEquFut, nombreJug);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Cerramos la base de datos
			db.close();
		}

	}

	private void anadirJugador(Context context, int duration,
			Button btnJugadorEJ, String posicion, String aliasEquFut,
			String nombreJug) {

		boolean isAnadido = false;
		// Comprobamos que ese jugador no ha sido añadido
		if (!comprobarJugador(posicion, aliasEquFut, nombreJug)) {
			if (contarTotalJugadores() < 11) {
				// Dependiendo de la posición de la posición
				if ((ConstantesParametros.POSICION_PORTERO).equals(posicion)) {
					int numPortAnadidos = llPorteroMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numPortAnadidos == 0) {
						llPorteroMD.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnPortero.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_PORTEROS;
						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				} else if ((ConstantesParametros.POSICION_DEFENSA)
						.equals(posicion)) {
					int numDefAnadidos = llDefensaMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numDefAnadidos < 5) {
						llDefensaMD.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnDefensa.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_DEFENSAS;
						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				} else if ((ConstantesParametros.POSICION_MEDIO)
						.equals(posicion)) {
					int numCenAnadidos = llCentrocampistaMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numCenAnadidos < 5) {
						llCentrocampistaMD.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnMedio.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_CENTRO;
						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				} else if ((ConstantesParametros.POSICION_DELANTERO)
						.equals(posicion)) {
					int numDelAnadidos = llDelanteroMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numDelAnadidos < 3) {
						llDelanteroMD.addView(btnJugadorEJ);
						// Lo añadimos en la lista
						listjbnDelantero.add(btnJugadorEJ);
						isAnadido = true;
					} else {
						// Pop-up error
						CharSequence text = ConstantesParametros.ERROR_MAX_DELANTEROS;
						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				}
			} else {
				// MÁS DE 11 JUGADORES
				CharSequence text = ConstantesParametros.ERROR_ONCE_JUGADORES;
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}

			// Si he añadido el boton añado el Listener
			if (isAnadido) {
				btnJugadorEJ.setOnLongClickListener(new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						onLongClickbtnJugador(v);
						return true;
					}
				});

				// CORTO
				btnJugadorEJ.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View view) {
						onClickbtnJugador(view);
					}

				});
			}
		} else {
			// JUGADOR YA AÑADIDO
			CharSequence text = ConstantesParametros.ERROR_JUGADOR_YA_ANADIDO;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}

	}

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

	private void anadirJugadorBoton(View view, int duration, Button btnJugadorEJ) {

		String pos = null;
		if (ConstantesParametros.POSICION_PORTERO_LONG.equals(posicionSelec)) {
			pos = ConstantesParametros.POSICION_PORTERO;
		} else if (ConstantesParametros.POSICION_DEFENSA_LONG
				.equals(posicionSelec)) {
			pos = ConstantesParametros.POSICION_DEFENSA;
		} else if (ConstantesParametros.POSICION_MEDIO_LONG
				.equals(posicionSelec)) {
			pos = ConstantesParametros.POSICION_MEDIO;
		} else if (ConstantesParametros.POSICION_DELANTERO_LONG
				.equals(posicionSelec)) {
			pos = ConstantesParametros.POSICION_DELANTERO;
		}
		// Comprobamos que ese jugador no ha sido añadido
		if (!comprobarJugador(pos, equipoSelec, jugadorSelec)) {
			boolean isAnadido = false;
			if (contarTotalJugadores() < 11) {
				// Dependiendo de la posición de la posición
				if ((ConstantesParametros.POSICION_PORTERO_LONG)
						.equals(posicionSelec)) {
					int numPortAnadidos = llPorteroMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numPortAnadidos == 0) {
						llPorteroMD.addView(btnJugadorEJ);
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
					int numDefAnadidos = llDefensaMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numDefAnadidos < 5) {
						llDefensaMD.addView(btnJugadorEJ);
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
					int numCenAnadidos = llCentrocampistaMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numCenAnadidos < 5) {
						llCentrocampistaMD.addView(btnJugadorEJ);
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
					int numDelAnadidos = llDelanteroMD.getChildCount();
					// Si no hay ninguno lo añadimos
					if (numDelAnadidos < 3) {
						llDelanteroMD.addView(btnJugadorEJ);
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
				// LARGO
				btnJugadorEJ.setOnLongClickListener(new OnLongClickListener() {

					@Override
					public boolean onLongClick(View v) {
						onLongClickbtnJugador(v);
						return true;
					}
				});

				// CORTO
				btnJugadorEJ.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View view) {
						onClickbtnJugador(view);
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

	// Click CORTO
	private void onClickbtnJugador(View view) {
		btnEliminarDia = (Button) view;

		// Creamos el menú contextual
		AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vista = inflater.inflate(R.layout.dialog_modificar_equipo, null);

		spiEquipoDia = (Spinner) vista.findViewById(R.id.spiEquipoDia);
		spiPosicionDia = (Spinner) vista.findViewById(R.id.spiPosicionDia);
		spiJugadorDia = (Spinner) vista.findViewById(R.id.spiJugadorDia);

		// Cargamos los spinners
		cargarSpinnersDialogo();

		// Cargamos los valores del jugador seleccionado
		precargarValoresDialogo(btnEliminarDia);

		builder.setView(vista);
		builder.setMessage(ConstantesParametros.MENU_CONTEX_MOD);
		builder.setCancelable(true);
		builder.setPositiveButton(ConstantesParametros.MENU_CONTEX_OK,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						int duration = Toast.LENGTH_SHORT;
						String pos = null;
						if (ConstantesParametros.POSICION_PORTERO_LONG
								.equals(posicionSelecDia)) {
							pos = ConstantesParametros.POSICION_PORTERO;
						} else if (ConstantesParametros.POSICION_DEFENSA_LONG
								.equals(posicionSelecDia)) {
							pos = ConstantesParametros.POSICION_DEFENSA;
						} else if (ConstantesParametros.POSICION_MEDIO_LONG
								.equals(posicionSelecDia)) {
							pos = ConstantesParametros.POSICION_MEDIO;
						} else if (ConstantesParametros.POSICION_DELANTERO_LONG
								.equals(posicionSelecDia)) {
							pos = ConstantesParametros.POSICION_DELANTERO;
						}
						// Si el jugador que voy a añadir no esta ya insertado
						if (!comprobarJugador(pos, equipoSelecDia,
								jugadorSelecDia)) {
							eliminarBotonDia();
							idBtnJugador++;
							// Creamos el jugador
							JugadorButton jButtonEJ = new JugadorButton();
							Button btnJugadorEJ = jButtonEJ
									.devuelveBotonJugadorEJ(contexto,
											idBtnJugador, equipoSelecDia,
											jugadorSelecDia);
							anadirJugador(contexto, duration, btnJugadorEJ,
									pos, equipoSelecDia, jugadorSelecDia);
						} else {
							// JUGADOR YA AÑADIDO
							CharSequence text = ConstantesParametros.ERROR_JUGADOR_YA_ANADIDO;
							Toast toast = Toast.makeText(contexto, text,
									duration);
							toast.show();
						}

					}
				});
		builder.setNegativeButton(ConstantesParametros.MENU_CONTEX_CANCEL,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						noEliminarBotonDia();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}

	private void noEliminarBotonDia() {
		btnEliminarDia = null;
	}

	private void eliminarBotonDia() {
		if (btnEliminarDia != null) {
			if (listjbnPortero != null
					&& listjbnPortero.contains(btnEliminarDia)) {
				llPorteroMD.removeView(btnEliminarDia);
				// Reseteamos la lista de porteros
				listjbnPortero = new ArrayList<Button>();
			} else if (listjbnDefensa != null
					&& listjbnDefensa.contains(btnEliminarDia)) {
				llDefensaMD.removeView(btnEliminarDia);
				// Reseteamos la lista de porteros
				listjbnDefensa.remove(btnEliminarDia);
			} else if (listjbnMedio != null
					&& listjbnMedio.contains(btnEliminarDia)) {
				llCentrocampistaMD.removeView(btnEliminarDia);
				// Reseteamos la lista de porteros
				listjbnMedio.remove(btnEliminarDia);
			} else if (listjbnDelantero != null
					&& listjbnDelantero.contains(btnEliminarDia)) {
				llDelanteroMD.removeView(btnEliminarDia);
				// Reseteamos la lista de porteros
				listjbnDelantero.remove(btnEliminarDia);
			}
			btnEliminarDia = null;
		}
	}

	private void precargarValoresDialogo(Button btnSelec) {
		String[] texto = btnSelec.getText().toString().split(":\n");
		String equipo = texto[0];
		// Seleccionamos el equipo
		spiEquipoDia.setSelection(selectItemPosition(equipo, spiEquipoDia));
		String posicion = null;
		if (listjbnPortero != null && listjbnPortero.contains(btnSelec)) {
			posicion = ConstantesParametros.POSICION_PORTERO_LONG;
		} else if (listjbnDefensa != null && listjbnDefensa.contains(btnSelec)) {
			posicion = ConstantesParametros.POSICION_DEFENSA_LONG;
		} else if (listjbnMedio != null && listjbnMedio.contains(btnSelec)) {
			posicion = ConstantesParametros.POSICION_MEDIO_LONG;
		} else if (listjbnDelantero != null
				&& listjbnDelantero.contains(btnSelec)) {
			posicion = ConstantesParametros.POSICION_DELANTERO_LONG;
		}
		if (posicion != null) {
			spiPosicionDia.setSelection(selectItemPosition(posicion,
					spiPosicionDia));
		}
		String nombre = texto[1];
		jugadorSelecDia = nombre;
	}

	private void cargarSpinnersDialogo() {
		// Añadimos los equipos al Spinner de Equipos
		List<String> listaEquipos = construyeListaEquipos();
		addItemsOnSpinner(spiEquipoDia, listaEquipos);
		// Añadimos el listener
		spiEquipoDia.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos el equipo por defecto
		equipoSelecDia = spiEquipoDia.getItemAtPosition(0).toString();

		// Añadimos las posiciones al Spinner de Posicion
		List<String> listaPosiciones = construyeListaPosiciones();
		addItemsOnSpinner(spiPosicionDia, listaPosiciones);
		// Añadimos el listener
		spiPosicionDia.setOnItemSelectedListener(spinerSelectedListener);
		// Recogemos la posicion por defecto
		posicionSelecDia = spiPosicionDia.getItemAtPosition(0).toString();

		// Añadimos el listener
		spiJugadorDia.setOnItemSelectedListener(spinerSelectedListener);
	}

	private Integer selectItemPosition(String item, Spinner spin) {

		for (int i = 0; i < spin.getCount(); i++) {
			if (spin.getItemAtPosition(i).equals(item)) {
				return i;
			}
		}
		return 0;
	}

	// Click LARGO
	private void onLongClickbtnJugador(View v) {
		btnEliminar = (Button) v;
		// Creamos el menú contextual
		AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
		builder.setMessage(ConstantesParametros.MENU_CONTEX_TEX);
		builder.setCancelable(true);
		builder.setPositiveButton(ConstantesParametros.MENU_CONTEX_OK,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						eliminarBoton();
					}
				});
		builder.setNegativeButton(ConstantesParametros.MENU_CONTEX_CANCEL,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						noEliminarBoton();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	private int contarTotalJugadores() {

		return llPorteroMD.getChildCount() + llDefensaMD.getChildCount()
				+ llCentrocampistaMD.getChildCount()
				+ llDelanteroMD.getChildCount();
	}

	private void eliminarBoton() {
		if (btnEliminar != null) {
			if (listjbnPortero != null && listjbnPortero.contains(btnEliminar)) {
				llPorteroMD.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnPortero = new ArrayList<Button>();
			} else if (listjbnDefensa != null
					&& listjbnDefensa.contains(btnEliminar)) {
				llDefensaMD.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnDefensa.remove(btnEliminar);
			} else if (listjbnMedio != null
					&& listjbnMedio.contains(btnEliminar)) {
				llCentrocampistaMD.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnMedio.remove(btnEliminar);
			} else if (listjbnDelantero != null
					&& listjbnDelantero.contains(btnEliminar)) {
				llDelanteroMD.removeView(btnEliminar);
				// Reseteamos la lista de porteros
				listjbnDelantero.remove(btnEliminar);
			}
			btnEliminar = null;
		}
	}

	private void noEliminarBoton() {
		btnEliminar = null;
	}

	private boolean comprobarJugador(String posicion, String aliasEquFut,
			String nombreJug) {

		boolean isJugadorAnadido = false;

		// Dependiendo de la posición de la posición, para el portero no hace
		// falta porq solo hay uno
		if ((ConstantesParametros.POSICION_DEFENSA).equals(posicion)
				&& llDefensaMD.getChildCount() > 0) {
			// Recorremos la lista de botones de defensas
			for (Button btnDef : listjbnDefensa) {
				String[] texto = btnDef.getText().toString().split(":\n");
				// Si es el mismo no lo anadimos
				if (aliasEquFut.equals(texto[0]) && nombreJug.equals(texto[1])) {
					isJugadorAnadido = true;
					break;
				}
			}
		} else if ((ConstantesParametros.POSICION_MEDIO).equals(posicion)
				&& llCentrocampistaMD.getChildCount() > 0) {
			// Recorremos la lista de botones de defensas
			for (Button btnDef : listjbnMedio) {
				String[] texto = btnDef.getText().toString().split(":\n");
				// Si es el mismo no lo anadimos
				if (aliasEquFut.equals(texto[0]) && nombreJug.equals(texto[1])) {
					isJugadorAnadido = true;
					break;
				}
			}

		} else if ((ConstantesParametros.POSICION_DELANTERO).equals(posicion)
				&& llDelanteroMD.getChildCount() > 0) {
			// Recorremos la lista de botones de defensas
			for (Button btnDef : listjbnDelantero) {
				String[] texto = btnDef.getText().toString().split(":\n");
				// Si es el mismo no lo anadimos
				if (aliasEquFut.equals(texto[0]) && nombreJug.equals(texto[1])) {
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
			if (parent.getId() == R.id.spiEquipoMD) {
				// Recogemos el valor
				equipoSelec = parent.getItemAtPosition(pos).toString();
				cargarSpinerJug();
			} // Si hemos seleccionado una posicion
			else if (parent.getId() == R.id.spiPosicionMD) {
				// Recogemos el valor
				posicionSelec = parent.getItemAtPosition(pos).toString();
				cargarSpinerJug();
			} // Si hemos seleccionado un jugador
			else if (parent.getId() == R.id.spiJugadorMD) {
				jugadorSelec = parent.getItemAtPosition(pos).toString();
			} else if (parent.getId() == R.id.spiEquJugMD) {
				equiJugSelec = parent.getItemAtPosition(pos).toString();
				// Borramos todo lo relativo a los jugadores
				borrarEquipo();
				cargarEquipoJugador();
			}// Si hemos seleccionado un jugador
			else if (parent.getId() == R.id.spiJugadorDia) {
				jugadorSelecDia = parent.getItemAtPosition(pos).toString();
			}// Si hemos seleccionado un jugador
			else if (parent.getId() == R.id.spiEquipoDia) {
				equipoSelecDia = parent.getItemAtPosition(pos).toString();
				cargarSpinerJugDia();
			}// Si hemos seleccionado un jugador
			else if (parent.getId() == R.id.spiPosicionDia) {
				posicionSelecDia = parent.getItemAtPosition(pos).toString();
				cargarSpinerJugDia();
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
				addItemsOnSpinner(spiJugadorMD, listaJugadores);
			}
		}

	}

	// Método para cargar el spiner de Jugadores del Dialogo
	private void cargarSpinerJugDia() {

		if (equipoSelecDia != null && posicionSelecDia != null) {
			List<String> listaJugadores = new ArrayList<String>();
			// Ponemos la posición buena
			String pos = null;
			if ((ConstantesParametros.POSICION_PORTERO_LONG)
					.equals(posicionSelecDia)) {
				pos = ConstantesParametros.POSICION_PORTERO;
			} else if ((ConstantesParametros.POSICION_DEFENSA_LONG)
					.equals(posicionSelecDia)) {
				pos = ConstantesParametros.POSICION_DEFENSA;
			} else if ((ConstantesParametros.POSICION_MEDIO_LONG)
					.equals(posicionSelecDia)) {
				pos = ConstantesParametros.POSICION_MEDIO;
			} else if ((ConstantesParametros.POSICION_DELANTERO_LONG)
					.equals(posicionSelecDia)) {
				pos = ConstantesParametros.POSICION_DELANTERO;
			}
			/**
			 * 
			 * BASE DE DATOS
			 */
			final SQLiteDatabase db = baseDatosComunio.getWritableDatabase();
			if (db != null) {
				String[] campos = new String[] { pos, equipoSelecDia };
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
				addItemsOnSpinner(spiJugadorDia, listaJugadores);
			}
		}

		if (jugadorSelecDia != null) {
			spiJugadorDia.setSelection(selectItemPosition(jugadorSelecDia,
					spiJugadorDia));
		}

	}

	private void borrarEquipo() {

		// Primero las listas de botones
		listjbnPortero = new ArrayList<Button>();
		listjbnDefensa = new ArrayList<Button>();
		listjbnMedio = new ArrayList<Button>();
		listjbnDelantero = new ArrayList<Button>();

		// Luegos los frame
		llPorteroMD.removeAllViews();
		llDefensaMD.removeAllViews();
		llCentrocampistaMD.removeAllViews();
		llDelanteroMD.removeAllViews();
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
