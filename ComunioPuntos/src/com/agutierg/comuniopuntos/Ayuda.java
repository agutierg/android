package com.agutierg.comuniopuntos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;

public class Ayuda extends Activity {

	// Componentes pantalla
	private TextView tvAyudaME;
	private TextView tvAyudaPG;
	private TextView tvAyudaAE;
	private TextView tvAyudaMD;
	private TextView tvAyudaEE;
	private TextView tvAyudaCampo;

	// Submenú
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// Para que no salga el teclado...
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		setContentView(R.layout.activity_ayuda);

		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		tvAyudaME = (TextView) findViewById(R.id.tvAyudaME);
		tvAyudaPG = (TextView) findViewById(R.id.tvAyudaPG);
		tvAyudaAE = (TextView) findViewById(R.id.tvAyudaAE);
		tvAyudaMD = (TextView) findViewById(R.id.tvAyudaMD);
		tvAyudaEE = (TextView) findViewById(R.id.tvAyudaEE);
		tvAyudaCampo = (TextView) findViewById(R.id.tvAyudaCampo);

		// Seteamos el texto de la ayuda de MIS EQUIPOS
		tvAyudaME.setText(ConstantesParametros.AYUDA_MIS_EQUIPOS);

		// Seteamos el texto de la ayuda de PUNTUACIONES GENERALES
		tvAyudaPG.setText(ConstantesParametros.AYUDA_PUNTUACIONES_GENERALES);

		// Seteamos el texto de la ayuda de AÑADIR EQUIPO
		tvAyudaAE.setText(ConstantesParametros.AYUDA_ANADIR_EQUIPO);

		// Seteamos el texto de la ayuda de MODIFICAR EQUIPO
		tvAyudaMD.setText(ConstantesParametros.AYUDA_MODIFICAR_EQUIPO);

		// Seteamos el texto de la ayuda de ELIMINAR EQUIPO
		tvAyudaEE.setText(ConstantesParametros.AYUDA_ELIMINAR_EQUIPO);

		// Seteamos el texto del CAMPO
		tvAyudaCampo.setText(ConstantesParametros.AYUDA_CAMPO);

		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		/**
		 * Elementos y acciones de los elementos
		 */

		btnInfo = (ImageView) findViewById(R.id.btnInfoAY);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaAY);
		btnVolver = (ImageView) findViewById(R.id.btnVolverAY);
		btnRss = (ImageView) findViewById(R.id.btnRssAY);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntAY);

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

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
