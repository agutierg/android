package com.agutierg.hits2013.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.agutierg.hits2013.dto.Cancion;

public class CancionFunctions {

	private JSONParser jsonParser;

	private static String urlObtenerCanciones = "http://www.gutsapps.com/temazos2013/recuperarcanciones.php";
	private static String urlVotarCanciones = "http://www.gutsapps.com/temazos2013/votarcancion.php";
	private static String urlEnviarPeticiones = "http://www.gutsapps.com/temazos2013/enviarpeticion.php";
	private static String urlEnviarLinks = "http://www.gutsapps.com/temazos2013/enviarlink.php";

	// constructor
	public CancionFunctions() {
		jsonParser = new JSONParser();
	}

	/**
	 * function make Login Request
	 * 
	 * @param email
	 * @param password
	 * */
	public List<Cancion> obtenerCanciones() {

		List<Cancion> listaCanciones = new ArrayList<Cancion>();

		JSONArray json = jsonParser.getJSONFromUrl(urlObtenerCanciones, null);
		if (json != null) {
			for (int i = 0; i < json.length(); i++) {
				JSONObject jo = null;
				try {
					jo = json.getJSONObject(i);
				} catch (JSONException e) {
					Log.e("Buffer Error",
							"Error converting result " + e.toString());
				}
				Cancion cancion = new Cancion();
				try {
					cancion.setIdCancion(jo.getInt("idCancion"));
					cancion.setCantante(jo.getString("cantante"));
					cancion.setDuracion(jo.getString("duracion"));
					cancion.setTitulo(jo.getString("titulo"));
					cancion.setTipo(jo.getString("tipo"));
					cancion.setUrlDescarga(jo.getString("urlDescarga"));
					cancion.setUrl(jo.getString("url"));
					cancion.setVotos(jo.getInt("votos"));
				} catch (JSONException e) {
					Log.e("Buffer Error",
							"Error converting result " + e.toString());
				}

				listaCanciones.add(cancion);
			}
		}
		return listaCanciones;
	}

	public void votarCancion(Integer idCancion) {

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idCancion", idCancion.toString()));
		jsonParser.enviarDatos(urlVotarCanciones, params);
	}

	public void enviarPeticion(String peticion) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("peticion", peticion));
		jsonParser.enviarDatos(urlEnviarPeticiones, params);
	}

	public void enviarLink(String peticion) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("peticion", peticion));
		jsonParser.enviarDatos(urlEnviarLinks, params);
	}
}
