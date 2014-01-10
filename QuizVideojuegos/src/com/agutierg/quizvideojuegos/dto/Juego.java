package com.agutierg.quizvideojuegos.dto;

import java.io.Serializable;

public class Juego implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idJuego;
	private Integer idNivelJuego;
	private String nombreJuego;
	private String pistaJuego;
	private boolean isRespondido;
	private String idDrawable;

	/**
	 * 
	 * @param idJuego
	 * @param idNivelJuego
	 * @param nombreJuego
	 * @param pistaJuego
	 * @param isRespondido
	 * @param idDrawable
	 */
	public Juego(Integer idJuego, Integer idNivelJuego, String nombreJuego,
			String pistaJuego, boolean isRespondido, String idDrawable) {
		super();
		this.idJuego = idJuego;
		this.idNivelJuego = idNivelJuego;
		this.nombreJuego = nombreJuego;
		this.pistaJuego = pistaJuego;
		this.isRespondido = isRespondido;
		this.idDrawable = idDrawable;
	}

	/**
	 * 
	 */
	public Juego() {
		super();
	}

	/**
	 * 
	 */
	public Integer getIdJuego() {
		return idJuego;
	}

	/**
	 * 
	 */
	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	/**
	 * 
	 */
	public Integer getIdNivelJuego() {
		return idNivelJuego;
	}

	/**
	 * 
	 */
	public void setIdNivelJuego(Integer idNivelJuego) {
		this.idNivelJuego = idNivelJuego;
	}

	/**
	 * 
	 */
	public String getNombreJuego() {
		return nombreJuego;
	}

	/**
	 * 
	 */
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	/**
	 * 
	 */
	public String getPistaJuego() {
		return pistaJuego;
	}

	/**
	 * 
	 */
	public void setPistaJuego(String pistaJuego) {
		this.pistaJuego = pistaJuego;
	}

	/**
	 * 
	 */
	public boolean isRespondido() {
		return isRespondido;
	}

	/**
	 * 
	 */
	public void setRespondido(boolean isRespondido) {
		this.isRespondido = isRespondido;
	}

	/**
	 * 
	 */
	public String getIdDrawable() {
		return idDrawable;
	}

	/**
	 * 
	 */
	public void setIdDrawable(String idDrawable) {
		this.idDrawable = idDrawable;
	}

}
