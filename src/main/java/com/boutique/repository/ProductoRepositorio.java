package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
