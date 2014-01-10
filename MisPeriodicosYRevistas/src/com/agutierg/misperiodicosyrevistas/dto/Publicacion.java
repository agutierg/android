package com.agutierg.misperiodicosyrevistas.dto;

import java.io.Serializable;

public class Publicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idPublicacion;
	private String descripcion;
	private String url;
	private String tipoPublicacion;
	private boolean isFavorito;

	/**
	 * 
	 * @param idPublicacion
	 * @param descripcion
	 * @param url
	 * @param tipoPublicacion
	 * @param isFavorito
	 */
	public Publicacion(Integer idPublicacion, String descripcion, String url,
			String tipoPublicacion, boolean isFavorito) {
		super();
		this.idPublicacion = idPublicacion;
		this.descripcion = descripcion;
		this.url = url;
		this.tipoPublicacion = tipoPublicacion;
		this.isFavorito = isFavorito;
	}

	/**
	 * 
	 */
	public Publicacion() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public Integer getIdPublicacion() {
		return idPublicacion;
	}

	/**
	 * 
	 * @param idPublicacion
	 */
	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return
	 */
	public String getTipoPublicacion() {
		return tipoPublicacion;
	}

	/**
	 * 
	 * @param tipoPublicacion
	 */
	public void setTipoPublicacion(String tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isFavorito() {
		return isFavorito;
	}

	/**
	 * 
	 * @param isFavorito
	 */
	public void setFavorito(boolean isFavorito) {
		this.isFavorito = isFavorito;
	}

}
