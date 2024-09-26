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

import com.boutique.model.TipoTarjeta;
import com.boutique.service.TipoTarjetaService;

@RestController
@RequestMapping("/tipotarjetas")
@CrossOrigin("*") 
public class TipoTarjetaController {

    @Autowired
    private TipoTarjetaService tipoTarjetaService;

    @GetMapping
    public List<TipoTarjeta> listarTiposTarjeta() {
        return tipoTarjetaService.listarTipoTarjeta();
    }

    @GetMapping("/{id}")
    public Optional<TipoTarjeta> obtenerTipoTarjeta(@PathVariable int id) {
        return tipoTarjetaService.buscarTipoTarjeta(id);
    }

    @PostMapping
    public TipoTarjeta agregarTipoTarjeta(@RequestBody TipoTarjeta tipoTarjeta) {
        return tipoTarjetaService.agregarTipoTarjeta(tipoTarjeta);
    }

    @PutMapping
    public TipoTarjeta actualizarTipoTarjeta(@RequestBody TipoTarjeta tipoTarjeta) {
        return tipoTarjetaService.actualizarTipoTarjeta(tipoTarjeta);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarTipoTarjeta(@PathVariable int id) {
        return tipoTarjetaService.eliminarTipoTarjeta(id);
    }
}
