package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boutique.model.CategoriaProducto;

public interface ICategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer>{

}
