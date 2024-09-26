package com.boutique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boutique.model.DetalleVenta;
import com.boutique.service.DetalleService;

@RestController
@RequestMapping("/detalle")
@CrossOrigin("*")
public class DetalleController {

	@Autowired
	private DetalleService detalleService;

	@GetMapping
	public List<DetalleVenta> listarDetalles() {
		return detalleService.listarDetalle();
	}

	@GetMapping("/{id}")
	public Optional<DetalleVenta> obtenerDetalle(@PathVariable int id) {
		return detalleService.buscarDetalle(id);
	}

	@PostMapping
	public DetalleVenta agregarDetalle(@RequestBody DetalleVenta detalle) {
		return detalleService.agregarDetalle(detalle);
	}

	@PutMapping
	public DetalleVenta actualizarDetalle(@RequestBody DetalleVenta detalle) {
		return detalleService.actualizarDetalle(detalle);
	}

	@DeleteMapping("/{id}")
	public Boolean eliminarDetalle(@PathVariable int id) {
		return detalleService.eliminarDetalle(id);
	}
}
