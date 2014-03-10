package com.agutierg.comuniopuntos;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.agutierg.comuniopuntos.components.JugadorButton;
import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.database.PuntosComunioSQLite;
import com.agutierg.comuniopuntos.dto.EquiPuntDTO;
import com.agutierg.comuniopuntos.dto.EquiPuntSerializable;
import com.agutierg.comuniopuntos.dto.JugPuntDTO;

public class PuntosGeneralesEquipo extends Activity {

	private EquiPuntSerializable puntosYEquipos;
	private String equipoSelec;
	private Integer puntosEquipo;

	// Submenú
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private LinearLayout llPortero;
	private LinearLayout llDefensa;
	private LinearLayout llDefensa2;
	private LinearLayout llMedio;
	private LinearLayout llMedio2;
	private LinearLayout llDelantero;
	private LinearLayout llDelantero2;

	private ImageView ivEquiPGE;
	private TextView tvPuntosEquipo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_puntos_generales_equipos);

		// Recogemos los puntos de los equipos que vienen por parámetro
		Bundle bundle = getIntent().getExtras();
		if (bundle.getSerializable(ConstantesParametros.EQUIPOS_Y_PUNTOS) != null) {
			puntosYEquipos = (EquiPuntSerializable) bundle
					.getSerializable(ConstantesParametros.EQUIPOS_Y_PUNTOS);
			equipoSelec = puntosYEquipos.getEquSeleccionado();
		}

		/**
		 * Elementos y acciones de los elementos
		 */

		// LAYOUTS DE PORTERO, DEFENSA, MEDIO Y DELANTEROS
		llPortero = (LinearLayout) findViewById(R.id.llPortero);
		llDefensa = (LinearLayout) findViewById(R.id.llDefensa);
		llDefensa2 = (LinearLayout) findViewById(R.id.llDefensa2);
		llMedio = (LinearLayout) findViewById(R.id.llMedio);
		llMedio2 = (LinearLayout) findViewById(R.id.llMedio2);
		llDelantero = (LinearLayout) findViewById(R.id.llDelantero);
		llDelantero2 = (LinearLayout) findViewById(R.id.llDelantero2);

		// Añadimos jugadores y puntos individuales
		JugadorButton jButton = new JugadorButton();

		if (puntosYEquipos != null) {
			List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
					.getListaEquPuntos();
			if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
				for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
					if (equiPuntDTO.getNombreEquipo().equals(equipoSelec)) {
						List<JugPuntDTO> jugPuntuaciones = equiPuntDTO
								.getListaJugPuntos();
						puntosEquipo = equiPuntDTO.getPuntEquipo();
						int identificador = 1;
						for (JugPuntDTO jugPuntDTO : jugPuntuaciones) {
							// Creamos el boton
							Button btnAnadir = jButton.devuelveBotonJugador(
									this, identificador, jugPuntDTO,
									equipoSelec);
							// Añadir según posicion
							anadirSegunPosicion(btnAnadir, jugPuntDTO);
							identificador++;
						}

					}
				}
			}

		}

		// Añadimos el logo del equipo
		ivEquiPGE = (ImageView) findViewById(R.id.ivEquiPGE);
		cambiarIconoEquipo();

		// Calculamos los puntos generales
		tvPuntosEquipo = (TextView) findViewById(R.id.tvPuntosEquipo);
		tvPuntosEquipo.setText(tvPuntosEquipo.getText()
				+ puntosEquipo.toString());

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaPGE);
		btnInfo = (ImageView) findViewById(R.id.btnInfoPGE);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaPGE);
		btnVolver = (ImageView) findViewById(R.id.btnVolverPGE);
		btnRss = (ImageView) findViewById(R.id.btnRssPGE);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntPGE);

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

	private void cambiarIconoEquipo() {
		if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ATHLETIC)) {
			ivEquiPGE.setImageResource(R.drawable.athletic_bilbao_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ATLETICO)) {
			ivEquiPGE.setImageResource(R.drawable.atletico_madrid_icon);
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_BARCELONA)) {
			ivEquiPGE.setImageResource(R.drawable.barcelona_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_BETIS)) {
			ivEquiPGE.setImageResource(R.drawable.real_betis_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_CELTA)) {
			ivEquiPGE.setImageResource(R.drawable.celta_de_vigo_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ALMERIA)) {
			ivEquiPGE.setImageResource(R.drawable.almeria_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ESPANOL)) {
			ivEquiPGE.setImageResource(R.drawable.espanyol_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_GETAFE)) {
			ivEquiPGE.setImageResource(R.drawable.getafe_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_GRANADA)) {
			ivEquiPGE.setImageResource(R.drawable.granada_cf);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_LEVANTE)) {
			ivEquiPGE.setImageResource(R.drawable.logo_levante);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_MALAGA)) {
			ivEquiPGE.setImageResource(R.drawable.malaga_cf_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ELCHE)) {
			ivEquiPGE.setImageResource(R.drawable.elche_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_OSASUNA)) {
			ivEquiPGE.setImageResource(R.drawable.osasuna_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_RAYO)) {
			ivEquiPGE.setImageResource(R.drawable.rayo_vallecano_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_RMADRID)) {
			ivEquiPGE.setImageResource(R.drawable.real_madrid_icon);
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_RSOCIEDAD)) {
			ivEquiPGE.setImageResource(R.drawable.real_sociedad_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_SEVILLA)) {
			ivEquiPGE.setImageResource(R.drawable.sevilla_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_VALENCIA)) {
			ivEquiPGE.setImageResource(R.drawable.valencia_icon);
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_VALLADOLID)) {
			ivEquiPGE.setImageResource(R.drawable.real_valladolid_icon);
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_VILLARREAL)) {
			ivEquiPGE.setImageResource(R.drawable.villarreal_icon);
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_ONCE_IDEAL)) {
			ivEquiPGE.setImageResource(R.drawable.tshirt_onceid70);
		}
	}

	// Método que añade el jugador según la posición
	private void anadirSegunPosicion(Button btnAnadir, JugPuntDTO jugPuntDTO) {

		/**
		 * 
		 * BASE DE DATOS
		 */
		PuntosComunioSQLite baseDatosComunio = new PuntosComunioSQLite(this,
				"DBComunioPuntos", null, 13);
		final SQLiteDatabase db = baseDatosComunio.getWritableDatabase();
		if (db != null) {
			String[] campos = new String[] { "posFut" };
			String condicion = "nombreFut='" + jugPuntDTO.getNombreJugador()
					+ "'";
			try {
				Cursor resultado = db.query("Futbolista", campos, condicion,
						null, null, null, null);
				// Si hemos encontrado registros
				if (resultado.moveToFirst()) {
					// Si es PORTERO
					if (resultado.getString(0) != null
							&& (ConstantesParametros.POSICION_PORTERO)
									.equals(resultado.getString(0))) {
						llPortero.addView(btnAnadir);
					} // Si es DEFENSA
					else if (resultado.getString(0) != null
							&& (ConstantesParametros.POSICION_DEFENSA)

							.equals(resultado.getString(0))) {
						// Si hay más de 4
						if (llDefensa.getChildCount() < 4) {
							llDefensa.addView(btnAnadir);
						} else {
							llDefensa2.addView(btnAnadir);
						}

					} // Si es MEDIO
					else if (resultado.getString(0) != null
							&& (ConstantesParametros.POSICION_MEDIO)
									.equals(resultado.getString(0))) {
						// Si hay más de 4
						if (llMedio.getChildCount() < 4) {
							llMedio.addView(btnAnadir);
						} else {
							llMedio2.addView(btnAnadir);
						}
					} // Si es DELANTERO
					else if (resultado.getString(0) != null
							&& (ConstantesParametros.POSICION_DELANTERO)
									.equals(resultado.getString(0))) {
						// Si hay más de 4
						if (llDelantero.getChildCount() < 4) {
							llDelantero.addView(btnAnadir);
						} else {
							llDelantero2.addView(btnAnadir);
						}
					}
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
			db.close();
		}

		/**
		 * 
		 * BASE DE DATOS
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

}
