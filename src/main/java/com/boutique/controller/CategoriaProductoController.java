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

import com.boutique.model.CategoriaProducto;
import com.boutique.service.CategoriaProductoService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaProductoController {

	@Autowired
	private CategoriaProductoService categoriaProductoService;

	@GetMapping
	public List<CategoriaProducto> listarCategorias() {
		return categoriaProductoService.listarCategoria();
	}

	@GetMapping("/{id}")
	public Optional<CategoriaProducto> obtenerCategoria(@PathVariable int id) {
		return categoriaProductoService.buscarCategoria(id);
	}

	@PostMapping
	public CategoriaProducto agregarCategoria(@RequestBody CategoriaProducto categoria) {
		return categoriaProductoService.agregarCategoria(categoria);
	}

	@PutMapping
	public CategoriaProducto actualizarCategoria(@RequestBody CategoriaProducto categoria) {
		return categoriaProductoService.actualizarCategoria(categoria);
	}

	@DeleteMapping("/{id}")
	public Boolean eliminarCategoria(@PathVariable int id) {
		return categoriaProductoService.eliminarCategoria(id);
	}
}
