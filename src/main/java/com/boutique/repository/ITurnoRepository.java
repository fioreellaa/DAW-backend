package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Turno;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer>{

}
