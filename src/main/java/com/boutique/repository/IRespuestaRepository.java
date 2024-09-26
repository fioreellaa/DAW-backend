package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Respuesta;

@Repository
public interface IRespuestaRepository extends JpaRepository<Respuesta, Integer> {

}
