package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.Tarjeta;

public interface ITarjetaRepository  extends JpaRepository<Tarjeta, Integer> {

}
