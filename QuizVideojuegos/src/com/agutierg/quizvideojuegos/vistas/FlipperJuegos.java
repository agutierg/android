package com.agutierg.quizvideojuegos.vistas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;
import com.agutierg.quizvideojuegos.database.QuizGameSQLite;
import com.agutierg.quizvideojuegos.dto.Juego;
import com.agutierg.quizvideojuegos.dto.Nivel;

public class FlipperJuegos extends Activity {

	private ViewFlipper vifJuegos;

	private LinearLayout llJuegos1;
	private LinearLayout llJuegos2;
	private LinearLayout llJuegos3;

	private TextView tvLevel;
	private TextView tvPagina;

	private Nivel nivelSeleccionado;

	private List<Juego> listaJuegos = null;

	private QuizGameSQLite baseDatosQG;

	private ImageView ivSeleccionado;
	private Juego juegoSeleccionado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_flipper_juegos);

		vifJuegos = (ViewFlipper) findViewById(R.id.vifJuegos);

		vifJuegos.setOnTouchListener(new ListenerTouchViewFlipper());
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosQG = new QuizGameSQLite(this, "DBQuizGames", null, 2);

		// Recogemos los puntos de los equipos que vienen por parámetro
		Bundle bundle = getIntent().getExtras();

		if (bundle != null
				&& bundle
						.getSerializable(ConstantesParametros.NIVEL_SELECCIONADO) != null) {
			nivelSeleccionado = (Nivel) bundle
					.getSerializable(ConstantesParametros.NIVEL_SELECCIONADO);
		}

		// Recuperamos la lista de puntos y equipos pasada por parámetro
		listaJuegos = recuperaListaJuegos(nivelSeleccionado);

		int contadorPantallas = 0;
		int contadorJuegos = 0;

		while (contadorPantallas < 4) {

			View vistaJuegos = inflater.inflate(R.layout.activity_juegos, null);

			vistaJuegos.setId(contadorPantallas + 10);

			/**
			 * LAYOUTS
			 */
			// LAYOUTS DE PORTERO, DEFENSA, MEDIO Y DELANTEROS
			llJuegos1 = (LinearLayout) vistaJuegos.findViewById(R.id.llJuegos1);
			llJuegos2 = (LinearLayout) vistaJuegos.findViewById(R.id.llJuegos2);
			llJuegos3 = (LinearLayout) vistaJuegos.findViewById(R.id.llJuegos3);

			tvLevel = (TextView) vistaJuegos.findViewById(R.id.tvLevel);
			tvLevel.setText(nivelSeleccionado.getNombreNivel());

			tvPagina = (TextView) vistaJuegos.findViewById(R.id.tvPagina);
			tvPagina.setText((contadorPantallas + 1) + "/4");
			/**
			 * LAYOUTS
			 */
			int longitud = contadorJuegos;
			for (int i = longitud; i < longitud + 6; i++) {
				if (contadorJuegos < listaJuegos.size()) {
					Juego juego = listaJuegos.get(i);
					Bitmap bmp1 = BitmapFactory.decodeResource(getResources(),
							R.drawable.television2);
					Bitmap bmp2 = BitmapFactory.decodeResource(
							getResources(),
							getResources().getIdentifier(
									juego.getIdDrawable(),
									"drawable",
									this.getApplicationContext()
											.getPackageName()));

					Bitmap mezcla = overlay(bmp2, bmp1);

					ImageView juego1 = new ImageView(
							this.getApplicationContext());
					// Margen
					LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.WRAP_CONTENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
					lp.setMargins(6, 10, 6, 10);
					juego1.setLayoutParams(lp);
					// Ponemos el id para luego recuperar el juego
					juego1.setContentDescription(juego.getIdJuego().toString());
					juego1.setId(juego.getIdJuego());
					juego1.setImageBitmap(mezcla);

					// Si ya está acertado
					if (juego.isRespondido()) {
						Bitmap bmpAntigua = ((BitmapDrawable) juego1
								.getDrawable()).getBitmap();
						Bitmap bmpSolve = BitmapFactory.decodeResource(
								getResources(), R.drawable.solve);
						Bitmap mezcla2 = overlay2(bmpSolve, bmpAntigua);
						juego1.setImageBitmap(mezcla2);
					}

					juego1.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View vista) {

							ImageView juego = (ImageView) vista;
							ivSeleccionado = juego;
							String idJuego = (String) juego
									.getContentDescription();
							if (idJuego != null) {
								Integer id = Integer.valueOf(idJuego);
								for (Juego game : listaJuegos) {
									// Si es el que buscamos
									if (game.getIdJuego().equals(id)) {
										Intent vistaResolver = new Intent(vista
												.getContext(), Resolver.class);
										vistaResolver
												.putExtra(
														ConstantesParametros.JUEGO_SELECCIONADO,
														game);
										juegoSeleccionado = game;
										startActivityForResult(
												vistaResolver,
												Integer.valueOf(ConstantesParametros.VISTA_RESOLVER));
										break;
									}
								}

							}
						}
					});

					if (i < longitud + 2) {
						llJuegos1.addView(juego1);
					} else if (i > longitud + 1 && i < longitud + 4) {
						llJuegos2.addView(juego1);
					} else {
						llJuegos3.addView(juego1);
					}
					contadorJuegos++;
				}
			}

			// Añadimos la vista
			vifJuegos.addView(vistaJuegos);
			contadorPantallas++;
		}
	}

	public void actualizarListaJuegos(Integer juegoActualizar) {
		for (Juego juego : listaJuegos) {
			if (juego.getIdJuego().equals(juegoActualizar)) {
				juego.setRespondido(true);
				break;
			}
		}
	}

	public Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
		Bitmap bmOverlay = Bitmap.createBitmap(bmp2.getWidth(),
				bmp2.getHeight(), bmp2.getConfig());
		Canvas canvas = new Canvas(bmOverlay);
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(bmp1,
				bmp2.getWidth() - 80, bmp2.getHeight() - 30, true);
		canvas.drawBitmap(scaledBitmap, 10, 10, null);
		canvas.drawBitmap(bmp2, 0, 0, null);
		return bmOverlay;
	}

	public Bitmap overlay2(Bitmap bmp1, Bitmap bmp2) {
		Bitmap bmOverlay = Bitmap.createBitmap(bmp2.getWidth(),
				bmp2.getHeight(), bmp2.getConfig());
		Canvas canvas = new Canvas(bmOverlay);
		canvas.drawBitmap(bmp1, bmp2.getWidth() - 40, 10, null);
		canvas.drawBitmap(bmp2, 0, 0, null);
		return bmOverlay;
	}

	private List<Juego> recuperaListaJuegos(Nivel nivelSeleccionado2) {

		List<Juego> listaReturn = new ArrayList<Juego>();

		// Recuperamos los juegos
		SQLiteDatabase db = baseDatosQG.getReadableDatabase();
		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			Cursor resJuegos = null;
			try {
				// RECUPERAMOS LOS NIVELES
				String orderBy = "idJuego ASC";
				String condicion = "idNivelJuego="
						+ nivelSeleccionado2.getIdNivel();
				resJuegos = db.query("Juego", null, condicion, null, null,
						null, orderBy);
				// Si hay resultados
				while (resJuegos.moveToNext()) {
					Juego juego = new Juego();
					juego.setIdJuego(resJuegos.getInt(0));
					juego.setIdNivelJuego(resJuegos.getInt(1));
					juego.setNombreJuego(resJuegos.getString(2));
					juego.setPistaJuego(resJuegos.getString(3));
					juego.setIdDrawable(resJuegos.getString(4));
					boolean comp = resJuegos.getInt(5) > 0;
					juego.setRespondido(comp);
					// LO añadimos a la lista
					listaReturn.add(juego);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Cerramos la base de datos
			db.close();
		}

		return listaReturn;

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
					vifJuegos.setInAnimation(inFromRightAnimation());
					vifJuegos.setOutAnimation(outToLeftAnimation());
					vifJuegos.showNext();
				}

				if (distance < 0) {
					vifJuegos.setInAnimation(inFromLeftAnimation());
					vifJuegos.setOutAnimation(outToRightAnimation());
					vifJuegos.showPrevious();

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
	protected void onResume() {
		super.onResume();

		// Si no esta ya acertado
		if (ivSeleccionado != null && juegoSeleccionado != null
				&& !juegoSeleccionado.isRespondido()) {
			Juego juegoBD = null;
			// Recuperamos el Juego para ver si ahora lo ha acertado
			// Recuperamos los juegos
			SQLiteDatabase db = baseDatosQG.getReadableDatabase();
			// Si hemos abierto correctamente la base de datos
			if (db != null) {
				Cursor resJuegos = null;
				try {
					// RECUPERAMOS EL JUEGO
					String condicion = "idJuego="
							+ juegoSeleccionado.getIdJuego();
					resJuegos = db.query("Juego", null, condicion, null, null,
							null, null);
					// Si hay resultados
					while (resJuegos.moveToNext()) {
						juegoBD = new Juego();
						juegoBD.setIdJuego(resJuegos.getInt(0));
						juegoBD.setIdNivelJuego(resJuegos.getInt(1));
						juegoBD.setNombreJuego(resJuegos.getString(2));
						juegoBD.setPistaJuego(resJuegos.getString(3));
						juegoBD.setIdDrawable(resJuegos.getString(4));
						boolean comp = resJuegos.getInt(5) > 0;
						juegoBD.setRespondido(comp);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Cerramos la base de datos
				db.close();
			}

			// Si ahora esta acertado
			if (juegoBD.isRespondido()) {
				Bitmap bmpAntigua = ((BitmapDrawable) ivSeleccionado
						.getDrawable()).getBitmap();
				Bitmap bmp1 = BitmapFactory.decodeResource(getResources(),
						R.drawable.solve);
				Bitmap mezcla = overlay2(bmp1, bmpAntigua);
				ivSeleccionado.setImageBitmap(mezcla);
				actualizarListaJuegos(Integer.valueOf(ivSeleccionado
						.getContentDescription().toString()));
				ivSeleccionado = null;
				// Actualizamos el nivel
				Integer acertados = Integer.valueOf(nivelSeleccionado
						.getPorcCompletado());
				acertados = acertados + 1;
				nivelSeleccionado.setPorcCompletado(acertados.toString());
				db = baseDatosQG.getWritableDatabase();
				// Si hemos abierto correctamente la base de datos
				if (db != null) {
					try {
						db.execSQL("UPDATE Nivel SET porcCompletado = '"
								+ acertados.toString() + "' WHERE idNivel = "
								+ nivelSeleccionado.getIdNivel());
					} catch (Exception e) {
						e.printStackTrace();
					}
					// Cerramos la base de datos
					db.close();
				}
				// Si hemos acertado la mitad o mas desbloqueamos el siguiente
				// nivel y NO ES EL ULTIMO NIVEL
				if (acertados == 10
						&& !nivelSeleccionado.getNombreNivel().equals(
								ConstantesParametros.LEVEL_10)) {
					db = baseDatosQG.getWritableDatabase();
					// Si hemos abierto correctamente la base de datos
					if (db != null) {
						try {
							db.execSQL("UPDATE Nivel SET isDesbloqueado = 1 WHERE idNivel = "
									+ (nivelSeleccionado.getIdNivel() + 1));
						} catch (Exception e) {
							e.printStackTrace();
						}
						// Cerramos la base de datos
						db.close();
					}
				}
				// Si hemos acabado el juego
				if (acertados == 20
						&& nivelSeleccionado.getNombreNivel().equals(
								ConstantesParametros.LEVEL_10)) {
					// PISTA
					CharSequence text = ConstantesParametros.CONGRATULATIONS;
					LayoutInflater inflater = getLayoutInflater();
					View layout = inflater.inflate(R.layout.custom_toast,
							(ViewGroup) findViewById(R.id.toast_layout_root));
					TextView tvToast = (TextView) layout
							.findViewById(R.id.tvToast);
					tvToast.setText(text);
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(layout);
					toast.show();
				}
			}
		}
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
