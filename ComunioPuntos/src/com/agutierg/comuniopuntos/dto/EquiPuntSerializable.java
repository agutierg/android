package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;
import java.util.List;

public class EquiPuntSerializable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EquiPuntDTO> listaEquPuntos;
	private String equSeleccionado;

	/**
	 * 
	 * @param listaEquPuntos
	 */
	public EquiPuntSerializable(List<EquiPuntDTO> listaEquPuntos) {
		super();
		this.listaEquPuntos = listaEquPuntos;
	}

	/**
	 * 
	 */
	public EquiPuntSerializable() {
		super();
	}

	/**
	 * 
	 * @return listaEquPuntos
	 */
	public List<EquiPuntDTO> getListaEquPuntos() {
		return listaEquPuntos;
	}

	/**
	 * 
	 * @param listaEquPuntos
	 */
	public void setListaEquPuntos(List<EquiPuntDTO> listaEquPuntos) {
		this.listaEquPuntos = listaEquPuntos;
	}

	/**
	 * 
	 * @return equSeleccionado
	 */
	public String getEquSeleccionado() {
		return equSeleccionado;
	}

	/**
	 * 
	 * @param equSeleccionado
	 */
	public void setEquSeleccionado(String equSeleccionado) {
		this.equSeleccionado = equSeleccionado;
	}

}
