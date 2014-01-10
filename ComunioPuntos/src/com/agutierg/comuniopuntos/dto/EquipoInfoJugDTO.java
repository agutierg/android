package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;
import java.util.List;

public class EquipoInfoJugDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombreEquipo;
	private List<InfoJugDTO> listaJugLesionados;
	private List<InfoJugDTO> listaJugDuda;
	private List<InfoJugDTO> listaJugAcumulacion;
	private List<InfoJugDTO> listaJugDosAmarillas;
	private List<InfoJugDTO> listaJugRoja;
	private List<InfoJugDTO> listaJugNoConvocado;
	private List<InfoJugDTO> listaJugFilial;

	/**
	 * 
	 * @param nombreEquipo
	 */
	public EquipoInfoJugDTO(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * 
	 */
	public EquipoInfoJugDTO() {
		super();
	}

	/**
	 * 
	 * @return
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
	 * @return
	 */
	public List<InfoJugDTO> getListaJugLesionados() {
		return listaJugLesionados;
	}

	/**
	 * 
	 * @param listaJugLesionados
	 */
	public void setListaJugLesionados(List<InfoJugDTO> listaJugLesionados) {
		this.listaJugLesionados = listaJugLesionados;
	}

	/**
	 * 
	 * @return
	 */
	public List<InfoJugDTO> getListaJugDuda() {
		return listaJugDuda;
	}

	/**
	 * 
	 * @param listaJugDuda
	 */
	public void setListaJugDuda(List<InfoJugDTO> listaJugDuda) {
		this.listaJugDuda = listaJugDuda;
	}

	/**
	 * 
	 * @return
	 */
	public List<InfoJugDTO> getListaJugAcumulacion() {
		return listaJugAcumulacion;
	}

	/**
	 * 
	 * @param listaJugAcumulacion
	 */
	public void setListaJugAcumulacion(List<InfoJugDTO> listaJugAcumulacion) {
		this.listaJugAcumulacion = listaJugAcumulacion;
	}

	/**
	 * 
	 * @return
	 */
	public List<InfoJugDTO> getListaJugDosAmarillas() {
		return listaJugDosAmarillas;
	}

	/**
	 * 
	 * @param listaJugDosAmarillas
	 */
	public void setListaJugDosAmarillas(List<InfoJugDTO> listaJugDosAmarillas) {
		this.listaJugDosAmarillas = listaJugDosAmarillas;
	}

	/**
	 * 
	 * @return
	 */
	public List<InfoJugDTO> getListaJugRoja() {
		return listaJugRoja;
	}

	/**
	 * 
	 * @param listaJugRoja
	 */
	public void setListaJugRoja(List<InfoJugDTO> listaJugRoja) {
		this.listaJugRoja = listaJugRoja;
	}

	/**
	 * 
	 * @return
	 */
	public List<InfoJugDTO> getListaJugNoConvocado() {
		return listaJugNoConvocado;
	}

	/**
	 * 
	 * @param listaJugNoConvocado
	 */
	public void setListaJugNoConvocado(List<InfoJugDTO> listaJugNoConvocado) {
		this.listaJugNoConvocado = listaJugNoConvocado;
	}

	/**
	 * 
	 * @return
	 */
	public List<InfoJugDTO> getListaJugFilial() {
		return listaJugFilial;
	}

	/**
	 * 
	 * @param listaJugFilial
	 */
	public void setListaJugFilial(List<InfoJugDTO> listaJugFilial) {
		this.listaJugFilial = listaJugFilial;
	}

}
