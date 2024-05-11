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
    private String nombrePersona;
	private String numero;
	private String email;
	private String descripcion;
	    
	@Temporal(TemporalType.DATE)
	private Date fecha_cita;
	private String hora_cita;
	private int lugar;
	private String direccion;
	private String referencia;
  

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


	public String getNombrePersona() {
		return nombrePersona;
	}


	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFecha_cita() {
		return fecha_cita;
	}


	public void setFecha_cita(Date fecha_cita) {
		this.fecha_cita = fecha_cita;
	}


	public String getHora_cita() {
		return hora_cita;
	}


	public void setHora_cita(String hora_cita) {
		this.hora_cita = hora_cita;
	}


	public int getLugar() {
		return lugar;
	}


	public void setLugar(int lugar) {
		this.lugar = lugar;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
    
    

}
