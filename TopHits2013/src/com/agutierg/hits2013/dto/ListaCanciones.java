package com.agutierg.hits2013.dto;

import java.io.Serializable;
import java.util.List;

public class ListaCanciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cancion> listaCanciones;

	public ListaCanciones() {
		super();
	}

	public ListaCanciones(List<Cancion> listaCanciones) {
		super();
		this.listaCanciones = listaCanciones;
	}

	public List<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(List<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

}
