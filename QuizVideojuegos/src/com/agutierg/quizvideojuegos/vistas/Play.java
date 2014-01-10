package com.agutierg.quizvideojuegos.vistas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;
import com.agutierg.quizvideojuegos.database.QuizGameSQLite;
import com.agutierg.quizvideojuegos.dto.Nivel;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Play extends Activity {

	private ListView listNivel;
	private LazyAdapter adapter;

	private List<Nivel> listaNiveles;

	private QuizGameSQLite baseDatosQG;

	private Nivel nivelPulsado;

	private AdView adView;
	private RelativeLayout llPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_play);

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosQG = new QuizGameSQLite(this, "DBQuizGames", null, 2);

		/**
		 * Añadimos el banner
		 */
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a15138747ee3473");

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

		llPlay = (RelativeLayout) findViewById(R.id.llPlay);

		// Añadirle la adView
		llPlay.addView(adView, params);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());
		/**
		 * LISTENERS Y COMPONENTES
		 */

		listNivel = (ListView) findViewById(R.id.listNivel);

		// Recuperamos las niveles
		listaNiveles = recuperarNiveles();

		// Getting adapter by passing xml data ArrayList
		adapter = new LazyAdapter(this, listaNiveles);
		listNivel.setAdapter(adapter);

		// Click event for single list row
		listNivel.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				nivelPulsado = (Nivel) listNivel.getItemAtPosition(position);

				if (nivelPulsado != null && nivelPulsado.isDesbloqueado()) {
					Intent vistaFlipper = new Intent(view.getContext(),
							FlipperJuegos.class);
					vistaFlipper.putExtra(
							ConstantesParametros.NIVEL_SELECCIONADO,
							nivelPulsado);
					startActivityForResult(vistaFlipper, Integer
							.valueOf(ConstantesParametros.VISTA_FLIPPER_JUEGOS));
				} else {
					// MAS O MENOS
					CharSequence text = ConstantesParametros.MUST_GUESS;
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
		});

		/**
		 * LISTENERS Y COMPONENTES
		 */

	}

	private List<Nivel> recuperarNiveles() {

		List<Nivel> listaReturn = new ArrayList<Nivel>();

		// Recuperamos las niveles
		SQLiteDatabase db = baseDatosQG.getReadableDatabase();
		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			Cursor resNiveles = null;
			try {
				// RECUPERAMOS LOS NIVELES
				String orderBy = "idNivel ASC";
				resNiveles = db.query("Nivel", null, null, null, null, null,
						orderBy);
				// Si hay resultados
				while (resNiveles.moveToNext()) {
					Nivel nivel = new Nivel();
					nivel.setIdNivel(resNiveles.getInt(0));
					nivel.setNombreNivel(resNiveles.getString(1));
					nivel.setPorcCompletado(resNiveles.getString(2));
					nivel.setIdDrawable(resNiveles.getString(3));
					boolean comp = resNiveles.getInt(4) > 0;
					nivel.setDesbloqueado(comp);
					// LO añadimos a la lista
					listaReturn.add(nivel);
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
	protected void onResume() {
		super.onResume();

		// Recuperamos las niveles
		listaNiveles = recuperarNiveles();

		// Getting adapter by passing xml data ArrayList
		adapter = new LazyAdapter(this, listaNiveles);
		listNivel.setAdapter(adapter);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
