package com.agutierg.quizvideojuegos.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.agutierg.quizvideojuegos.dto.Jugador;

public class JugadoresFunctions {

	private JSONParser jsonParser;

	private static String urlEnviarNombre = "http://temazos.pusku.com/enviarnombre.php";
	private static String urlConsulta = "http://temazos.pusku.com/consulta.php";
	private static String urlActualizarJug = "http://temazos.pusku.com/actualizar.php";
	private static String urlRecuperarJug = "http://temazos.pusku.com/recuperarjugadores.php";

	public JugadoresFunctions() {
		jsonParser = new JSONParser();
	}

	public boolean enviarNombre(String nombre) {

		boolean hayError = false;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("nombre", nombre));
		String json = jsonParser.enviarDatos(urlConsulta, params);

		if (json != null) {
			String error = "nulln";

			// Si devuelve null es que no está el nombre
			if (!json.equals(error)) {
				hayError = true;
			} else {
				hayError = false;
				List<NameValuePair> params2 = new ArrayList<NameValuePair>();
				params2.add(new BasicNameValuePair("nombre", nombre));
				jsonParser.enviarDatos(urlEnviarNombre, params2);
			}
		}

		return hayError;
	}

	public boolean actualizarJugador(Jugador jugBaseDatos) {

		boolean hayError = false;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("nombre", jugBaseDatos
				.getNombreJugador()));
		params.add(new BasicNameValuePair("score", jugBaseDatos.getAciertos()
				.toString()));
		String json = jsonParser.enviarDatos(urlActualizarJug, params);

		if (json != null) {
			String error = "errorn";
			// Si devuelve null es que no está el nombre
			if (json.equals(error)) {
				hayError = true;
			} else {
				hayError = false;
			}
		}

		return hayError;

	}

	public List<Jugador> recuperarJugadores() {
		List<Jugador> listaJugadores = new ArrayList<Jugador>();

		JSONArray json = jsonParser.getJSONFromUrl(urlRecuperarJug, null);
		if (json != null) {
			for (int i = 0; i < json.length(); i++) {
				JSONObject jo = null;
				try {
					jo = json.getJSONObject(i);
				} catch (JSONException e) {
					Log.e("Buffer Error",
							"Error converting result " + e.toString());
				}
				Jugador jugador = new Jugador();
				try {
					jugador.setIdJugador(jo.getInt("idJugador"));
					jugador.setNombreJugador(jo.getString("nombreJugador"));
					jugador.setAciertos(jo.getInt("aciertos"));
					jugador.setPuesto(i + 1);
				} catch (JSONException e) {
					Log.e("Buffer Error",
							"Error converting result " + e.toString());
				}
				listaJugadores.add(jugador);
			}
		}
		return listaJugadores;
	}
}
