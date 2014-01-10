package com.agutierg.comuniopuntos;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.agutierg.comuniopuntos.components.JugadorButton;
import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.dto.EquiPuntJugDTO;
import com.agutierg.comuniopuntos.dto.EquiPuntSerializableJug;
import com.agutierg.comuniopuntos.dto.FutJugDTO;
import com.google.ads.AdView;

public class MisEquipos extends Activity {

	private ViewFlipper vifMisEquipos;

	private LinearLayout llPorteroME;
	private LinearLayout llDefensaME;
	private LinearLayout llDefensa2ME;
	private LinearLayout llMedioME;
	private LinearLayout llMedio2ME;
	private LinearLayout llDelanteroME;
	private LinearLayout llDelantero2ME;

	// Submenú
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private LinearLayout llMisEquipos;

	private AdView adView;

	private EquiPuntSerializableJug puntosYEquiposJug = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_mis_equipos);

		// Crear la adView
		// adView = new AdView(this, AdSize.BANNER, "a151115e5f5581f");
		//
		// // Buscar el LinearLayout suponiendo que se le haya asignado
		// // el atributo android:id="@+id/mainLayout"
		// llMisEquipos = (LinearLayout) findViewById(R.id.llMisEquipos);
		//
		// // Añadirle la adView
		// llMisEquipos.addView(adView);
		//
		// // Iniciar una solicitud genérica para cargarla con un anuncio
		// adView.loadAd(new AdRequest());

		// Recogemos los puntos de los equipos que vienen por parámetro
		Bundle bundle = getIntent().getExtras();

		if (bundle != null
				&& bundle
						.getSerializable(ConstantesParametros.EQUIPOS_Y_PUNTOS_JUGADOR) != null) {
			puntosYEquiposJug = (EquiPuntSerializableJug) bundle
					.getSerializable(ConstantesParametros.EQUIPOS_Y_PUNTOS_JUGADOR);
		}

		vifMisEquipos = (ViewFlipper) findViewById(R.id.vifMisEquipos);

		vifMisEquipos.setOnTouchListener(new ListenerTouchViewFlipper());
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// Recuperamos la lista de puntos y equipos pasada por parámetro
		List<EquiPuntJugDTO> listaEquPuntos = puntosYEquiposJug
				.getListaEquPuntos();

		for (EquiPuntJugDTO equiPuntJugDTO : listaEquPuntos) {
			View vistaPuntos = inflater.inflate(
					R.layout.activity_puntos_generales_mis_equipos, null);
			/**
			 * NOMBRE DEL EQUIPO
			 */
			TextView tvNomEquME = (TextView) vistaPuntos
					.findViewById(R.id.tvNomEquME);
			tvNomEquME.setText(ConstantesParametros.EQUIPO_DESC
					+ equiPuntJugDTO.getNombreEquipo());
			/**
			 * NOMBRE DEL EQUIPO
			 */
			/**
			 * PUNTOS DEL EQUIPO
			 */
			TextView tvPuntosEquipoME = (TextView) vistaPuntos
					.findViewById(R.id.tvPuntosEquipoME);
			if (equiPuntJugDTO.getPuntEquipo() != null) {
				tvPuntosEquipoME.setText(tvPuntosEquipoME.getText()
						+ equiPuntJugDTO.getPuntEquipo().toString());
			}
			/**
			 * PUNTOS DEL EQUIPO
			 */
			/**
			 * LAYOUTS
			 */

			// LAYOUTS DE PORTERO, DEFENSA, MEDIO Y DELANTEROS
			llPorteroME = (LinearLayout) vistaPuntos
					.findViewById(R.id.llPorteroME);
			llDefensaME = (LinearLayout) vistaPuntos
					.findViewById(R.id.llDefensaME);
			llDefensa2ME = (LinearLayout) vistaPuntos
					.findViewById(R.id.llDefensa2ME);
			llMedioME = (LinearLayout) vistaPuntos.findViewById(R.id.llMedioME);
			llMedio2ME = (LinearLayout) vistaPuntos
					.findViewById(R.id.llMedio2ME);
			llDelanteroME = (LinearLayout) vistaPuntos
					.findViewById(R.id.llDelanteroME);
			llDelantero2ME = (LinearLayout) vistaPuntos
					.findViewById(R.id.llDelantero2ME);
			/**
			 * LAYOUTS
			 */

			// Añadimos jugadores y puntos individuales
			JugadorButton jButton = new JugadorButton();

			List<FutJugDTO> jugPuntuaciones = equiPuntJugDTO
					.getListaJugPuntos();
			int identificador = 1;
			for (FutJugDTO jugPuntDTO : jugPuntuaciones) {
				// Creamos el boton
				Button btnAnadir = jButton.devuelveBotonJugador2(this,
						identificador, jugPuntDTO);
				// Añadir según posicion
				anadirSegunPosicion(btnAnadir, jugPuntDTO);
				identificador++;
			}

			// Añadimos la vista
			vifMisEquipos.addView(vistaPuntos);
		}

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaME);
		btnInfo = (ImageView) findViewById(R.id.btnInfoME);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaME);
		btnVolver = (ImageView) findViewById(R.id.btnVolverME);
		btnRss = (ImageView) findViewById(R.id.btnRssME);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntME);

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

	// Método que añade el jugador según la posición
	private void anadirSegunPosicion(Button btnAnadir, FutJugDTO jugPuntDTO) {

		// Si es PORTERO
		if (jugPuntDTO.getPosicion() != null
				&& (ConstantesParametros.POSICION_PORTERO).equals(jugPuntDTO
						.getPosicion())) {
			llPorteroME.addView(btnAnadir);
		} // Si es DEFENSA
		else if (jugPuntDTO.getPosicion() != null
				&& (ConstantesParametros.POSICION_DEFENSA)

				.equals(jugPuntDTO.getPosicion())) {
			// Si hay más de 4
			if (llDefensaME.getChildCount() < 4) {
				llDefensaME.addView(btnAnadir);
			} else {
				llDefensa2ME.addView(btnAnadir);
			}

		} // Si es MEDIO
		else if (jugPuntDTO.getPosicion() != null
				&& (ConstantesParametros.POSICION_MEDIO).equals(jugPuntDTO
						.getPosicion())) {
			// Si hay más de 4
			if (llMedioME.getChildCount() < 4) {
				llMedioME.addView(btnAnadir);
			} else {
				llMedio2ME.addView(btnAnadir);
			}
		} // Si es DELANTERO
		else if (jugPuntDTO.getPosicion() != null
				&& (ConstantesParametros.POSICION_DELANTERO).equals(jugPuntDTO
						.getPosicion())) {
			// Si hay más de 4
			if (llDelanteroME.getChildCount() < 4) {
				llDelanteroME.addView(btnAnadir);
			} else {
				llDelantero2ME.addView(btnAnadir);
			}
		}
	}

	private class ListenerTouchViewFlipper implements View.OnTouchListener {

		private float init_x;

		@Override
		public boolean onTouch(View v, MotionEvent event) {

			switch (event.getAction()) {

			case MotionEvent.ACTION_DOWN: // Cuando el usuario toca la pantalla
				// por primera vez
				init_x = event.getX();
				return true;

			case MotionEvent.ACTION_UP: // Cuando el usuario deja de presionar

				float distance = init_x - event.getX();

				if (distance > 0) {
					vifMisEquipos.setInAnimation(inFromRightAnimation());
					vifMisEquipos.setOutAnimation(outToLeftAnimation());
					vifMisEquipos.showPrevious();
				}

				if (distance < 0) {
					vifMisEquipos.setInAnimation(inFromLeftAnimation());
					vifMisEquipos.setOutAnimation(outToRightAnimation());
					vifMisEquipos.showNext();
				}

			default:
				break;

			}
			return false;
		}

	}

	private Animation inFromRightAnimation() {

		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(500);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;

	}

	private Animation outToLeftAnimation() {

		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(500);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;

	}

	private Animation inFromLeftAnimation() {

		Animation inFromLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromLeft.setDuration(500);
		inFromLeft.setInterpolator(new AccelerateInterpolator());
		return inFromLeft;

	}

	private Animation outToRightAnimation() {

		Animation outtoRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(500);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		return outtoRight;
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
