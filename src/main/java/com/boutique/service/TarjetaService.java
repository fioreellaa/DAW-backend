package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Tarjeta;
import com.boutique.repository.ITarjetaRepository;

@Service
public class TarjetaService {

    @Autowired
    private ITarjetaRepository tarjetaRepository;

    public List<Tarjeta> listarTarjeta() {
        return tarjetaRepository.findAll();
    }

    public Optional<Tarjeta> buscarTarjeta(int id) {
        return tarjetaRepository.findById(id);
    }

    public Tarjeta agregarTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    public Tarjeta actualizarTarjeta(Tarjeta tarjeta) {
        Optional<Tarjeta> tarjetaExistente = buscarTarjeta(tarjeta.getIdTarjeta());
        if (tarjetaExistente.isPresent()) {
            return tarjetaRepository.save(tarjeta);
        }
        return null;
    }

    public Boolean eliminarTarjeta(int id) {
        return buscarTarjeta(id).map(tar -> {
            tarjetaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
