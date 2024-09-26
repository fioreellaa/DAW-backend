package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Orden;
import com.boutique.model.Usuario;
import com.boutique.repository.IOrdenRepository;

@Service
public class OrdenService {

    @Autowired
    private IOrdenRepository ordenRepository;

    public List<Orden> listarOrden() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> buscarOrden(int id) {
        return ordenRepository.findById(id);
    }

    public Orden agregarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public Orden actualizarOrden(Orden orden) {

        Optional<Orden> ordenExistente = buscarOrden(orden.getCodOrden());
        if (ordenExistente.isPresent()) {
            return ordenRepository.save(orden);
        }
        return null;
    }
    public Boolean eliminarOrden(int id) {
        return buscarOrden(id).map(ord -> {
            ordenRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    // Listar todas las órdenes de un usuario específico
    public List<Orden> listarOrdenesPorUsuario(Usuario usuario) {
        return ordenRepository.findByidUsuario(usuario);
    }
}
