package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;

public class FutJugDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreJugador;
	private String puntosJugador;
	private boolean isOnceIdeal;
	private String posicion;
	private String equipo;

	/**
	 * 
	 * @param nombreJugador
	 * @param puntosJugador
	 */
	public FutJugDTO(String nombreJugador, String puntosJugador,
			boolean isOnceIdeal, String posicion, String equJugador,
			String equipo) {
		super();
		this.nombreJugador = nombreJugador;
		this.puntosJugador = puntosJugador;
		this.isOnceIdeal = isOnceIdeal;
		this.posicion = posicion;
		this.equipo = equipo;
	}

	/**
	 * 
	 */
	public FutJugDTO() {
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

	/**
	 * 
	 * @return
	 */
	public String getPosicion() {
		return posicion;
	}

	/**
	 * 
	 * @param posicion
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	/**
	 * 
	 * @return
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * 
	 * @param equipo
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

}
