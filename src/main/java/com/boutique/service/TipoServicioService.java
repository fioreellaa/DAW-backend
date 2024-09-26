package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.TipoServicio;
import com.boutique.repository.ITipoServicioRepository;

@Service
public class TipoServicioService {

    @Autowired
    private ITipoServicioRepository tipoServicioRepository;

    public List<TipoServicio> listarTiposServicio() {
        return tipoServicioRepository.findAll();
    }

    public Optional<TipoServicio> buscarTipoServicio(int id) {
        return tipoServicioRepository.findById(id);
    }

    public TipoServicio agregarTipoServicio(TipoServicio tipoServicio) {
        return tipoServicioRepository.save(tipoServicio);
    }

    public TipoServicio actualizarTipoServicio(TipoServicio tipoServicio) {
        Optional<TipoServicio> tipoServicioExistente = buscarTipoServicio(tipoServicio.getIdServicio());
        if (tipoServicioExistente.isPresent()) {
            return tipoServicioRepository.save(tipoServicio);
        }
        return null;
    }

    public Boolean eliminarTipoServicio(int id) {
        return buscarTipoServicio(id).map(tipo -> {
            tipoServicioRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
