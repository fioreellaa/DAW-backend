package com.boutique.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @Column(name = "cod_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
