package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.TipoServicio;

public interface ITipoServicioRepository extends JpaRepository<TipoServicio, Integer> {

}
