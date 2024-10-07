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

import com.boutique.model.Tarjeta;
import com.boutique.model.TipoTarjeta;
import com.boutique.service.TarjetaService;
import com.boutique.service.TipoTarjetaService;

@RestController
@RequestMapping("/tarjetas")
@CrossOrigin("*") 
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;
    
    @Autowired
    private TipoTarjetaService tipoTarjetaService;

    @GetMapping
    public List<Tarjeta> listarTarjetas() { return tarjetaService.listarTarjeta(); }

    @GetMapping("/tipos")
    public List<TipoTarjeta> listarTiposTarjeta() { return tipoTarjetaService.listarTipoTarjeta(); }

    @GetMapping("/{id}")
    public Optional<Tarjeta> obtenerTarjeta(@PathVariable int id) {
        return tarjetaService.buscarTarjeta(id);
    }

    @PostMapping
    public Tarjeta agregarTarjeta(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.agregarTarjeta(tarjeta);
    }

    @PutMapping
    public Tarjeta actualizarTarjeta(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.actualizarTarjeta(tarjeta);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarTarjeta(@PathVariable int id) {
        return tarjetaService.eliminarTarjeta(id);
    }
}
