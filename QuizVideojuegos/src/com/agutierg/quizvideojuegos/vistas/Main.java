package com.agutierg.quizvideojuegos.vistas;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;
import com.agutierg.quizvideojuegos.database.QuizGameSQLite;
import com.agutierg.quizvideojuegos.dto.Jugador;

public class Main extends Activity {

	private Button btnHelp;
	private Button btnAbout;
	private Button btnPlay;
	private Button btnRanking;

	private QuizGameSQLite baseDatosQG;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		/**
		 * LISTENERS Y COMPONENTES
		 */

		btnHelp = (Button) findViewById(R.id.btnHelp);
		btnAbout = (Button) findViewById(R.id.btnAbout);
		btnPlay = (Button) findViewById(R.id.btnPlay);
		btnRanking = (Button) findViewById(R.id.btnRanking);

		btnHelp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaHelp = new Intent(view.getContext(), Help.class);
				startActivityForResult(vistaHelp,
						Integer.valueOf(ConstantesParametros.VISTA_HELP));
			}
		});

		btnAbout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaAbout = new Intent(view.getContext(), About.class);
				startActivityForResult(vistaAbout,
						Integer.valueOf(ConstantesParametros.VISTA_ABOUT));
			}
		});

		btnPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaPlay = new Intent(view.getContext(), Play.class);
				startActivityForResult(vistaPlay,
						Integer.valueOf(ConstantesParametros.VISTA_PLAY));
			}
		});

		btnRanking.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaPlay = new Intent(view.getContext(), Ranking.class);
				startActivityForResult(vistaPlay,
						Integer.valueOf(ConstantesParametros.VISTA_RANKING));
			}
		});

		/**
		 * LISTENERS Y COMPONENTES
		 */

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosQG = new QuizGameSQLite(this, "DBQuizGames", null, 2);

		// Recuperamos las niveles
		SQLiteDatabase db = baseDatosQG.getReadableDatabase();
		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			Cursor resJugador = null;
			try {
				// RECUPERAMOS LOS NIVELES
				resJugador = db.query("Jugador", null, null, null, null, null,
						null);
				// Si hay resultados
				if (resJugador.moveToNext()) {
					Jugador jug = new Jugador();
					jug.setIdJugador(resJugador.getInt(0));
					jug.setNombreJugador(resJugador.getString(1));
					jug.setAciertos(resJugador.getInt(2));

					LayoutInflater inflater = getLayoutInflater();
					View layout = inflater.inflate(R.layout.custom_toast,
							(ViewGroup) findViewById(R.id.toast_layout_root));
					TextView tvToast = (TextView) layout
							.findViewById(R.id.tvToast);
					tvToast.setText("Welcome back " + jug.getNombreJugador()
							+ ". Keep improving your record!");
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 380);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(layout);
					toast.show();
				} else {
					Intent vistaLog = new Intent(getApplicationContext(),
							Loguearse.class);
					startActivityForResult(vistaLog,
							Integer.valueOf(ConstantesParametros.VISTA_LOG));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Cerramos la base de datos
			db.close();
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
