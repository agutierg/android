package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;
import java.util.List;

public class EquiPuntDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreEquipo;
	private List<JugPuntDTO> listaJugPuntos;
	private Integer puntEquipo;
	private Integer jornada;

	/**
	 * 
	 * @param nombreEquipo
	 * @param listaJugPuntos
	 * @param puntEquipo
	 */
	public EquiPuntDTO(String nombreEquipo, List<JugPuntDTO> listaJugPuntos,
			Integer puntEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.listaJugPuntos = listaJugPuntos;
		this.puntEquipo = puntEquipo;
	}

	/**
	 * 
	 */
	public EquiPuntDTO() {
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
	public List<JugPuntDTO> getListaJugPuntos() {
		return listaJugPuntos;
	}

	/**
	 * 
	 * @param listaJugPuntos
	 */
	public void setListaJugPuntos(List<JugPuntDTO> listaJugPuntos) {
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
