package com.boutique.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarjeta")
public class Tarjeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTarjeta;
	private String numeroTarjeta;
	private String nombreTitular;
	private Date fechaExpiracion;
	private String codigoSeguridad;

	@ManyToOne

	@JoinColumn(name = "id_tipotarjeta")
	private TipoTarjeta tipoTarjeta;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Tarjeta() {
		
	}
	
	public Tarjeta(int idTarjeta, String numeroTarjeta, String nombreTitular, Date fechaExpiracion,
			String codigoSeguridad, TipoTarjeta tipoTarjeta, Usuario usuario) {
		this.idTarjeta = idTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.nombreTitular = nombreTitular;
		this.fechaExpiracion = fechaExpiracion;
		this.codigoSeguridad = codigoSeguridad;
		this.tipoTarjeta = tipoTarjeta;
		this.usuario = usuario;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
