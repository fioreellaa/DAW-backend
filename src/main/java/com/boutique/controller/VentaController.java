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

import com.boutique.model.Venta;
import com.boutique.service.VentaService;

@RestController
@RequestMapping("/ventas")
@CrossOrigin("*") 
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVenta();
    }

    @GetMapping("/{id}")
    public Optional<Venta> obtenerVenta(@PathVariable int id) {
        return ventaService.buscarVenta(id);
    }

    @PostMapping
    public Venta agregarVenta(@RequestBody Venta venta) {
        return ventaService.agregarVenta(venta);
    }

    @PutMapping
    public Venta actualizarVenta(@RequestBody Venta venta) {
        return ventaService.actualizarVenta(venta);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarVenta(@PathVariable int id) {
        return ventaService.eliminarVenta(id);
    }

    @GetMapping("/usuario/{id}")
    public List<Venta> buscarPorUsuario(@PathVariable int id) { return ventaService.buscarVentaPorCliente(id); }
}
