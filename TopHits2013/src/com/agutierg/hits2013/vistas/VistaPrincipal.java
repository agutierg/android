package com.agutierg.hits2013.vistas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.agutierg.hits2013.R;
import com.agutierg.hits2013.constants.ConstantesParametros;
import com.agutierg.hits2013.database.Temazos2013SQLite;
import com.agutierg.hits2013.dto.Cancion;
import com.agutierg.hits2013.dto.ListaCanciones;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class VistaPrincipal extends Activity {

	private Temazos2013SQLite baseDatosTemazos;
	private List<Cancion> listaCanciones;

	private AdView adView;

	private ListView list;
	private LazyAdapter adapter;

	private RelativeLayout rlVistaP;

	private String tipoCancion;
	private List<Cancion> listaRemoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_vista_principal);

		/**
		 * Añadimos el banner
		 */
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER,
				"ca-app-pub-3391184176179743/8651174511");

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);

		rlVistaP = (RelativeLayout) findViewById(R.id.rlVistaP);

		// Añadirle la adView
		rlVistaP.addView(adView, params);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosTemazos = new Temazos2013SQLite(this, "DBTemazos", null, 2);

		// Recogemos el boton pulsado
		Bundle bundle = getIntent().getExtras();
		if (bundle.getSerializable(ConstantesParametros.BOTON_PULSADO) != null) {
			tipoCancion = (String) bundle
					.getSerializable(ConstantesParametros.BOTON_PULSADO);
		}

		if (bundle.getSerializable(ConstantesParametros.LISTA_CANCIONES) != null) {
			ListaCanciones lista = (ListaCanciones) bundle
					.getSerializable(ConstantesParametros.LISTA_CANCIONES);
			listaRemoto = lista.getListaCanciones();
		}

		// Si queremos las 20 mejores
		if (tipoCancion != null
				&& tipoCancion.equals(ConstantesParametros.CANCIONES_BEST)) {
			listaCanciones = recuperarCancionesBest();
		} else {
			// Recuperamos las publicaciones
			listaCanciones = recuperarCanciones();
		}

		list = (ListView) findViewById(R.id.list);

		// Getting adapter by passing xml data ArrayList
		adapter = new LazyAdapter(this, listaCanciones);
		list.setAdapter(adapter);
	}

	private List<Cancion> recuperarCancionesBest() {
		List<Cancion> listaReturn = new ArrayList<Cancion>();

		// Recuperamos las publicaciones del tipo que nos hayan pasado
		SQLiteDatabase db = baseDatosTemazos.getWritableDatabase();
		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			Cursor resCanciones = null;

			try {

				String orderBy = "votos desc";
				// RECUPERAMOS LAS CANCIONES
				resCanciones = db.query("Cancion", null, null, null, null,
						null, orderBy);
				int contador = 0;
				// Si hay resultados
				while (resCanciones.moveToNext() && contador < 20) {
					Cancion cancion = new Cancion();
					cancion.setIdCancion(resCanciones.getInt(0));
					cancion.setTitulo(resCanciones.getString(1));
					cancion.setUrl(resCanciones.getString(2));
					cancion.setCantante(resCanciones.getString(3));
					cancion.setDuracion(resCanciones.getString(4));
					cancion.setTipo(resCanciones.getString(5));
					cancion.setUrlDescarga(resCanciones.getString(6));
					cancion.setVotos(resCanciones.getInt(7));
					String fecha = resCanciones.getString(8);
					Date fechaInsert = new SimpleDateFormat("yyyy-MM-dd",
							Locale.ENGLISH).parse(fecha);
					cancion.setInsertDate(fechaInsert);
					listaReturn.add(cancion);
					contador++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Cerramos la base de datos
			db.close();
		}
		return listaReturn;
	}

	private List<Cancion> recuperarCanciones() {
		List<Cancion> listaReturn = new ArrayList<Cancion>();

		// Recuperamos las publicaciones del tipo que nos hayan pasado
		SQLiteDatabase db = baseDatosTemazos.getWritableDatabase();
		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			Cursor resCanciones = null;

			try {
				String condicion = "tipo='" + tipoCancion + "'";
				String orderBy = "votos desc";
				// RECUPERAMOS LAS CANCIONES
				resCanciones = db.query("Cancion", null, condicion, null, null,
						null, orderBy);
				// Si hay resultados
				while (resCanciones.moveToNext()) {
					Cancion cancion = new Cancion();
					cancion.setIdCancion(resCanciones.getInt(0));
					cancion.setTitulo(resCanciones.getString(1));
					cancion.setUrl(resCanciones.getString(2));
					cancion.setCantante(resCanciones.getString(3));
					cancion.setDuracion(resCanciones.getString(4));
					cancion.setTipo(resCanciones.getString(5));
					cancion.setUrlDescarga(resCanciones.getString(6));
					cancion.setVotos(resCanciones.getInt(7));
					String fecha = resCanciones.getString(8);
					Date fechaInsert = new SimpleDateFormat("yyyy-MM-dd",
							Locale.ENGLISH).parse(fecha);
					cancion.setInsertDate(fechaInsert);
					listaReturn.add(cancion);
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

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
