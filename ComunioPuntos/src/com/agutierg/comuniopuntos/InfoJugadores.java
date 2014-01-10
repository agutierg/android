package com.agutierg.comuniopuntos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.dto.EquipoInfoJugDTO;
import com.agutierg.comuniopuntos.dto.InfoJugDTO;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class InfoJugadores extends Activity {

	private ProgressDialog pDialog;
	private TareaInicialBDTask tareaWeb;

	private TabHost tabhostInfoJug;
	private TableLayout tblLesion;
	private TableLayout tblDuda;
	private TableLayout tblAcumulacion;
	private TableLayout tbl2Amarillas;
	private TableLayout tblRoja;
	private TableLayout tblNoConvocado;
	private TableLayout tblFilial;

	// Submenú
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private Context contexto;

	private AdView adView;
	private LinearLayout llInfoJuga;

	private List<EquipoInfoJugDTO> listaEquiposInfo = new ArrayList<EquipoInfoJugDTO>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// Para que no salga el teclado...
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		setContentView(R.layout.activity_info_jugadores);

		contexto = this;

		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a151115e5f5581f");
		adView.setGravity(Gravity.CENTER);

		// Añadirle la adView
		llInfoJuga = (LinearLayout) findViewById(R.id.llInfoJuga);

		llInfoJuga.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaIJ);
		btnInfo = (ImageView) findViewById(R.id.btnInfoIJ);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaIJ);
		btnVolver = (ImageView) findViewById(R.id.btnVolverIJ);
		btnRss = (ImageView) findViewById(R.id.btnRssIJ);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntIJ);

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

		Resources res = getResources();
		// Para el tabHost
		tabhostInfoJug = (TabHost) findViewById(R.id.tabhostInfoJug);
		tabhostInfoJug.setup();

		TabSpec specLesion = tabhostInfoJug.newTabSpec("svLesion");
		specLesion.setContent(R.id.svLesion);
		specLesion.setIndicator("", res.getDrawable(R.drawable.lesionado48));
		tabhostInfoJug.addTab(specLesion);

		TabSpec specDuda = tabhostInfoJug.newTabSpec("svDuda");
		specDuda.setContent(R.id.svDuda);
		specDuda.setIndicator("", res.getDrawable(R.drawable.duda48));
		tabhostInfoJug.addTab(specDuda);

		TabSpec specAcumulacion = tabhostInfoJug.newTabSpec("svAcumulacion");
		specAcumulacion.setContent(R.id.svAcumulacion);
		specAcumulacion.setIndicator("",
				res.getDrawable(R.drawable.acum_tarjetas48));
		tabhostInfoJug.addTab(specAcumulacion);

		TabSpec spec2Amarillas = tabhostInfoJug.newTabSpec("sv2Amarillas");
		spec2Amarillas.setContent(R.id.sv2Amarillas);
		spec2Amarillas.setIndicator("",
				res.getDrawable(R.drawable.dobleamarilla));
		tabhostInfoJug.addTab(spec2Amarillas);

		TabSpec specRoja = tabhostInfoJug.newTabSpec("svRoja");
		specRoja.setContent(R.id.svRoja);
		specRoja.setIndicator("", res.getDrawable(R.drawable.roja));
		tabhostInfoJug.addTab(specRoja);

		TabSpec specNoConv = tabhostInfoJug.newTabSpec("svNoConvocado");
		specNoConv.setContent(R.id.svNoConvocado);
		specNoConv.setIndicator("", res.getDrawable(R.drawable.no_convocado48));
		tabhostInfoJug.addTab(specNoConv);

		TabSpec specFilial = tabhostInfoJug.newTabSpec("svFilial");
		specFilial.setContent(R.id.svFilial);
		specFilial.setIndicator("", res.getDrawable(R.drawable.b48));
		tabhostInfoJug.addTab(specFilial);

		tabhostInfoJug.setCurrentTab(0);

		tblLesion = (TableLayout) findViewById(R.id.tblLesion);
		tblDuda = (TableLayout) findViewById(R.id.tblDuda);
		tblAcumulacion = (TableLayout) findViewById(R.id.tblAcumulacion);
		tbl2Amarillas = (TableLayout) findViewById(R.id.tbl2Amarillas);
		tblRoja = (TableLayout) findViewById(R.id.tblRoja);
		tblNoConvocado = (TableLayout) findViewById(R.id.tblNoConvocado);
		tblFilial = (TableLayout) findViewById(R.id.tblFilial);
		/**
		 * 
		 * LISTENERS Y COMPONENTES
		 * 
		 */

		/**
		 * 
		 * 
		 * TAREA
		 * 
		 */
		pDialog = new ProgressDialog(InfoJugadores.this);
		pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pDialog.setMessage(ConstantesParametros.DESCARGANDO_INFO_JUGADORES);
		pDialog.setCancelable(false);
		pDialog.setMax(100);

		pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						pDialog.dismiss();
						finish();
					}
				});
		pDialog.show();

		tareaWeb = new TareaInicialBDTask();
		tareaWeb.execute();
		/**
		 * 
		 * 
		 * TAREA
		 * 
		 */
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

			// Variables
			HttpClient httpclient = new DefaultHttpClient();
			String resString = null;
			HttpResponse response = null;
			InputStream is = null;
			BufferedReader reader = null;
			String line = null;

			// Create HTTP Client
			HttpGet httpget = new HttpGet(
					ConstantesParametros.DIRECCION_WEB_INFO_JUGADORES);
			try {
				response = httpclient.execute(httpget);
			} catch (ClientProtocolException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			// Executeit
			HttpEntity entity = response.getEntity();
			try {
				is = entity.getContent();
			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

			// Create an
			// InputStream with
			// the response
			try {
				reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}

			StringBuilder sb = new StringBuilder();
			try {
				while ((line = reader.readLine()) != null) {
					// Read line by line
					sb.append(line);
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
			resString = sb.toString();
			//
			// Result is here
			try {
				is.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

			return resString;

		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			// La cadena a analizar
			String cadena = result;

			// Extraemos la información
			listaEquiposInfo = extraerInfo(cadena);

			// Pintar informacion
			pintarInfo(listaEquiposInfo);

			// Cerramos
			pDialog.dismiss();
		}

		private void pintarInfo(List<EquipoInfoJugDTO> listaEquiposInfo) {

			if (listaEquiposInfo.size() > 0) {
				// LESIONADOS
				for (EquipoInfoJugDTO equipoInfoJugDTO : listaEquiposInfo) {
					pintaLesionados(equipoInfoJugDTO,
							equipoInfoJugDTO.getNombreEquipo());
					pintaDudas(equipoInfoJugDTO,
							equipoInfoJugDTO.getNombreEquipo());
					pintaAcumulacion(equipoInfoJugDTO,
							equipoInfoJugDTO.getNombreEquipo());
					pinta2Amarillas(equipoInfoJugDTO,
							equipoInfoJugDTO.getNombreEquipo());
					pintaRoja(equipoInfoJugDTO,
							equipoInfoJugDTO.getNombreEquipo());
					pintaNoConvocado(equipoInfoJugDTO,
							equipoInfoJugDTO.getNombreEquipo());
					pintaFilial(equipoInfoJugDTO,
							equipoInfoJugDTO.getNombreEquipo());
				}
			}
		}

		private void pintaFilial(EquipoInfoJugDTO equipoInfoJugDTO,
				String nombreEquipo) {
			if (equipoInfoJugDTO.getListaJugFilial() != null
					&& equipoInfoJugDTO.getListaJugFilial().size() > 0) {
				// Recuperamos el nombre del equipo
				int icono = buscarIconoEquipo(nombreEquipo);
				List<InfoJugDTO> listaJugadores = equipoInfoJugDTO
						.getListaJugFilial();
				StringBuffer textoMostrar = new StringBuffer();
				textoMostrar.append("\n\n");
				// Recorremos la lista
				for (InfoJugDTO infoJugDTO : listaJugadores) {
					String nombre = infoJugDTO.getNombre();
					String desc1 = infoJugDTO.getDesc1();
					String desc2 = infoJugDTO.getDesc2();
					textoMostrar.append("/// ");
					textoMostrar.append(nombre);
					textoMostrar.append(" ///");
					textoMostrar.append("\n\nDetalle --> ");
					textoMostrar.append(desc1);
					if (desc2 != null) {
						textoMostrar.append("\nDuracion --> ");
						textoMostrar.append(desc2);
					}
					textoMostrar.append("\n\n");
				}

				ImageView ivIcono = new ImageView(contexto);
				ivIcono.setImageResource(icono);

				TextView tvJugadores = new TextView(contexto);
				tvJugadores.setText(textoMostrar);
				tvJugadores.setTextColor(getResources()
						.getColor(R.color.blue_f));

				TableRow tbrow = new TableRow(contexto);
				tbrow.addView(ivIcono);
				tbrow.addView(tvJugadores);
				tbrow.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				tblFilial.addView(tbrow);
			}
		}

		private void pintaNoConvocado(EquipoInfoJugDTO equipoInfoJugDTO,
				String nombreEquipo) {
			if (equipoInfoJugDTO.getListaJugNoConvocado() != null
					&& equipoInfoJugDTO.getListaJugNoConvocado().size() > 0) {
				// Recuperamos el nombre del equipo
				int icono = buscarIconoEquipo(nombreEquipo);
				List<InfoJugDTO> listaJugadores = equipoInfoJugDTO
						.getListaJugNoConvocado();
				StringBuffer textoMostrar = new StringBuffer();
				textoMostrar.append("\n\n");
				// Recorremos la lista
				for (InfoJugDTO infoJugDTO : listaJugadores) {
					String nombre = infoJugDTO.getNombre();
					String desc1 = infoJugDTO.getDesc1();
					String desc2 = infoJugDTO.getDesc2();
					textoMostrar.append("/// ");
					textoMostrar.append(nombre);
					textoMostrar.append(" ///");
					textoMostrar.append("\n\nDetalle --> ");
					textoMostrar.append(desc1);
					if (desc2 != null) {
						textoMostrar.append("\nDuracion --> ");
						textoMostrar.append(desc2);
					}
					textoMostrar.append("\n\n");
				}

				ImageView ivIcono = new ImageView(contexto);
				ivIcono.setImageResource(icono);

				TextView tvJugadores = new TextView(contexto);
				tvJugadores.setText(textoMostrar);
				tvJugadores.setTextColor(getResources()
						.getColor(R.color.blue_f));

				TableRow tbrow = new TableRow(contexto);
				tbrow.addView(ivIcono);
				tbrow.addView(tvJugadores);
				tbrow.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				tblNoConvocado.addView(tbrow);
			}
		}

		private void pintaRoja(EquipoInfoJugDTO equipoInfoJugDTO,
				String nombreEquipo) {
			if (equipoInfoJugDTO.getListaJugRoja() != null
					&& equipoInfoJugDTO.getListaJugRoja().size() > 0) {
				// Recuperamos el nombre del equipo
				int icono = buscarIconoEquipo(nombreEquipo);
				List<InfoJugDTO> listaJugadores = equipoInfoJugDTO
						.getListaJugRoja();
				StringBuffer textoMostrar = new StringBuffer();
				textoMostrar.append("\n\n");
				// Recorremos la lista
				for (InfoJugDTO infoJugDTO : listaJugadores) {
					String nombre = infoJugDTO.getNombre();
					String desc1 = infoJugDTO.getDesc1();
					String desc2 = infoJugDTO.getDesc2();
					textoMostrar.append("/// ");
					textoMostrar.append(nombre);
					textoMostrar.append(" ///");
					textoMostrar.append("\n\nDetalle --> ");
					textoMostrar.append(desc1);
					if (desc2 != null) {
						textoMostrar.append("\nDuracion --> ");
						textoMostrar.append(desc2);
					}
					textoMostrar.append("\n\n");
				}

				ImageView ivIcono = new ImageView(contexto);
				ivIcono.setImageResource(icono);

				TextView tvJugadores = new TextView(contexto);
				tvJugadores.setText(textoMostrar);
				tvJugadores.setTextColor(getResources()
						.getColor(R.color.blue_f));

				TableRow tbrow = new TableRow(contexto);
				tbrow.addView(ivIcono);
				tbrow.addView(tvJugadores);
				tbrow.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				tblRoja.addView(tbrow);
			}
		}

		private void pinta2Amarillas(EquipoInfoJugDTO equipoInfoJugDTO,
				String nombreEquipo) {
			if (equipoInfoJugDTO.getListaJugDosAmarillas() != null
					&& equipoInfoJugDTO.getListaJugDosAmarillas().size() > 0) {
				// Recuperamos el nombre del equipo
				int icono = buscarIconoEquipo(nombreEquipo);
				List<InfoJugDTO> listaJugadores = equipoInfoJugDTO
						.getListaJugDosAmarillas();
				StringBuffer textoMostrar = new StringBuffer();
				textoMostrar.append("\n\n");
				// Recorremos la lista
				for (InfoJugDTO infoJugDTO : listaJugadores) {
					String nombre = infoJugDTO.getNombre();
					String desc1 = infoJugDTO.getDesc1();
					String desc2 = infoJugDTO.getDesc2();
					textoMostrar.append("/// ");
					textoMostrar.append(nombre);
					textoMostrar.append(" ///");
					textoMostrar.append("\n\nDetalle --> ");
					textoMostrar.append(desc1);
					if (desc2 != null) {
						textoMostrar.append("\nDuracion --> ");
						textoMostrar.append(desc2);
					}
					textoMostrar.append("\n\n");
				}

				ImageView ivIcono = new ImageView(contexto);
				ivIcono.setImageResource(icono);

				TextView tvJugadores = new TextView(contexto);
				tvJugadores.setText(textoMostrar);
				tvJugadores.setTextColor(getResources()
						.getColor(R.color.blue_f));

				TableRow tbrow = new TableRow(contexto);
				tbrow.addView(ivIcono);
				tbrow.addView(tvJugadores);
				tbrow.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				tbl2Amarillas.addView(tbrow);
			}
		}

		private void pintaAcumulacion(EquipoInfoJugDTO equipoInfoJugDTO,
				String nombreEquipo) {

			if (equipoInfoJugDTO.getListaJugAcumulacion() != null
					&& equipoInfoJugDTO.getListaJugAcumulacion().size() > 0) {
				// Recuperamos el nombre del equipo
				int icono = buscarIconoEquipo(nombreEquipo);
				List<InfoJugDTO> listaJugadores = equipoInfoJugDTO
						.getListaJugAcumulacion();
				StringBuffer textoMostrar = new StringBuffer();
				textoMostrar.append("\n\n");
				// Recorremos la lista
				for (InfoJugDTO infoJugDTO : listaJugadores) {
					String nombre = infoJugDTO.getNombre();
					String desc1 = infoJugDTO.getDesc1();
					String desc2 = infoJugDTO.getDesc2();
					textoMostrar.append("/// ");
					textoMostrar.append(nombre);
					textoMostrar.append(" ///");
					textoMostrar.append("\n\nDetalle --> ");
					textoMostrar.append(desc1);
					if (desc2 != null) {
						textoMostrar.append("\nDuracion --> ");
						textoMostrar.append(desc2);
					}
					textoMostrar.append("\n\n");
				}

				ImageView ivIcono = new ImageView(contexto);
				ivIcono.setImageResource(icono);

				TextView tvJugadores = new TextView(contexto);
				tvJugadores.setText(textoMostrar);
				tvJugadores.setTextColor(getResources()
						.getColor(R.color.blue_f));

				TableRow tbrow = new TableRow(contexto);
				tbrow.addView(ivIcono);
				tbrow.addView(tvJugadores);
				tbrow.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				tblAcumulacion.addView(tbrow);
			}
		}

		private void pintaDudas(EquipoInfoJugDTO equipoInfoJugDTO,
				String nombreEquipo) {
			if (equipoInfoJugDTO.getListaJugDuda() != null
					&& equipoInfoJugDTO.getListaJugDuda().size() > 0) {
				// Recuperamos el nombre del equipo
				int icono = buscarIconoEquipo(nombreEquipo);
				List<InfoJugDTO> listaJugadores = equipoInfoJugDTO
						.getListaJugDuda();
				StringBuffer textoMostrar = new StringBuffer();
				textoMostrar.append("\n\n");
				// Recorremos la lista
				for (InfoJugDTO infoJugDTO : listaJugadores) {
					String nombre = infoJugDTO.getNombre();
					String desc1 = infoJugDTO.getDesc1();
					String desc2 = infoJugDTO.getDesc2();
					textoMostrar.append("/// ");
					textoMostrar.append(nombre);
					textoMostrar.append(" ///");
					textoMostrar.append("\n\nDetalle --> ");
					textoMostrar.append(desc1);
					if (desc2 != null) {
						textoMostrar.append("\nDuracion --> ");
						textoMostrar.append(desc2);
					}
					textoMostrar.append("\n\n");
				}

				ImageView ivIcono = new ImageView(contexto);
				ivIcono.setImageResource(icono);

				TextView tvJugadores = new TextView(contexto);
				tvJugadores.setText(textoMostrar);
				tvJugadores.setTextColor(getResources()
						.getColor(R.color.blue_f));

				TableRow tbrow = new TableRow(contexto);
				tbrow.addView(ivIcono);
				tbrow.addView(tvJugadores);
				tbrow.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				tblDuda.addView(tbrow);
			}
		}

		private void pintaLesionados(EquipoInfoJugDTO equipoInfoJugDTO,
				String nombreEquipo) {
			if (equipoInfoJugDTO.getListaJugLesionados() != null
					&& equipoInfoJugDTO.getListaJugLesionados().size() > 0) {
				// Recuperamos el nombre del equipo
				int icono = buscarIconoEquipo(nombreEquipo);
				List<InfoJugDTO> listaJugadores = equipoInfoJugDTO
						.getListaJugLesionados();
				StringBuffer textoMostrar = new StringBuffer();

				textoMostrar.append("\n\n");
				// Recorremos la lista
				for (InfoJugDTO infoJugDTO : listaJugadores) {
					String nombre = infoJugDTO.getNombre();
					String desc1 = infoJugDTO.getDesc1();
					String desc2 = infoJugDTO.getDesc2();
					textoMostrar.append("/// ");
					textoMostrar.append(nombre);
					textoMostrar.append(" ///");
					textoMostrar.append("\n\nDetalle --> ");
					textoMostrar.append(desc1);
					if (desc2 != null) {
						textoMostrar.append("\nDuracion --> ");
						textoMostrar.append(desc2);
					}
					textoMostrar.append("\n\n");
				}

				ImageView ivIcono = new ImageView(contexto);
				ivIcono.setImageResource(icono);

				TextView tvJugadores = new TextView(contexto);
				tvJugadores.setText(textoMostrar);
				tvJugadores.setTextColor(getResources()
						.getColor(R.color.blue_f));

				TableRow tbrow = new TableRow(contexto);
				tbrow.addView(ivIcono);
				tbrow.addView(tvJugadores);
				tbrow.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				tblLesion.addView(tbrow);
			}
		}

		private int buscarIconoEquipo(String equipoSelec) {
			if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ATHLETIC)) {
				return R.drawable.athletic_bilbao_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_ATLETICO)) {
				return R.drawable.atletico_madrid_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_BARCELONA)) {
				return R.drawable.barcelona_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_BETIS)) {
				return R.drawable.real_betis_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_CELTA)) {
				return R.drawable.celta_de_vigo_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_ALMERIA)) {
				return R.drawable.almeria_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_ESPANOL)) {
				return R.drawable.espanyol_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_GETAFE)) {
				return R.drawable.getafe_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_GRANADA)) {
				return R.drawable.granada_cf;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_LEVANTE)) {
				return R.drawable.logo_levante;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_MALAGA)) {
				return R.drawable.malaga_cf_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_ELCHE)) {
				return R.drawable.elche_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_OSASUNA)) {
				return R.drawable.osasuna_icon;
			} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_RAYO)) {
				return R.drawable.rayo_vallecano_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_RMADRID)) {
				return R.drawable.real_madrid_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_RSOCIEDAD)) {
				return R.drawable.real_sociedad_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_SEVILLA)) {
				return R.drawable.sevilla_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_VALENCIA)) {
				return R.drawable.valencia_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_VALLADOLID)) {
				return R.drawable.real_valladolid_icon;
			} else if (equipoSelec
					.equals(ConstantesParametros.EQUIPO_SEL_VILLARREAL)) {
				return R.drawable.villarreal_icon;
			} else {
				return 0;
			}
		}

		// Método que extrae la info a través de Expresiones Regulares
		private List<EquipoInfoJugDTO> extraerInfo(String cadena) {

			List<EquipoInfoJugDTO> listaEquiInfo = new ArrayList<EquipoInfoJugDTO>();

			// Primero dividimos el texto que queremos tratar. Por equipos
			String[] textoCortado = cadena
					.split(ConstantesParametros.CADENA_PARTIR_TEXTO_INICIAL_INFO);

			Pattern patronEquipo = Pattern
					.compile(ConstantesParametros.COMIENZO_EQUIPOS_INFO);
			Pattern patronJugadorEstado = Pattern
					.compile(ConstantesParametros.PATRON_ESTADO);
			Pattern patronJugadorDesc1 = Pattern
					.compile(ConstantesParametros.PATRON_DESC1);
			Pattern patronJugadorDesc2 = Pattern
					.compile(ConstantesParametros.PATRON_DESC2);

			// Recorremos cada uno de los textos (por equipo). El primero no lo
			// queremos
			for (int i = 1; i < textoCortado.length; i++) {
				// Variables
				EquipoInfoJugDTO equipo = new EquipoInfoJugDTO();
				List<InfoJugDTO> listaJugLesionados = new ArrayList<InfoJugDTO>();
				List<InfoJugDTO> listaJugDuda = new ArrayList<InfoJugDTO>();
				List<InfoJugDTO> listaJugAcumulacion = new ArrayList<InfoJugDTO>();
				List<InfoJugDTO> listaJugDosAmarillas = new ArrayList<InfoJugDTO>();
				List<InfoJugDTO> listaJugRoja = new ArrayList<InfoJugDTO>();
				List<InfoJugDTO> listaJugNoConvocado = new ArrayList<InfoJugDTO>();
				List<InfoJugDTO> listaJugFilial = new ArrayList<InfoJugDTO>();

				String cadenaCortada = textoCortado[i];
				// Buscamos el equipo
				Matcher matcherEquipo = patronEquipo.matcher(cadenaCortada);
				if (matcherEquipo.find()) {
					String nombreEquipo = matcherEquipo.group(1);
					String[] textoCortadoE = nombreEquipo
							.split(ConstantesParametros.FIN_EQUIPOS_INFO);
					// Seteamos el nombre del equipo
					equipo.setNombreEquipo(textoCortadoE[0]);
				}

				// Ahora buscamos cada uno de los jugadores de ese equipo
				String[] textoCortadoJ = cadenaCortada
						.split(ConstantesParametros.PATRON_NOMBRE);
				for (int j = 1; j < textoCortadoJ.length; j++) {
					// Variable
					InfoJugDTO infoJug = new InfoJugDTO();
					String jugador = null;
					String estado = null;
					String desc1 = null;
					String desc2 = null;

					String textoJ = textoCortadoJ[j];
					// Partimos el String por "</a>"
					String[] jugadorSolo1 = textoJ
							.split(ConstantesParametros.FIN_JUGADOR_INFO);
					String[] jugadorSolo2 = jugadorSolo1[0].split("'>");
					// Nos quedamos con el primero que es el nombre del jugador
					jugador = jugadorSolo2[1];

					// Setamos el nombre
					infoJug.setNombre(jugador);

					// Lo borramos de la busqueda
					textoJ.replaceFirst(jugadorSolo2[1], "");

					// Ahora el estado
					Matcher matcherEstado = patronJugadorEstado.matcher(textoJ);
					if (matcherEstado.find()) {

						String textoEstado = matcherEstado.group(1);
						// Partimos por ".png"
						String[] estadoSolo = textoEstado
								.split(ConstantesParametros.PATRON_FIN_ESTADO);
						// Nos quedamos con el primero que es el estado del
						// jugador
						estado = estadoSolo[0];
						// Lo borramos de la busqueda
						textoJ.replaceFirst(estadoSolo[0], "");
					}

					// Ahora desc1
					Matcher matcherDesc1 = patronJugadorDesc1.matcher(textoJ);
					if (matcherDesc1.find()) {

						String textoDesc1 = matcherDesc1.group(1);
						// Partimos por ".png"
						String[] desc1Solo = textoDesc1
								.split(ConstantesParametros.PATRON_FIN_DESC1);
						// Nos quedamos con el primero que es el estado del
						// jugador
						desc1 = desc1Solo[0];

						infoJug.setDesc1(desc1);

						// Lo borramos de la busqueda
						textoJ.replaceFirst(desc1Solo[0], "");
					}

					// Ahora desc2
					Matcher matcherDesc2 = patronJugadorDesc2.matcher(textoJ);
					if (matcherDesc2.find()) {

						String textoDesc2 = matcherDesc2.group(1);
						// Partimos por ".png"
						String[] desc2Solo = textoDesc2
								.split(ConstantesParametros.PATRON_FIN_DESC2);
						// Nos quedamos con el primero que es el estado del
						// jugador
						desc2 = desc2Solo[0];

						infoJug.setDesc2(desc2);

						// Lo borramos de la busqueda
						textoJ.replaceFirst(desc2Solo[0], "");
					}

					if (estado.equals(ConstantesParametros.ESTADO_LESION)) {
						listaJugLesionados.add(infoJug);
					} else if (estado.equals(ConstantesParametros.ESTADO_DUDA)) {
						listaJugDuda.add(infoJug);
					} else if (estado
							.equals(ConstantesParametros.ESTADO_FILIAL)) {
						listaJugFilial.add(infoJug);
					} else if (estado
							.equals(ConstantesParametros.ESTADO_DOBLE_AMARILLA)) {
						listaJugDosAmarillas.add(infoJug);
					} else if (estado
							.equals(ConstantesParametros.ESTADO_ACUMULACION)) {
						listaJugAcumulacion.add(infoJug);
					} else if (estado.equals(ConstantesParametros.ESTADO_ROJA)) {
						listaJugRoja.add(infoJug);
					} else if (estado.equals("seleccion")) {
						listaJugNoConvocado.add(infoJug);
					} else if (estado
							.equals(ConstantesParametros.ESTADO_NO_CONVOCADO)) {
						listaJugNoConvocado.add(infoJug);
					}

				}

				equipo.setListaJugLesionados(listaJugLesionados);
				equipo.setListaJugDuda(listaJugDuda);
				equipo.setListaJugFilial(listaJugFilial);
				equipo.setListaJugDosAmarillas(listaJugDosAmarillas);
				equipo.setListaJugAcumulacion(listaJugAcumulacion);
				equipo.setListaJugRoja(listaJugRoja);
				equipo.setListaJugNoConvocado(listaJugNoConvocado);

				listaEquiInfo.add(equipo);
			}

			return listaEquiInfo;

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

}
