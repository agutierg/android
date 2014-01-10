package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;

public class JugPuntDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreJugador;
	private String puntosJugador;
	private boolean isOnceIdeal;

	/**
	 * 
	 * @param nombreJugador
	 * @param puntosJugador
	 */
	public JugPuntDTO(String nombreJugador, String puntosJugador,
			boolean isOnceIdeal) {
		super();
		this.nombreJugador = nombreJugador;
		this.puntosJugador = puntosJugador;
		this.isOnceIdeal = isOnceIdeal;
	}

	/**
	 * 
	 */
	public JugPuntDTO() {
		super();
	}

	/**
	 * 
	 * @return nombreJugador
	 */
	public String getNombreJugador() {
		return nombreJugador;
	}

	/**
	 * 
	 * @param nombreJugador
	 */
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	/**
	 * 
	 * @return puntosJugador
	 */
	public String getPuntosJugador() {
		return puntosJugador;
	}

	/**
	 * 
	 * @param puntosJugador
	 */
	public void setPuntosJugador(String puntosJugador) {
		this.puntosJugador = puntosJugador;
	}

	/**
	 * 
	 * @return isOnceIdeal
	 */
	public boolean isOnceIdeal() {
		return isOnceIdeal;
	}

	/**
	 * 
	 * @param isOnceIdeal
	 */
	public void setOnceIdeal(boolean isOnceIdeal) {
		this.isOnceIdeal = isOnceIdeal;
	}

}
