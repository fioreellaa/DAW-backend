package com.boutique.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cita")
public class Cita {
	@Id
    @Column(name = "codCita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codCita;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCita;
	
	private String estado;
	private String nombrePersona;
	private String numeroTel;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "idServicio")
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name = "idSede")
	private Sede sede;
	
	@ManyToOne
	@JoinColumn(name = "idTurno")
	private Turno turno;
	


	public int getCodCita() {
		return codCita;
	}

	public void setCodCita(int codCita) {
		this.codCita = codCita;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	
	
	
}
