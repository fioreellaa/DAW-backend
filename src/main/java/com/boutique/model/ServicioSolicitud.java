package com.boutique.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class ServicioSolicitud {
	@Id
	private int cod_solicitud;
	private int cod_servicio;
	private String nombrePersona;
	private String numero;
	private String email;
	private String descripcion;
	    
	@Temporal(TemporalType.DATE)
	private Date fecha_cita;
	   
	@Temporal(TemporalType.TIME)
    private Date hora_cita;
	private int lugar;
	private String direccion;
	private String referencia;
	   
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario user;
}
