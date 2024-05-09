package com.boutique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Orden;
import com.boutique.model.Usuario;
import com.boutique.repository.IOrden;

import java.util.List;

@Service
public class OrdenService {

    private final IOrden ordenRepository;

    @Autowired
    public OrdenService(IOrden ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public Orden registrarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }
    
    public List<Orden> listarOrdenesPorUsuario(Usuario usuario) {
        return ordenRepository.findByidUsuario(usuario);
    }


}