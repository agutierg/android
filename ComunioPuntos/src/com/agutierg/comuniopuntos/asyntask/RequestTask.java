package com.agutierg.comuniopuntos.asyntask;

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

import android.os.AsyncTask;

import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.dto.EquiPuntDTO;
import com.agutierg.comuniopuntos.dto.JugPuntDTO;

public class RequestTask extends AsyncTask<String, Integer, String> {

	private int progress;

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
		HttpGet httpget = new HttpGet(ConstantesParametros.DIRECCION_WEB);
		try {
			response = httpclient.execute(httpget);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Executeit
		HttpEntity entity = response.getEntity();
		try {
			is = entity.getContent();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create an
		// InputStream with
		// the response
		try {
			reader = new BufferedReader(new InputStreamReader(is, "UTF8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		try {
			while ((line = reader.readLine()) != null)
				// Read line by line
				sb.append(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resString = sb.toString();
		//
		// Result is here
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resString;

	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);

		// La cadena a analizar
		String cadena = result;
		// Extraemos los puntos
		List<EquiPuntDTO> listaEquiposCP = extraerPuntos(cadena);
		// Persistimos en Base de Datos
	}

	@Override
	protected void onPreExecute() {

		progress = 0;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {

	}

	private List<EquiPuntDTO> extraerPuntos(String cadena) {
		// Variables
		List<EquiPuntDTO> listaEquipos = new ArrayList<EquiPuntDTO>();

		// Primero dividimos el texto que queremos tratar. Por equipos
		String[] textoCortado = cadena
				.split(ConstantesParametros.CADENA_PARTIR_TEXTO_INICIAL);

		Pattern patronEquipo = Pattern
				.compile(ConstantesParametros.COMIENZO_Y_FIN_EQUIPOS);
		Pattern patronJugadorNombre = Pattern
				.compile(ConstantesParametros.COMIENZO_JUGADOR);
		Pattern patronJugadorPuntos = Pattern
				.compile(ConstantesParametros.COMIENZO_PUNTOS);

		// Recorremos cada uno de los textos (por equipo). El primero no lo
		// queremos
		for (int i = 1; i < textoCortado.length; i++) {
			// Variables
			EquiPuntDTO equipo = new EquiPuntDTO();
			List<JugPuntDTO> listaJugPunt = new ArrayList<JugPuntDTO>();

			String cadenaCortada = textoCortado[i];
			// Buscamos el equipo
			Matcher matcherEquipo = patronEquipo.matcher(cadenaCortada);
			if (matcherEquipo.find()) {
				String nombreEquipo = matcherEquipo.group(1);
				// Seteamos el nombre del equipo
				equipo.setNombreEquipo(nombreEquipo);
			}

			// Variables
			String puntosJugador = null;
			String jugador = null;

			// Ahora buscamos cada uno de los jugadores de ese equipo
			Matcher matcherJugadores = patronJugadorNombre
					.matcher(cadenaCortada);
			while (matcherJugadores.find()) {
				// Variables
				JugPuntDTO jugPunt = new JugPuntDTO();

				String textoJ = matcherJugadores.group(1);
				// Partimos el String por "</a>"
				String[] jugadorSolo = textoJ
						.split(ConstantesParametros.FIN_JUGADOR);
				// Nos quedamos con el primero que es el nombre del jugador
				jugador = jugadorSolo[0];
				// Si tiene <br> se lo quitamos
				jugador = jugador.replace(
						ConstantesParametros.SEPARADOR_APELLIDOS, " ");
				// Lo borramos de la busqueda
				textoJ.replaceFirst(jugadorSolo[0], "");

				// Ahora los puntos de ese jugador
				Matcher matcherPuntos = patronJugadorPuntos.matcher(textoJ);
				if (matcherPuntos.find()) {
					String textoP = matcherPuntos.group(1);
					// Partimos el String por "</td>"
					String[] puntosSolos = textoP
							.split(ConstantesParametros.FIN_PUNTOS);
					// Nos quedamos con el primero que son los puntos de ese
					// jugador
					puntosJugador = puntosSolos[0];
				}

				// Volvemos a aplicar la regla para buscar el siguiente jugador
				// del equipo
				matcherJugadores = patronJugadorNombre.matcher(textoJ);

				// Seteamos los valores obtenidos
				jugPunt.setNombreJugador(jugador);
				jugPunt.setPuntosJugador(puntosJugador);

				// Y añadimos el jugador con su puntuacion a la lista de ese
				// equipo
				listaJugPunt.add(jugPunt);
			}

			// Ahora que ya tenemos todos los jugadores con sus puntuaciones,
			// los añadimos al equipo
			equipo.setListaJugPuntos(listaJugPunt);
			// Calculamos los puntos
			int pntEqui = calculaPuntos(listaJugPunt);
			equipo.setPuntEquipo(pntEqui);
			// Añadimos el equipo a la lista
			listaEquipos.add(equipo);
		}

		return listaEquipos;
	}

	private int calculaPuntos(List<JugPuntDTO> listaJugPunt) {

		int puntosEquipo = 0;
		if (listaJugPunt != null && listaJugPunt.size() > 0) {
			for (JugPuntDTO jugPuntDTO : listaJugPunt) {
				if (jugPuntDTO.getPuntosJugador() != null) {
					puntosEquipo = puntosEquipo
							+ Integer.valueOf(jugPuntDTO.getPuntosJugador());
				}
			}
		}
		return puntosEquipo;
	}
}
