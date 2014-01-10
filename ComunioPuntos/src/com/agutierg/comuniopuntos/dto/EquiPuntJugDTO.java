package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;
import java.util.List;

public class EquiPuntJugDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreEquipo;
	private List<FutJugDTO> listaJugPuntos;
	private Integer puntEquipo;
	private Integer jornada;

	/**
	 * 
	 * @param nombreEquipo
	 * @param listaJugPuntos
	 * @param puntEquipo
	 */
	public EquiPuntJugDTO(String nombreEquipo, List<FutJugDTO> listaJugPuntos,
			Integer puntEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.listaJugPuntos = listaJugPuntos;
		this.puntEquipo = puntEquipo;
	}

	/**
	 * 
	 */
	public EquiPuntJugDTO() {
		super();
	}

	/**
	 * 
	 * @return nombreEquipo
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	/**
	 * 
	 * @param nombreEquipo
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * 
	 * @return listaJugPuntos
	 */
	public List<FutJugDTO> getListaJugPuntos() {
		return listaJugPuntos;
	}

	/**
	 * 
	 * @param listaJugPuntos
	 */
	public void setListaJugPuntos(List<FutJugDTO> listaJugPuntos) {
		this.listaJugPuntos = listaJugPuntos;
	}

	/**
	 * 
	 * @return puntEquipo
	 */
	public Integer getPuntEquipo() {
		return puntEquipo;
	}

	/**
	 * 
	 * @param puntEquipo
	 */
	public void setPuntEquipo(Integer puntEquipo) {
		this.puntEquipo = puntEquipo;
	}

	/**
	 * 
	 * @return jornada
	 */
	public Integer getJornada() {
		return jornada;
	}

	/**
	 * 
	 * @param jornada
	 */
	public void setJornada(Integer jornada) {
		this.jornada = jornada;
	}

}
