package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Respuesta;
import com.boutique.repository.IRespuestaRepository;

@Service
public class RespuestaService {

    @Autowired
    private IRespuestaRepository respuestaRepository;

    public List<Respuesta> listarRespuesta() {
        return respuestaRepository.findAll();
    }

    public Optional<Respuesta> buscarRespuesta(int id) {
        return respuestaRepository.findById(id);
    }

    public Respuesta agregarRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public Respuesta actualizarRespuesta(Respuesta respuesta) {
        Optional<Respuesta> respuestaExistente = buscarRespuesta(respuesta.getCodRespuesta());
        if (respuestaExistente.isPresent()) {
            return respuestaRepository.save(respuesta);
        }
        return null;
    }

    public Boolean eliminarRespuesta(int id) {
        return buscarRespuesta(id).map(resp -> {
            respuestaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
