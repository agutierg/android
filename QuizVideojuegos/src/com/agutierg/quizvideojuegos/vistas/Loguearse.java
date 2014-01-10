package com.agutierg.quizvideojuegos.vistas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;
import com.agutierg.quizvideojuegos.database.QuizGameSQLite;
import com.agutierg.quizvideojuegos.utils.JugadoresFunctions;

public class Loguearse extends Activity {

	private EditText etName;
	private Button btnLog;

	private ProgressDialog pDialog;
	private TareaInicialBDTask tarea;

	private String nombre;
	private boolean hayError;

	private QuizGameSQLite baseDatosQG;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_loguearse);

		etName = (EditText) findViewById(R.id.etName);
		btnLog = (Button) findViewById(R.id.btnLog);

		btnLog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				nombre = etName.getText().toString();
				if (nombre != null && !nombre.equals("")) {
					/**
					 * 
					 * 
					 * TAREA
					 * 
					 */
					pDialog = new ProgressDialog(view.getContext());
					pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					pDialog.setMessage("Uploading Data...");
					pDialog.setCancelable(false);
					pDialog.setMax(100);

					pDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
							"Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									pDialog.dismiss();
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

				} else {
					// Introduce algo
					CharSequence text = ConstantesParametros.SOMETHING;
					Toast toast = Toast.makeText(view.getContext(), text,
							Toast.LENGTH_SHORT);
					toast.show();
				}

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

			JugadoresFunctions cancionF = new JugadoresFunctions();
			hayError = cancionF.enviarNombre(nombre);
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if (hayError) {
				pDialog.dismiss();
				errorRepetido();
			} else {
				pDialog.dismiss();
				persistirBaseDatos();
				finalizar();
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

	public void errorRepetido() {
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.custom_toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));
		TextView tvToast = (TextView) layout.findViewById(R.id.tvToast);
		tvToast.setText("Name already exists");
		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.TOP, 0, 80);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
	}

	public void persistirBaseDatos() {
		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosQG = new QuizGameSQLite(this, "DBQuizGames", null, 2);
		SQLiteDatabase db = baseDatosQG.getWritableDatabase();

		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			try {
				db.execSQL("INSERT INTO Jugador (nombreJugador) VALUES ('"
						+ nombre + "')");
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Cerramos la base de datos
			db.close();
		}
	}

	public void finalizar() {
		this.finish();
	}

}
