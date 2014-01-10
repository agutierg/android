package com.agutierg.comuniopuntos.dto;

import java.io.Serializable;

public class InfoJugDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String desc1;
	private String desc2;

	/**
	 * 
	 * @param nombre
	 * @param desc1
	 * @param desc2
	 */
	public InfoJugDTO(String nombre, String desc1, String desc2) {
		super();
		this.nombre = nombre;
		this.desc1 = desc1;
		this.desc2 = desc2;
	}

	/**
	 * 
	 */
	public InfoJugDTO() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getDesc1() {
		return desc1;
	}

	/**
	 * 
	 * @param desc1
	 */
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	/**
	 * 
	 * @return
	 */
	public String getDesc2() {
		return desc2;
	}

	/**
	 * 
	 * @param desc2
	 */
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

}
