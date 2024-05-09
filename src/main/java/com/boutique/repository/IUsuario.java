package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {
	Usuario findByCorreoUsuario(String correoUsuario);
}
