package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;
import java.util.List;

public class EquiPuntSerializableJug implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EquiPuntJugDTO> listaEquPuntos;

	/**
	 * 
	 * @param listaEquPuntos
	 */
	public EquiPuntSerializableJug(List<EquiPuntJugDTO> listaEquPuntos) {
		super();
		this.listaEquPuntos = listaEquPuntos;
	}

	/**
	 * 
	 */
	public EquiPuntSerializableJug() {
		super();
	}

	/**
	 * 
	 * @return listaEquPuntos
	 */
	public List<EquiPuntJugDTO> getListaEquPuntos() {
		return listaEquPuntos;
	}

	/**
	 * 
	 * @param listaEquPuntos
	 */
	public void setListaEquPuntos(List<EquiPuntJugDTO> listaEquPuntos) {
		this.listaEquPuntos = listaEquPuntos;
	}

}
