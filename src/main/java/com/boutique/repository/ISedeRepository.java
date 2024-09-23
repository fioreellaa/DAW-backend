package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Sede;

@Repository
public interface ISedeRepository extends JpaRepository<Sede, Integer>{

}
