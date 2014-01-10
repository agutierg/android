package com.agutierg.comuniopuntos;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.dto.EquiPuntDTO;
import com.agutierg.comuniopuntos.dto.EquiPuntSerializable;
import com.google.ads.AdView;

public class PuntosGenerales extends Activity {

	private ImageButton ibtnAthletic;
	private ImageButton ibtnAtletico;
	private ImageButton ibtnBarcelona;
	private ImageButton ibtnCelta;
	private ImageButton ibtnAlmeria;
	private ImageButton ibtnEspanol;
	private ImageButton ibtnGetafe;
	private ImageButton ibtnGranada;
	private ImageButton ibtnLevante;
	private ImageButton ibtnMalaga;
	private ImageButton ibtnOsasuna;
	private ImageButton ibtnRayo;
	private ImageButton ibtnBetis;
	private ImageButton ibtnRMadrid;
	private ImageButton ibtnElche;
	private ImageButton ibtnRSociedad;
	private ImageButton ibtnValladolid;
	private ImageButton ibtnVillarreal;
	private ImageButton ibtnSevilla;
	private ImageButton ibtnValencia;
	private ImageButton ibtnOnceIdeal;

	// Submenú
	private ImageView btnAyuda;
	private ImageView btnInfo;
	private ImageView btnJornada;
	private ImageView btnVolver;
	private ImageView btnRss;
	private ImageView btnPosPunt;

	private int duration = Toast.LENGTH_SHORT;

	private EquiPuntSerializable puntosYEquipos;

