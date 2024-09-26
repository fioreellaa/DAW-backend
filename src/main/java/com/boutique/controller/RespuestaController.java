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

import com.boutique.model.Respuesta;
import com.boutique.service.RespuestaService;

@RestController
@RequestMapping("/respuesta")
@CrossOrigin("*")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> listarRespuestas() {
        return respuestaService.listarRespuesta();
    }

    @GetMapping("/{id}")
    public Optional<Respuesta> obtenerRespuesta(@PathVariable int id) {
        return respuestaService.buscarRespuesta(id);
    }

    @PostMapping
    public Respuesta agregarRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaService.agregarRespuesta(respuesta);
    }

    @PutMapping
    public Respuesta actualizarRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaService.actualizarRespuesta(respuesta);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarRespuesta(@PathVariable int id) {
        return respuestaService.eliminarRespuesta(id);
    }
}
