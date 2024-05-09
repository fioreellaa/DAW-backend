package com.boutique.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "codPro")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "codOrden")
    private Orden orden;
    
    private int cantidad;
    private double subtotal;
    
    
	public DetalleVenta() {
	}

	public DetalleVenta(int idDetalle, Producto producto, Venta venta, Orden orden, int cantidad, double subtotal) {
		super();
		this.idDetalle = idDetalle;
		this.producto = producto;
		this.venta = venta;
		this.orden = orden;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
	
    

