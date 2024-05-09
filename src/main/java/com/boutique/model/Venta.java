package com.boutique.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    private double montoTotal;

	public Venta() {
	}

	public Venta(int idVenta, Date fechaRegistro, double montoTotal) {
		super();
		this.idVenta = idVenta;
		this.fechaRegistro = fechaRegistro;
		this.montoTotal = montoTotal;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
}
