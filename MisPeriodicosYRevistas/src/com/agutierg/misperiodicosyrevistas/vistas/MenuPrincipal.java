package com.agutierg.misperiodicosyrevistas.vistas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.agutierg.misperiodicosyrevistas.R;
import com.agutierg.misperiodicosyrevistas.constants.ConstantesParametros;
import com.agutierg.misperiodicosyrevistas.constants.ConstantesVariables;
import com.agutierg.misperiodicosyrevistas.database.MisPerYRevSQLite;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MenuPrincipal extends Activity {

	private AdView adView;
	private LinearLayout llAnuncio;

	private MisPerYRevSQLite baseDatosMPYR;

	// Componentes
	private Button btnMisFav;
	private Button btnBuscar;
	private Button btnSalir;
	private Button btnPro;

	private ImageView ivPeriodicos;
	private ImageView ivRevistas;

	private ImageView ivPerDepor;
	private ImageView ivRevCora;

	private ImageView ivPrenExt;
	private ImageView ivRevCien;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_menu_principal);

		/**
		 * Añadimos el banner
		 */
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a1511f65de95788");
		adView.setGravity(Gravity.CENTER);

		// Buscar el LinearLayout suponiendo que se le haya asignado
		// el atributo android:id="@+id/mainLayout"
		llAnuncio = (LinearLayout) findViewById(R.id.llAnuncio);

		// Añadirle la adView
		llAnuncio.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		btnMisFav = (Button) findViewById(R.id.btnMisFav);
		btnBuscar = (Button) findViewById(R.id.btnBuscar);
		btnSalir = (Button) findViewById(R.id.btnSalir);
		btnPro = (Button) findViewById(R.id.btnPro);

		ivPeriodicos = (ImageView) findViewById(R.id.ivPeriodicos);
		ivRevistas = (ImageView) findViewById(R.id.ivRevistas);

		ivPerDepor = (ImageView) findViewById(R.id.ivPerDepor);
		ivRevCora = (ImageView) findViewById(R.id.ivRevCora);

		ivPrenExt = (ImageView) findViewById(R.id.ivPrenExt);
		ivRevCien = (ImageView) findViewById(R.id.ivRevCien);

		// Submenú
		// CERRAR APLICACIÓN
		btnSalir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();
				System.exit(0);
			}
		});

		// BUSCAR
		btnBuscar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				// Creamos el menú contextual
				AlertDialog.Builder builder = new AlertDialog.Builder(view
						.getContext());

				LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View vista = inflater.inflate(R.layout.dialog_search,
						null);
				builder.setView(vista);
				builder.setMessage(ConstantesParametros.PUBLICACION_BUSCAR);
				builder.setCancelable(true);
				builder.setPositiveButton(
						ConstantesParametros.MENU_CONTEX_BUSCAR,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								EditText texto = (EditText) vista
										.findViewById(R.id.etSearch);
								if (texto.getText() != null) {
									String textoBuscar = texto.getText()
											.toString();
									// Abrimos la ventana con la busqueda
									Intent vistaSearch = new Intent(vista
											.getContext(),
											ListaPublicacion.class);

									vistaSearch.putExtra(
											ConstantesParametros.TIPO_VISTA,
											textoBuscar);

									startActivityForResult(
											vistaSearch,
											Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
								}
							}
						});
				builder.setNegativeButton(
						ConstantesParametros.MENU_CONTEX_CANCEL,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
				AlertDialog alert = builder.create();
				alert.show();

			}
		});

		// MIS FAVORITOS
		btnMisFav.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaFavoritos = new Intent(v.getContext(),
						ListaPublicacion.class);

				vistaFavoritos.putExtra(ConstantesParametros.TIPO_VISTA,
						ConstantesVariables.TIPO_PUBLICACION_FAVORITOS);

				startActivityForResult(
						vistaFavoritos,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
			}
		});

		// PRO
		btnPro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/details?id=com.agutierg.misperiodicosyrevistaspro")));
			}
		});

		// Periódicos
		ivPeriodicos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaPeriodicos = new Intent(v.getContext(),
						ListaPublicacion.class);

				vistaPeriodicos.putExtra(ConstantesParametros.TIPO_VISTA,
						ConstantesVariables.TIPO_PUBLICACION_PERIODICO);

				startActivityForResult(
						vistaPeriodicos,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
			}
		});

		// Revistas
		ivRevistas.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaRevistas = new Intent(v.getContext(),
						ListaPublicacion.class);

				vistaRevistas.putExtra(ConstantesParametros.TIPO_VISTA,
						ConstantesVariables.TIPO_PUBLICACION_REVISTA);

				startActivityForResult(
						vistaRevistas,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
			}
		});

		// Prensa Deportiva
		ivPerDepor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaPerDepor = new Intent(v.getContext(),
						ListaPublicacion.class);

				vistaPerDepor
						.putExtra(
								ConstantesParametros.TIPO_VISTA,
								ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO);

				startActivityForResult(
						vistaPerDepor,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
			}
		});

		// Revistas corazon
		ivRevCora.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaRevistasCorazon = new Intent(v.getContext(),
						ListaPublicacion.class);

				vistaRevistasCorazon.putExtra(ConstantesParametros.TIPO_VISTA,
						ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON);

				startActivityForResult(
						vistaRevistasCorazon,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
			}
		});

		// Prensa extranjera
		ivPrenExt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaPreExt = new Intent(v.getContext(),
						ListaPublicacion.class);

				vistaPreExt.putExtra(ConstantesParametros.TIPO_VISTA,
						ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA);

				startActivityForResult(
						vistaPreExt,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
			}
		});

		// Revistas cientificas
		ivRevCien.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent vistaRevistasCien = new Intent(v.getContext(),
						ListaPublicacion.class);

				vistaRevistasCien
						.putExtra(
								ConstantesParametros.TIPO_VISTA,
								ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA);

				startActivityForResult(
						vistaRevistasCien,
						Integer.valueOf(ConstantesParametros.CODE_VISTA_LISTA_PUBLICACION));
			}
		});

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosMPYR = new MisPerYRevSQLite(this, "DBMisPerYRev", null, 1);

		SQLiteDatabase db = baseDatosMPYR.getWritableDatabase();

		// Si hemos abierto correctamente la base de datos
		if (db != null) {
			// Cerramos la base de datos
			db.close();
		}

		/**
		 * Base de datos
		 */

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onDestroy() {
		adView.destroy();
		super.onDestroy();
	}
}
