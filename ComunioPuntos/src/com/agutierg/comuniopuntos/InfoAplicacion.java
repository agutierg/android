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

public class InfoAplicacion extends Activity {

	// Componentes pantalla
	private TextView tvInfoApliMe;
	private TextView tvInfoApliAgra;

	// Submenú
	private ImageView btnAyuda;
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

		setContentView(R.layout.activity_info_aplicacion);

		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		tvInfoApliMe = (TextView) findViewById(R.id.tvInfoApliMe);
		tvInfoApliAgra = (TextView) findViewById(R.id.tvInfoApliAgra);

		// Seteamos el texto de info de la aplicacion
		tvInfoApliMe.setText(ConstantesParametros.INFO_APLICACION_MIO);

		// Seteamos el texto de los agradecimientos
		tvInfoApliAgra
				.setText(ConstantesParametros.INFO_APLICACION_AGRADECIMIENTOS);

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaIA);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaIA);
		btnVolver = (ImageView) findViewById(R.id.btnVolverIA);
		btnRss = (ImageView) findViewById(R.id.btnRssIA);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntIA);

		// AYUDA
		btnAyuda.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaAyuda = new Intent(view.getContext(), Ayuda.class);
				startActivityForResult(vistaAyuda,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_AYUDA));
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
