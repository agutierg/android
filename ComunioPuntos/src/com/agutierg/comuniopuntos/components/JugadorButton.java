package com.agutierg.comuniopuntos.components;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.agutierg.comuniopuntos.R;
import com.agutierg.comuniopuntos.constants.ConstantesParametros;
import com.agutierg.comuniopuntos.dto.FutJugDTO;
import com.agutierg.comuniopuntos.dto.JugPuntDTO;

public class JugadorButton {

	public Button devuelveBotonJugador(Context cont, Integer id,
			JugPuntDTO jugPuntDTO, String equipoSelec) {

		Button btnJugador = new Button(cont);

		// Id del BOTON
		btnJugador.setId(id);
		btnJugador.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		// Si está en el once ideal
		if (jugPuntDTO.isOnceIdeal()) {
			btnJugador.setCompoundDrawablesWithIntrinsicBounds(0,
					R.drawable.tshirt_onceid70, 0, 0);
		} else {
			// Recuperamos la camiseta del equipo
			int camiseta = devuelveCamisetaEquipo(equipoSelec);
			btnJugador.setCompoundDrawablesWithIntrinsicBounds(0, camiseta, 0,
					0);
		}

		// Texto del BOTON
		btnJugador.setText(jugPuntDTO.getNombreJugador() + ":\n"
				+ jugPuntDTO.getPuntosJugador().toString());
		btnJugador.setTextSize(11);
		btnJugador.setTextColor(cont.getResources().getColor(R.color.black));

		// Posicion del BOTON
		btnJugador.setGravity(Gravity.BOTTOM | Gravity.CENTER);

		btnJugador.setPadding(0, 0, 0, 0);

		// Lo hacemos transparente
		btnJugador.setBackgroundColor(0);

		// No lo hacemos clickable
		btnJugador.setClickable(false);

		return btnJugador;
	}

	private int devuelveCamisetaEquipo(String equipoSelec) {

		int camiseta = R.drawable.tshirt_icon_52;

		if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ATHLETIC)) {
			camiseta = R.drawable.camiseta_bilbao60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ATLETICO)) {
			camiseta = R.drawable.camiseta_atletico60;
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_BARCELONA)) {
			camiseta = R.drawable.camiseta_barcelona60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_BETIS)) {
			camiseta = R.drawable.camiseta_betis60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_CELTA)) {
			camiseta = R.drawable.camiseta_celta60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ALMERIA)) {
			camiseta = R.drawable.almeria_camiseta;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ESPANOL)) {
			camiseta = R.drawable.camiseta_espanyol60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_GETAFE)) {
			camiseta = R.drawable.camiseta_getafe60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_GRANADA)) {
			camiseta = R.drawable.camiseta_granada60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_LEVANTE)) {
			camiseta = R.drawable.camiseta_levante60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_MALAGA)) {
			camiseta = R.drawable.camiseta_malaga60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_ELCHE)) {
			camiseta = R.drawable.elche_camiseta;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_OSASUNA)) {
			camiseta = R.drawable.camiseta_osasuna60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_RAYO)) {
			camiseta = R.drawable.camiseta_rayo60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_RMADRID)) {
			camiseta = R.drawable.camiseta_rmadrid60;
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_RSOCIEDAD)) {
			camiseta = R.drawable.camiseta_rsociedad60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_SEVILLA)) {
			camiseta = R.drawable.camiseta_sevilla60;
		} else if (equipoSelec.equals(ConstantesParametros.EQUIPO_SEL_VALENCIA)) {
			camiseta = R.drawable.camiseta_valencia60;
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_VALLADOLID)) {
			camiseta = R.drawable.camiseta_valladolid60;
		} else if (equipoSelec
				.equals(ConstantesParametros.EQUIPO_SEL_VILLARREAL)) {
			camiseta = R.drawable.villarreal_camiseta;
		}

		return camiseta;
	}

	// El de MIS EQUIPOS
	public Button devuelveBotonJugador2(Context cont, Integer id,
			FutJugDTO jugPuntDTO) {

		Button btnJugador = new Button(cont);

		// Id del BOTON
		btnJugador.setId(id);
		btnJugador.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		// Si está en el once ideal
		if (jugPuntDTO.isOnceIdeal()) {
			btnJugador.setCompoundDrawablesWithIntrinsicBounds(0,
					R.drawable.tshirt_onceid70, 0, 0);
			btnJugador
					.setTextColor(cont.getResources().getColor(R.color.black));
		} // Si aún no ha jugado
		else if (jugPuntDTO.getPuntosJugador().equals(
				ConstantesParametros.NO_HA_JUGADO)) {
			// Recuperamos la camiseta del equipo
			int camiseta = devuelveCamisetaEquipo(jugPuntDTO.getEquipo());
			btnJugador.setCompoundDrawablesWithIntrinsicBounds(0, camiseta, 0,
					0);
			btnJugador.setTextColor(cont.getResources().getColor(R.color.red));
		} else {
			// Recuperamos la camiseta del equipo
			int camiseta = devuelveCamisetaEquipo(jugPuntDTO.getEquipo());
			btnJugador.setCompoundDrawablesWithIntrinsicBounds(0, camiseta, 0,
					0);
			btnJugador
					.setTextColor(cont.getResources().getColor(R.color.black));
		}

		// Texto del BOTON
		if (jugPuntDTO.getPuntosJugador().equals(
				ConstantesParametros.NO_HA_JUGADO)) {
			btnJugador.setText(jugPuntDTO.getNombreJugador() + ":\n"
					+ ConstantesParametros.NO_JUGADO);
		} else {
			btnJugador.setText(jugPuntDTO.getNombreJugador() + ":\n"
					+ jugPuntDTO.getPuntosJugador().toString());
		}
		btnJugador.setTextSize(11);

		// Posicion del BOTON
		btnJugador.setGravity(Gravity.BOTTOM | Gravity.CENTER);

		btnJugador.setPadding(0, 0, 0, 0);

		// Lo hacemos transparente
		btnJugador.setBackgroundColor(0);

		// No lo hacemos clickable
		btnJugador.setClickable(false);

		return btnJugador;
	}

	public Button devuelveBotonJugadorEJ(Context cont, Integer id,
			String equipo, String jugador) {

		Button btnJugador = new Button(cont);

		// Id del BOTON
		btnJugador.setId(id);
		btnJugador.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		// Recuperamos la camiseta del equipo
		int camiseta = devuelveCamisetaEquipo(equipo);
		btnJugador.setCompoundDrawablesWithIntrinsicBounds(0, camiseta, 0, 0);

		// Texto del BOTON
		btnJugador.setText(equipo + ":\n" + jugador);
		btnJugador.setTextSize(11);
		btnJugador.setTextColor(cont.getResources().getColor(R.color.black));

		// Posicion del BOTON
		btnJugador.setGravity(Gravity.BOTTOM | Gravity.CENTER);

		btnJugador.setPadding(0, 0, 0, 0);

		// Lo hacemos transparente
		btnJugador.setBackgroundColor(0);

		// No lo hacemos clickable
		btnJugador.setClickable(false);

		return btnJugador;
	}
}
