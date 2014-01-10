package com.agutierg.quizvideojuegos.dto;

import java.io.Serializable;

public class Nivel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idNivel;
	private String nombreNivel;
	private boolean isDesbloqueado;
	private String porcCompletado;
	private String idDrawable;

	/**
	 * 
	 * @param idNivel
	 * @param nombreNivel
	 * @param isCompletado
	 * @param porcCompletado
	 * @param idDrawable
	 */
	public Nivel(Integer idNivel, String nombreNivel, boolean isCompletado,
			String porcCompletado, String idDrawable) {
		super();
		this.idNivel = idNivel;
		this.nombreNivel = nombreNivel;
		this.isDesbloqueado = isDesbloqueado;
		this.porcCompletado = porcCompletado;
		this.idDrawable = idDrawable;
	}

	/**
	 * 
	 */
	public Nivel() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public Integer getIdNivel() {
		return idNivel;
	}

	/**
	 * 
	 * @param idNivel
	 */
	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombreNivel() {
		return nombreNivel;
	}

	/**
	 * 
	 * @param nombreNivel
	 */
	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isDesbloqueado() {
		return isDesbloqueado;
	}

	/**
	 * 
	 * @param isCompletado
	 */
	public void setDesbloqueado(boolean isDesbloqueado) {
		this.isDesbloqueado = isDesbloqueado;
	}

	/**
	 * 
	 * @return
	 */
	public String getPorcCompletado() {
		return porcCompletado;
	}

	/**
	 * 
	 * @param porcCompletado
	 */
	public void setPorcCompletado(String porcCompletado) {
		this.porcCompletado = porcCompletado;
	}

	/**
	 * 
	 * @return
	 */
	public String getIdDrawable() {
		return idDrawable;
	}

	/**
	 * 
	 * @param idDrawable
	 */
	public void setIdDrawable(String idDrawable) {
		this.idDrawable = idDrawable;
	}

}
