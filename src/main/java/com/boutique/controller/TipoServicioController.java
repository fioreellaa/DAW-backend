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

import com.boutique.model.TipoServicio;
import com.boutique.service.TipoServicioService;

@RestController
@RequestMapping("/tiposervicios")
@CrossOrigin("*") 
public class TipoServicioController {

    @Autowired
    private TipoServicioService tipoServicioService;

    @GetMapping
    public List<TipoServicio> listarTiposServicios() {
        return tipoServicioService.listarTiposServicio();
    }

    @GetMapping("/{id}")
    public Optional<TipoServicio> obtenerTipoServicio(@PathVariable int id) {
        return tipoServicioService.buscarTipoServicio(id);
    }

    @PostMapping
    public TipoServicio agregarTipoServicio(@RequestBody TipoServicio tipoServicio) {
        return tipoServicioService.agregarTipoServicio(tipoServicio);
    }

    @PutMapping
    public TipoServicio actualizarTipoServicio(@RequestBody TipoServicio tipoServicio) {
        return tipoServicioService.actualizarTipoServicio(tipoServicio);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarTipoServicio(@PathVariable int id) {
        return tipoServicioService.eliminarTipoServicio(id);
    }
}
