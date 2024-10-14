package com.boutique.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boutique.model.TipoTarjeta;
import com.boutique.service.TipoTarjetaService;

@RestController
@RequestMapping("/tarjetas")
@CrossOrigin("*") 
public class TarjetaController {
    @Autowired
    private TipoTarjetaService tipoTarjetaService;


    @GetMapping("/tipos")
    public List<TipoTarjeta> listarTiposTarjeta() { return tipoTarjetaService.listarTipoTarjeta(); }

    @GetMapping("/{id}")
    public Optional<TipoTarjeta> obtenerTarjeta(@PathVariable int id) {
        return tipoTarjetaService.buscarTipoTarjeta(id);
    }

}
