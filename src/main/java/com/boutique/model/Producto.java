package com.boutique.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codPro;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
    private String imagen;
	@ColumnDefault("1")
	private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaProducto categoriaProducto;

    public Producto() {
    }

	public Producto(int codPro, String nombre, String descripcion, int stock, double precio, String imagen,
			CategoriaProducto categoriaProducto) {
		this.codPro = codPro;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	public boolean isEstado() { return estado; }

	public void setEstado(boolean estado) { this.estado = estado; }
}
