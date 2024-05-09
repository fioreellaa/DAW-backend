package com.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {
}