	private LinearLayout llPuntosGenerales;

	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_puntos_generales);

		// Crear la adView
		// adView = new AdView(this, AdSize.BANNER, "a151115e5f5581f");
		// adView.setGravity(Gravity.CENTER);

		// Buscar el LinearLayout suponiendo que se le haya asignado
		// el atributo android:id="@+id/mainLayout"
		// llPuntosGenerales = (LinearLayout)
		// findViewById(R.id.llPuntosGenerales);

		// Añadirle la adView
		// llPuntosGenerales.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		// adView.loadAd(new AdRequest());

		// Recogemos los puntos de los equipos que vienen por parámetro
		Bundle bundle = getIntent().getExtras();

		if (bundle != null
				&& bundle
						.getSerializable(ConstantesParametros.EQUIPOS_Y_PUNTOS) != null) {
			puntosYEquipos = (EquiPuntSerializable) bundle
					.getSerializable(ConstantesParametros.EQUIPOS_Y_PUNTOS);
		}

		/**
		 * Elementos y acciones de los elementos
		 */
		// Recuperamos los botones
		ibtnAthletic = (ImageButton) findViewById(R.id.ibtnAthletic);
		ibtnAtletico = (ImageButton) findViewById(R.id.ibtnAtletico);
		ibtnBarcelona = (ImageButton) findViewById(R.id.ibtnBarcelona);
		ibtnCelta = (ImageButton) findViewById(R.id.ibtnCelta);
		ibtnAlmeria = (ImageButton) findViewById(R.id.ibtnAlmeria);
		ibtnEspanol = (ImageButton) findViewById(R.id.ibtnEspanol);
		ibtnGetafe = (ImageButton) findViewById(R.id.ibtnGetafe);
		ibtnGranada = (ImageButton) findViewById(R.id.ibtnGranada);
		ibtnLevante = (ImageButton) findViewById(R.id.ibtnLevante);
		ibtnMalaga = (ImageButton) findViewById(R.id.ibtnMalaga);
		ibtnOsasuna = (ImageButton) findViewById(R.id.ibtnOsasuna);
		ibtnRayo = (ImageButton) findViewById(R.id.ibtnRayo);
		ibtnBetis = (ImageButton) findViewById(R.id.ibtnBetis);
		ibtnRMadrid = (ImageButton) findViewById(R.id.ibtnRMadrid);
		ibtnElche = (ImageButton) findViewById(R.id.ibtnElche);
		ibtnRSociedad = (ImageButton) findViewById(R.id.ibtnRSociedad);
		ibtnValladolid = (ImageButton) findViewById(R.id.ibtnValladolid);
		ibtnVillarreal = (ImageButton) findViewById(R.id.ibtnVillarreal);
		ibtnSevilla = (ImageButton) findViewById(R.id.ibtnSevilla);
		ibtnValencia = (ImageButton) findViewById(R.id.ibtnValencia);
		ibtnOnceIdeal = (ImageButton) findViewById(R.id.ibtnOnceIdeal);

		// Listeners
		ibtnAthletic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_ATHLETIC)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_ATHLETIC);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});

		ibtnAtletico.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_ATLETICO)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_ATLETICO);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});

		ibtnBarcelona.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_BARCELONA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_BARCELONA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});

		ibtnCelta.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_CELTA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_CELTA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});

		ibtnAlmeria.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_ALMERIA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_ALMERIA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnEspanol.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_ESPANOL)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_ESPANOL);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnGetafe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_GETAFE)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_GETAFE);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnGranada.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_GRANADA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_GRANADA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnLevante.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_LEVANTE)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_LEVANTE);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnMalaga.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_MALAGA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_MALAGA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnOsasuna.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_OSASUNA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_OSASUNA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnRayo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_RAYO)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_RAYO);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnBetis.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_BETIS)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_BETIS);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnRMadrid.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_RMADRID)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_RMADRID);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnElche.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_ELCHE)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_ELCHE);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnRSociedad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_RSOCIEDAD)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_RSOCIEDAD);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnValladolid.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_VALLADOLID)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_VALLADOLID);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnVillarreal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_VILLARREAL)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_VILLARREAL);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnSevilla.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_SEVILLA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_SEVILLA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});
		ibtnValencia.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_SEL_VALENCIA)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_SEL_VALENCIA);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});

		ibtnOnceIdeal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent vistaPuntosGenEquipo = new Intent(view.getContext(),
						PuntosGeneralesEquipo.class);
				if (puntosYEquipos != null) {

					List<EquiPuntDTO> listaEquPuntos = puntosYEquipos
							.getListaEquPuntos();

					// Si aún no ha jugado
					if (listaEquPuntos != null && listaEquPuntos.size() > 0) {
						boolean haJugado = false;
						for (EquiPuntDTO equiPuntDTO : listaEquPuntos) {
							if (equiPuntDTO != null
									&& equiPuntDTO
											.getNombreEquipo()
											.equals(ConstantesParametros.EQUIPO_ONCE_IDEAL)
									&& equiPuntDTO.getListaJugPuntos() != null
									&& equiPuntDTO.getListaJugPuntos().size() > 0) {
								// Ponemos que hemos seleccionado este equipo
								puntosYEquipos
										.setEquSeleccionado(ConstantesParametros.EQUIPO_ONCE_IDEAL);
								vistaPuntosGenEquipo.putExtra(
										ConstantesParametros.EQUIPOS_Y_PUNTOS,
										puntosYEquipos);
								startActivityForResult(
										vistaPuntosGenEquipo,
										Integer.valueOf(ConstantesParametros.CODE_VISTA_PUNTOS_GENERALES_EQUIPOS));
								haJugado = true;
								break;
							} else {
								haJugado = false;
							}
						}
						if (!haJugado) {
							// Si no hay puntos...
							// Pop-up error
							CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
							Toast toast = Toast.makeText(view.getContext(),
									text, duration);
							toast.show();
						}
					} else {
						// Si no hay puntos...
						// Pop-up error
						CharSequence text = ConstantesParametros.EQUIPO_NO_JUGADO;
						Toast toast = Toast.makeText(view.getContext(), text,
								duration);
						toast.show();
					}
				}
			}

		});

		/**
		 * Elementos y acciones de los elementos
		 */
		btnAyuda = (ImageView) findViewById(R.id.btnAyudaPG);
		btnInfo = (ImageView) findViewById(R.id.btnInfoPG);
		btnJornada = (ImageView) findViewById(R.id.btnJornadaPG);
		btnVolver = (ImageView) findViewById(R.id.btnVolverPG);
		btnRss = (ImageView) findViewById(R.id.btnRssPG);
		btnPosPunt = (ImageView) findViewById(R.id.btnPosPuntPG);

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
