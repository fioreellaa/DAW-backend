package com.boutique.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codPro;
    private String nombre;
    private String descripcion;
    private String cantidad;
    private double precio;
    private String imagen;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaProducto categoriaProducto;

    public Producto() {
    }

	public Producto(int codPro, String nombre, String descripcion, String cantidad, double precio, String imagen,
			CategoriaProducto categoriaProducto) {
		this.codPro = codPro;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.imagen = imagen;
		this.categoriaProducto = categoriaProducto;
	}

	public int getCodPro() {
		return codPro;
	}

	public void setCodPro(int codPro) {
		this.codPro = codPro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

    
   
}
