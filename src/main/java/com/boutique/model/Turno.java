package com.boutique.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turno")
public class Turno {
	@Id
    @Column(name = "idTurno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurno;
	private String turno;
	private String horario;
}
