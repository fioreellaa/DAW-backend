package com.boutique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boutique.model.Producto;
import com.boutique.service.ProductoService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProducto();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable int id) {
        return productoService.buscarProducto(id);
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @PutMapping
    public Producto actualizarProducto(@RequestBody Producto producto) {
        return productoService.actualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarProducto(@PathVariable int id) {
        return productoService.deleteProducto(id);
    }
}