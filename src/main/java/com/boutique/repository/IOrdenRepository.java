package com.boutique.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Orden;
import com.boutique.model.Usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {
    List<Orden> findByidUsuario(Usuario idUsuario);
}
