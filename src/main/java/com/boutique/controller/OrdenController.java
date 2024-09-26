package com.boutique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.model.Orden;
import com.boutique.model.Usuario;
import com.boutique.service.OrdenService;

@RestController
@RequestMapping("/orden")
@CrossOrigin("*")
public class OrdenController {

	@Autowired
	private OrdenService ordenService;

	@GetMapping
	public List<Orden> listarOrdenes() {
		return ordenService.listarOrden();
	}

	@GetMapping("/{id}")
	public Optional<Orden> obtenerOrden(@PathVariable int id) {
		return ordenService.buscarOrden(id);
	}

	@PostMapping
	public Orden agregarOrden(@RequestBody Orden orden) {
		return ordenService.agregarOrden(orden);
	}

	@PutMapping
	public Orden actualizarOrden(@RequestBody Orden orden) {
		return ordenService.actualizarOrden(orden);
	}

	@DeleteMapping("/{id}")
	public Boolean eliminarOrden(@PathVariable int id) {
		return ordenService.eliminarOrden(id);
	}

	@GetMapping("/usuario/{idUsuario}")
	public List<Orden> listarOrdenesPorUsuario(@PathVariable Usuario idUsuario) {
		return ordenService.listarOrdenesPorUsuario(idUsuario);
	}
}
