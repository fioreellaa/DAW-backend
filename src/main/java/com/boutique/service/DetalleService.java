package com.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.DetalleVenta;
import com.boutique.repository.IDetalleVentaRepository;

@Service
public class DetalleService {
	
	private final IDetalleVentaRepository detalleRepository;
	
	@Autowired
	public DetalleService(IDetalleVentaRepository detalleRepository) {
		this.detalleRepository = detalleRepository;
	}
	
	public List<DetalleVenta> registrarDetalle(List<DetalleVenta> detalle) {
    	return detalleRepository.saveAll(detalle);
    }
}
