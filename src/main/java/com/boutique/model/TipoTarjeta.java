package com.boutique.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "tipotarjeta")
public class TipoTarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipotarjeta") 
    private int idTipoTarjeta;

    @Column(name = "nombre_tipo") 
    private String nombreTipo;

    public TipoTarjeta() {
    	
    }

	public TipoTarjeta(int idTipoTarjeta, String nombreTipo) {
		this.idTipoTarjeta = idTipoTarjeta;
		this.nombreTipo = nombreTipo;
	}

	public int getIdTipoTarjeta() {
		return idTipoTarjeta;
	}

	public void setIdTipoTarjeta(int idTipoTarjeta) {
		this.idTipoTarjeta = idTipoTarjeta;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	

   
}

