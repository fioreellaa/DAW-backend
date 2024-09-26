package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.TipoTarjeta;
import com.boutique.repository.ITipoTarjetaRepository;

@Service
public class TipoTarjetaService {

    @Autowired
    private ITipoTarjetaRepository tipoTarjetaRepository;

    public List<TipoTarjeta> listarTipoTarjeta() {
        return tipoTarjetaRepository.findAll();
    }

    public Optional<TipoTarjeta> buscarTipoTarjeta(int id) {
        return tipoTarjetaRepository.findById(id);
    }

    public TipoTarjeta agregarTipoTarjeta(TipoTarjeta tipoTarjeta) {
        return tipoTarjetaRepository.save(tipoTarjeta);
    }

    public TipoTarjeta actualizarTipoTarjeta(TipoTarjeta tipoTarjeta) {
        Optional<TipoTarjeta> tipoTarjetaExistente = buscarTipoTarjeta(tipoTarjeta.getIdTipoTarjeta());
        if (tipoTarjetaExistente.isPresent()) {
            return tipoTarjetaRepository.save(tipoTarjeta);
        }
        return null;
    }

    public Boolean eliminarTipoTarjeta(int id) {
        return buscarTipoTarjeta(id).map(tipo -> {
            tipoTarjetaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
