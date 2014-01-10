package com.agutierg.misperiodicosyrevistaspro.vistas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.agutierg.misperiodicosyrevistaspro.R;
import com.agutierg.misperiodicosyrevistaspro.constants.ConstantesParametros;
import com.agutierg.misperiodicosyrevistaspro.constants.ConstantesVariables;
import com.agutierg.misperiodicosyrevistaspro.database.MisPerYRevSQLite;
import com.agutierg.misperiodicosyrevistaspro.dto.Publicacion;
import com.agutierg.misperiodicosyrevistaspro.util.LazyAdapter;

public class ListaPublicacion extends Activity {

	private String tipoPublicacion;
	private MisPerYRevSQLite baseDatosMPYR;
	private List<Publicacion> listaPublicaciones;

	private ListView list;
	private LazyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_lista_publicacion);

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosMPYR = new MisPerYRevSQLite(this, "DBMisPerYRev", null, 1);

		// Recogemos el tipo de publicacion a visualizar que nos viene por
		// parámetro
		Bundle bundle = getIntent().getExtras();

		if (bundle != null
				&& bundle.getString(ConstantesParametros.TIPO_VISTA) != null) {
			tipoPublicacion = (String) bundle
					.getString(ConstantesParametros.TIPO_VISTA);
		}

		// Recuperamos las publicaciones
		listaPublicaciones = recuperarPublicaciones(tipoPublicacion);

		list = (ListView) findViewById(R.id.list);

		// Getting adapter by passing xml data ArrayList
		adapter = new LazyAdapter(this, listaPublicaciones);
		list.setAdapter(adapter);

		// Click event for single list row
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				String urlVisualizar = null;
				Publicacion publiPulsada = (Publicacion) list
						.getItemAtPosition(position);
				if (publiPulsada != null) {
					urlVisualizar = publiPulsada.getUrl();
					// Abrimos el VISOR WEB
					Intent vistaVisorWeb = new Intent(view.getContext(),
							VisorWeb.class);

					vistaVisorWeb.putExtra(ConstantesParametros.URL_VISUALIZAR,
							urlVisualizar);

					startActivityForResult(vistaVisorWeb, Integer
							.valueOf(ConstantesParametros.CODE_VISTA_VISOR_WEB));
				}
			}
		});

	}

	// Método base de datos
	private List<Publicacion> recuperarPublicaciones(String tipoP) {

		List<Publicacion> listaReturn = new ArrayList<Publicacion>();

		if (tipoP != null) {
			// Recuperamos las publicaciones del tipo que nos hayan pasado
			SQLiteDatabase db = baseDatosMPYR.getWritableDatabase();
			// Si hemos abierto correctamente la base de datos
			if (db != null) {
				Cursor resPublicaciones = null;
				String condicion = null;
				// Si queremos ver los favoritos
				if (ConstantesVariables.TIPO_PUBLICACION_FAVORITOS
						.equals(tipoP)) {
					condicion = "isFavorito=1";
				} else if (ConstantesVariables.TIPO_PUBLICACION_PERIODICO
						.equals(tipoP)
						|| ConstantesVariables.TIPO_PUBLICACION_REVISTA
								.equals(tipoP)
						|| ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO
								.equals(tipoP)
						|| ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON
								.equals(tipoP)
						|| ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA
								.equals(tipoP)
						|| ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA
								.equals(tipoP)) {
					condicion = "tipoPublicacion='" + tipoP + "'";
				} else {
					String texto = tipoP;
					texto = texto.replace('a', '_');
					texto = texto.replace('e', '_');
					texto = texto.replace('i', '_');
					texto = texto.replace('o', '_');
					texto = texto.replace('u', '_');
					texto = texto.replace('á', '_');
					texto = texto.replace('é', '_');
					texto = texto.replace('í', '_');
					texto = texto.replace('ó', '_');
					texto = texto.replace('ú', '_');
					texto = texto.replace('à', '_');
					texto = texto.replace('è', '_');
					texto = texto.replace('ì', '_');
					texto = texto.replace('ò', '_');
					texto = texto.replace('ù', '_');

					// Si no es ninguna de las anteriores es que es por texto...
					condicion = "descripcion like '%" + texto + "%'";
				}

				try {
					// RECUPERAMOS LOS EQUIPOS DE ESE JUGADOR
					String orderBy = "descripcion ASC";
					resPublicaciones = db.query("Publicacion", null, condicion,
							null, null, null, orderBy);
					// Si hay resultados
					while (resPublicaciones.moveToNext()) {
						Publicacion publicacion = new Publicacion();
						publicacion
								.setIdPublicacion(resPublicaciones.getInt(0));
						publicacion.setDescripcion(resPublicaciones
								.getString(1));
						publicacion.setUrl(resPublicaciones.getString(2));
						publicacion.setTipoPublicacion(resPublicaciones
								.getString(3));
						boolean fav = resPublicaciones.getInt(4) > 0;
						publicacion.setFavorito(fav);
						// LO añadimos a la lista
						listaReturn.add(publicacion);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Cerramos la base de datos
				db.close();
			}

		}

		return listaReturn;
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
