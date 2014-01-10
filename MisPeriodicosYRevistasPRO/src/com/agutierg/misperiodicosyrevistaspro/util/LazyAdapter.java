package com.agutierg.misperiodicosyrevistaspro.util;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.agutierg.misperiodicosyrevistaspro.R;
import com.agutierg.misperiodicosyrevistaspro.constants.ConstantesVariables;
import com.agutierg.misperiodicosyrevistaspro.database.MisPerYRevSQLite;
import com.agutierg.misperiodicosyrevistaspro.dto.Publicacion;

public class LazyAdapter extends BaseAdapter {

	private Activity activity;
	private List<Publicacion> data;
	private static LayoutInflater inflater = null;
	private MisPerYRevSQLite baseDatosMPYR;

	public LazyAdapter(Activity a, List<Publicacion> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.size();
	}

	public Publicacion getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);

		TextView nombre = (TextView) vi.findViewById(R.id.tvNombreROW);
		TextView tipo = (TextView) vi.findViewById(R.id.tvTipoPubROW);

		ImageView thumb_image = (ImageView) vi.findViewById(R.id.list_image);

		ImageView isFavorito = (ImageView) vi.findViewById(R.id.ivFavoritoROW);

		Publicacion publicacion = new Publicacion();
		publicacion = data.get(position);

		// Setting all values in listview
		nombre.setText(publicacion.getDescripcion());

		if (ConstantesVariables.TIPO_PUBLICACION_PERIODICO.equals(publicacion
				.getTipoPublicacion())) {
			tipo.setText(ConstantesVariables.PUBLICACION_PERIODICO);
			thumb_image.setImageResource(imagenesPeriodicos(publicacion
					.getDescripcion()));
		} else if (ConstantesVariables.TIPO_PUBLICACION_REVISTA
				.equals(publicacion.getTipoPublicacion())) {
			tipo.setText(ConstantesVariables.PUBLICACION_REVISTA);
			thumb_image.setImageResource(imagenesRevistas(publicacion
					.getDescripcion()));
		} else if (ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO
				.equals(publicacion.getTipoPublicacion())) {
			tipo.setText(ConstantesVariables.PUBLICACION_PERIODICO_DEPORTIVO);
			thumb_image.setImageResource(imagenesPerDepor(publicacion
					.getDescripcion()));
		} else if (ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON
				.equals(publicacion.getTipoPublicacion())) {
			tipo.setText(ConstantesVariables.PUBLICACION_REVISTA_CORAZON);
			thumb_image.setImageResource(imagenesReviCora(publicacion
					.getDescripcion()));
		} else if (ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA
				.equals(publicacion.getTipoPublicacion())) {
			tipo.setText(ConstantesVariables.PUBLICACION_PRENSA_EXTRANJERA);
			thumb_image.setImageResource(imagenesPrenExt(publicacion
					.getDescripcion()));
		} else if (ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA
				.equals(publicacion.getTipoPublicacion())) {
			tipo.setText(ConstantesVariables.PUBLICACION_REVISTAS_CIENT);
			thumb_image.setImageResource(imagenesRevCien(publicacion
					.getDescripcion()));
		}

		if (publicacion.isFavorito()) {
			isFavorito.setImageResource(R.drawable.estrella2);
			isFavorito.setContentDescription(vi.getResources().getString(
					R.string.favorito)
					+ "_" + publicacion.getIdPublicacion());
		} else {
			isFavorito.setImageResource(R.drawable.estrella_no);
			isFavorito.setContentDescription(vi.getResources().getString(
					R.string.nofavorito)
					+ "_" + publicacion.getIdPublicacion());
		}

		/**
		 * Base de datos
		 */
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		baseDatosMPYR = new MisPerYRevSQLite(vi.getContext(), "DBMisPerYRev",
				null, 1);

		isFavorito.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ImageView ivIsFavo = (ImageView) v;
				Publicacion publicacion = new Publicacion();
				publicacion = data.get(position);

				int idPublicacion;
				String contentDesc = ivIsFavo.getContentDescription()
						.toString();
				// Partimos el string por el separador
				String[] cortado = contentDesc.split("_");
				String id = null;
				if (cortado != null && cortado[1] != null) {
					id = cortado[1];
					idPublicacion = Integer.valueOf(id);
					// SI ESTABA MARCADO COMO FAVORITO, LO CONVERTIMOS A NO
					// FAVORITO
					if (cortado[0].equals(v.getResources().getString(
							R.string.favorito))) {
						ivIsFavo.setImageResource(R.drawable.estrella_no);
						publicacion.setFavorito(false);
						ivIsFavo.setContentDescription(v.getResources()
								.getString(R.string.nofavorito) + "_" + id);

						// HACEMOS EL UPDATE
						SQLiteDatabase db = baseDatosMPYR.getWritableDatabase();
						// Si hemos abierto correctamente la base de datos
						if (db != null) {
							try {
								db.execSQL("UPDATE Publicacion SET isFavorito = 0 WHERE idPublicacion = "
										+ idPublicacion);
							} catch (Exception e) {
								e.printStackTrace();
							}
							// Cerramos la base de datos
							db.close();
						}
					} // SI ESTABA MARCADO COMO NO FAVORITO, LO MARCAMOS COMO
						// FAVORITO
					else {

						ivIsFavo.setImageResource(R.drawable.estrella2);
						publicacion.setFavorito(true);
						ivIsFavo.setContentDescription(v.getResources()
								.getString(R.string.favorito) + "_" + id);

						// HACEMOS EL UPDATE
						SQLiteDatabase db = baseDatosMPYR.getWritableDatabase();
						// Si hemos abierto correctamente la base de datos
						if (db != null) {
							try {
								db.execSQL("UPDATE Publicacion SET isFavorito = 1 WHERE idPublicacion = "
										+ idPublicacion);
							} catch (Exception e) {
								e.printStackTrace();
							}
							// Cerramos la base de datos
							db.close();
						}
					}
				}

			}
		});

		return vi;
	}

	private int imagenesRevCien(String nombre) {
		int imagen = R.drawable.extranjera;

		if ("Muy Interesante".equals(nombre)) {
			imagen = R.drawable.muyinteresante;
		} else if ("Quo".equals(nombre)) {
			imagen = R.drawable.quo;
		} else if ("PC World".equals(nombre)) {
			imagen = R.drawable.pcworld;
		} else if ("Computing".equals(nombre)) {
			imagen = R.drawable.computing;
		} else if ("Mundo Geo".equals(nombre)) {
			imagen = R.drawable.mundogeo;
		}
		return imagen;
	}

	private int imagenesPrenExt(String nombre) {
		int imagen = R.drawable.extranjera;

		if ("La Nación (Argentina)".equals(nombre)) {
			imagen = R.drawable.lanacionar;
		} else if ("El Diario (Bolivia)".equals(nombre)) {
			imagen = R.drawable.eldiariobolivia;
		} else if ("The Globe And Mail (Canadá)".equals(nombre)) {
			imagen = R.drawable.ca_globe_mail;
		} else if ("El Tiempo (Colombia)".equals(nombre)) {
			imagen = R.drawable.eltiempocolombia;
		} else if ("El Periódico de México (México)".equals(nombre)) {
			imagen = R.drawable.elperiodicodemexico;
		} else if ("El Universal (México)".equals(nombre)) {
			imagen = R.drawable.mx_universal;
		} else if ("La Nación (Paraguay)".equals(nombre)) {
			imagen = R.drawable.nacionparaguay;
		} else if ("La República (Perú)".equals(nombre)) {
			imagen = R.drawable.pe_republica;
		} else if ("El País (Uruguay)".equals(nombre)) {
			imagen = R.drawable.uy_elpais;
		} else if ("The New York Times (USA)".equals(nombre)) {
			imagen = R.drawable.thenewyorktimes;
		} else if ("El Universal (Venezuela)".equals(nombre)) {
			imagen = R.drawable.eluniversalvenezuela;
		} else if ("CNN (Español)".equals(nombre)) {
			imagen = R.drawable.cnnespana;
		} else if ("The Times (Inglaterra)".equals(nombre)) {
			imagen = R.drawable.thetimes;
		} else if ("The Sun (Inglaterra)".equals(nombre)) {
			imagen = R.drawable.thesun;
		} else if ("The Independent (Inglaterra)".equals(nombre)) {
			imagen = R.drawable.theindependent;
		} else if ("Corriere (Italia)".equals(nombre)) {
			imagen = R.drawable.corriere;
		} else if ("The Times Of India (India)".equals(nombre)) {
			imagen = R.drawable.the_times_of_india;
		} else if ("Berliner Morgenpost (Alemania)".equals(nombre)) {
			imagen = R.drawable.berlinermorgenpost;
		} else if ("The Washington Post (USA)".equals(nombre)) {
			imagen = R.drawable.the_washington_post;
		} else if ("The Telegraph (Inglaterra)".equals(nombre)) {
			imagen = R.drawable.the_telegraph;
		} else if ("Le Monde (Francia)".equals(nombre)) {
			imagen = R.drawable.lemonde;
		} else if ("Courrier Picard (Francia)".equals(nombre)) {
			imagen = R.drawable.courrierpicard;
		} else if ("The Japan Times (Japón)".equals(nombre)) {
			imagen = R.drawable.japantimes;
		} else if ("O Globo (Brasil)".equals(nombre)) {
			imagen = R.drawable.br_oglobo;
		}

		return imagen;
	}

	private int imagenesReviCora(String nombre) {
		int imagen = R.drawable.corazon;

		if ("AR".equals(nombre)) {
			imagen = R.drawable.ar;
		} else if ("Cuore".equals(nombre)) {
			imagen = R.drawable.cuore;
		} else if ("Hola".equals(nombre)) {
			imagen = R.drawable.hola;
		} else if ("Cosmopolitan".equals(nombre)) {
			imagen = R.drawable.cosmopolitan;
		} else if ("Elle".equals(nombre)) {
			imagen = R.drawable.elle;
		} else if ("Love".equals(nombre)) {
			imagen = R.drawable.love;
		} else if ("Marie Claire".equals(nombre)) {
			imagen = R.drawable.marie_claire;
		} else if ("Semana".equals(nombre)) {
			imagen = R.drawable.semana;
		} else if ("Super Pop".equals(nombre)) {
			imagen = R.drawable.superpop;
		} else if ("Diez Minutos".equals(nombre)) {
			imagen = R.drawable.diezminutos;
		} else if ("Sálvame".equals(nombre)) {
			imagen = R.drawable.salvame;
		} else if ("Vogue".equals(nombre)) {
			imagen = R.drawable.vogue;
		}

		return imagen;
	}

	private int imagenesPerDepor(String nombre) {
		int imagen = R.drawable.diarios_deportivos;

		if ("Marca".equals(nombre)) {
			imagen = R.drawable.marca;
		} else if ("As".equals(nombre)) {
			imagen = R.drawable.as;
		} else if ("Mundo Deportivo".equals(nombre)) {
			imagen = R.drawable.mundodeportivo;
		} else if ("Superdeporte".equals(nombre)) {
			imagen = R.drawable.superdeporte;
		} else if ("Sport".equals(nombre)) {
			imagen = R.drawable.sport;
		} else if ("Canal Deportivo".equals(nombre)) {
			imagen = R.drawable.canaldeportivo;
		} else if ("Mundo Deportivo Atletico Madrid".equals(nombre)) {
			imagen = R.drawable.mundodeportivo_atletico;
		} else if ("Mundo Deportivo Athletic Bilbao".equals(nombre)) {
			imagen = R.drawable.mundoathletic;
		} else if ("Mundo Deportivo Real Sociedad".equals(nombre)) {
			imagen = R.drawable.mundodeportivorealsociedad;
		} else if ("Estadio Deportivo".equals(nombre)) {
			imagen = R.drawable.estadio_deportivo;
		}

		return imagen;
	}

	private int imagenesRevistas(String nombre) {
		int imagen = R.drawable.revistas2;

		if ("Interview".equals(nombre)) {
			imagen = R.drawable.interview;
		} else if ("Emprendedores".equals(nombre)) {
			imagen = R.drawable.revistaemprendedores;
		} else if ("Actualidad Económica".equals(nombre)) {
			imagen = R.drawable.actualidadeconomica;
		} else if ("Clio".equals(nombre)) {
			imagen = R.drawable.clio;
		} else if ("Crecer Feliz".equals(nombre)) {
			imagen = R.drawable.crecerfeliz;
		} else if ("Ser Padres".equals(nombre)) {
			imagen = R.drawable.serpadres;
		} else if ("Diseño Interior".equals(nombre)) {
			imagen = R.drawable.disenoo_interior_n136;
		} else if ("Casa Diez".equals(nombre)) {
			imagen = R.drawable.casadiez;
		} else if ("Casa y Estilo".equals(nombre)) {
			imagen = R.drawable.casaestilo;
		} else if ("Mi Casa".equals(nombre)) {
			imagen = R.drawable.micasa;
		} else if ("Casa y Campo".equals(nombre)) {
			imagen = R.drawable.casaycampo;
		} else if ("Elle Decor".equals(nombre)) {
			imagen = R.drawable.elledecor;
		} else if ("Nuevo Estilo".equals(nombre)) {
			imagen = R.drawable.nestilo;
		} else if ("El Jueves".equals(nombre)) {
			imagen = R.drawable.eljueves;
		} else if ("El Rellano".equals(nombre)) {
			imagen = R.drawable.elrellano;
		} else if ("FHM".equals(nombre)) {
			imagen = R.drawable.fhm;
		} else if ("GQ Men Style".equals(nombre)) {
			imagen = R.drawable.cqmenstyle;
		} else if ("Vida Premium".equals(nombre)) {
			imagen = R.drawable.vidapremium;
		} else if ("Maxwell".equals(nombre)) {
			imagen = R.drawable.maxwell;
		} else if ("Soho".equals(nombre)) {
			imagen = R.drawable.soho;
		} else if ("Vavel".equals(nombre)) {
			imagen = R.drawable.vavel;
		} else if ("Futbol Total".equals(nombre)) {
			imagen = R.drawable.futboltotal;
		} else if ("Windsurf".equals(nombre)) {
			imagen = R.drawable.windsurf;
		}

		return imagen;
	}

	private int imagenesPeriodicos(String nombre) {
		int imagen = R.drawable.icon_news2;

		if ("El Mundo".equals(nombre)) {
			imagen = R.drawable.elmundo;
		} else if ("El País".equals(nombre)) {
			imagen = R.drawable.el_pais;
		} else if ("ABC".equals(nombre)) {
			imagen = R.drawable.abc;
		} else if ("20 Minutos".equals(nombre)) {
			imagen = R.drawable.veinteminutos;
		} else if ("Qué".equals(nombre)) {
			imagen = R.drawable.que;
		} else if ("La Razón".equals(nombre)) {
			imagen = R.drawable.la_razon;
		} else if ("La Vanguardia".equals(nombre)) {
			imagen = R.drawable.lavanguardia;
		} else if ("El Correo".equals(nombre)) {
			imagen = R.drawable.elcorreo;
		} else if ("elPeriódico.com".equals(nombre)) {
			imagen = R.drawable.elperiodico_com;
		} else if ("Heraldo".equals(nombre)) {
			imagen = R.drawable.hn_heraldo;
		} else if ("La Gaceta".equals(nombre)) {
			imagen = R.drawable.la_gaceta;
		} else if ("La Voz de Galicia".equals(nombre)) {
			imagen = R.drawable.vozgalicia;
		} else if ("Canarias 7".equals(nombre)) {
			imagen = R.drawable.canarias7;
		} else if ("El Diario Vasco".equals(nombre)) {
			imagen = R.drawable.diariovasco;
		} else if ("Diario de Sevilla".equals(nombre)) {
			imagen = R.drawable.diario_sevilla_p_1;
		} else if ("El Comercio".equals(nombre)) {
			imagen = R.drawable.el_comercio;
		} else if ("El Diario Montañés".equals(nombre)) {
			imagen = R.drawable.diario_montanes;
		} else if ("Mediterráneo".equals(nombre)) {
			imagen = R.drawable.elperiodico_mediterraneo;
		} else if ("El Periódico de Aragón".equals(nombre)) {
			imagen = R.drawable.periodico_aragon;
		} else if ("Faro de Vigo".equals(nombre)) {
			imagen = R.drawable.farodevigo;
		} else if ("La Nueva España".equals(nombre)) {
			imagen = R.drawable.portada_nueva_espana;
		} else if ("La Región".equals(nombre)) {
			imagen = R.drawable.laregion;
		} else if ("Levante".equals(nombre)) {
			imagen = R.drawable.levante;
		} else if ("Atlántico".equals(nombre)) {
			imagen = R.drawable.atlantico;
		} else if ("Deia".equals(nombre)) {
			imagen = R.drawable.deia;
		} else if ("Alto Aragón".equals(nombre)) {
			imagen = R.drawable.altoaragon;
		} else if ("elPeriódico.cat".equals(nombre)) {
			imagen = R.drawable.elperiodico_cat;
		} else if ("El Periódico Extremadura".equals(nombre)) {
			imagen = R.drawable.elperiodicoextremadura;
		} else if ("El Punt Avui".equals(nombre)) {
			imagen = R.drawable.elpuntdavui;
		} else if ("La Vanguardia Catalunya".equals(nombre)) {
			imagen = R.drawable.la_vanguardia_catalunya;
		} else if ("Vila Web".equals(nombre)) {
			imagen = R.drawable.vilaweb;
		} else if ("Cinco Días".equals(nombre)) {
			imagen = R.drawable.cincodias;
		} else if ("El Economista".equals(nombre)) {
			imagen = R.drawable.eleconomista;
		} else if ("Expansión".equals(nombre)) {
			imagen = R.drawable.expansion_640;
		}
		return imagen;
	}
}
