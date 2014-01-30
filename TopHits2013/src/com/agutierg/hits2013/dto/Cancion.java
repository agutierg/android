package com.agutierg.hits2013.dto;

import java.io.Serializable;
import java.util.Date;

public class Cancion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idCancion;
	private String cantante;
	private String titulo;
	private String duracion;
	private String url;
	private String urlDescarga;
	private String tipo;
	private Integer votos;
	private Date insertDate;

	/**
	 * 
	 * @param idCancion
	 * @param cantante
	 * @param titulo
	 * @param duracion
	 * @param url
	 */
	public Cancion(Integer idCancion, String cantante, String titulo,
			String duracion, String url, String urlDescarga, String tipo,
			Integer votos, Date insertDate) {
		super();
		this.idCancion = idCancion;
		this.cantante = cantante;
		this.titulo = titulo;
		this.duracion = duracion;
		this.url = url;
		this.urlDescarga = urlDescarga;
		this.tipo = tipo;
		this.votos = votos;
		this.insertDate = insertDate;
	}

	/**
	 * 
	 */
	public Cancion() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public Integer getIdCancion() {
		return idCancion;
	}

	/**
	 * 
	 * @param idCancion
	 */
	public void setIdCancion(Integer idCancion) {
		this.idCancion = idCancion;
	}

	/**
	 * 
	 * @return
	 */
	public String getCantante() {
		return cantante;
	}

	/**
	 * 
	 * @param cantante
	 */
	public void setCantante(String cantante) {
		this.cantante = cantante;
	}

	/**
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * 
	 * @return
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * 
	 * @param duracion
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
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
	public String getUrlDescarga() {
		return urlDescarga;
	}

	/**
	 * 
	 * @param urlDescarga
	 */
	public void setUrlDescarga(String urlDescarga) {
		this.urlDescarga = urlDescarga;
	}

	/**
	 * 
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getVotos() {
		return votos;
	}

	/**
	 * 
	 * @param votos
	 */
	public void setVotos(Integer votos) {
		this.votos = votos;
	}

	/**
	 * 
	 * @return
	 */
	public Date getInsertDate() {
		return insertDate;
	}

	/**
	 * 
	 * @param insertDate
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}
