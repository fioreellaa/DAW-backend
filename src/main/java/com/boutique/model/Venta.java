package com.boutique.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	private double montoTotal;

	@OneToMany(mappedBy = "idDetalle", cascade = CascadeType.MERGE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<DetalleVenta> detalleVentas;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonIgnoreProperties({"nombreUsuario", "apellidoUsuario", "direccionUsuario", "telefonoUsuario", "correoUsuario", "contrasenaUsuario", "tipoUsuario", "estadoUsuario"})
	private Usuario usuario;

	public int getIdVenta() { return idVenta; }

	public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

	public Date getFechaRegistro() { return fechaRegistro; }

	public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

	public double getMontoTotal() { return montoTotal; }

	public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

	public List<DetalleVenta> getDetalleVentas() { return detalleVentas; }

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) { this.detalleVentas = detalleVentas; }

	public Usuario getUsuario() { return usuario; }

	public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
