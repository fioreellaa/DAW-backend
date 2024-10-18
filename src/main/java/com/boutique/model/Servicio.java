package com.boutique.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Servicio {

	private int codServicio;
	private String nombreServicio;

	public Servicio() {
	}

	public int getCodServicio() {
		return codServicio;
	}

	public void setCodServicio(int codServicio) {
		this.codServicio = codServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

}
