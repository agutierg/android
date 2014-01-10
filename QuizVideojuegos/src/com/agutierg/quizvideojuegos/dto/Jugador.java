package com.agutierg.quizvideojuegos.dto;

import java.io.Serializable;

public class Jugador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idJugador;
	private String nombreJugador;
	private Integer aciertos;
	private Integer puesto;

	/**
	 * 
	 * @param idJugador
	 * @param nombreJugador
	 * @param aciertos
	 */
	public Jugador(Integer idJugador, String nombreJugador, Integer aciertos) {
		super();
		this.idJugador = idJugador;
		this.nombreJugador = nombreJugador;
		this.aciertos = aciertos;
	}

	/**
	 * 
	 */
	public Jugador() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public Integer getIdJugador() {
		return idJugador;
	}

	/**
	 * 
	 * @param idJugador
	 */
	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	/**
	 * 
	 * @return
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
	 * @return
	 */
	public Integer getAciertos() {
		return aciertos;
	}

	/**
	 * 
	 * @param aciertos
	 */
	public void setAciertos(Integer aciertos) {
		this.aciertos = aciertos;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getPuesto() {
		return puesto;
	}

	/**
	 * 
	 * @param puesto
	 */
	public void setPuesto(Integer puesto) {
		this.puesto = puesto;
	}

}
