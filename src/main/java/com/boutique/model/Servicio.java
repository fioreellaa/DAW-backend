package com.boutique.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @Column(name = "cod_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codServicio;
    private String nombre;
    private String numero;
    private String email;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario user;


    public Servicio() {
    }

    public Servicio(int codServicio, String nombre, String numero, String email, String descripcion) {
        this.codServicio = codServicio;
        this.nombre = nombre;
        this.numero = numero;
        this.email = email;
        this.descripcion = descripcion;
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }


}
