package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Venta;
import com.boutique.repository.IVentaRepository;

@Service
public class VentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    public List<Venta> listarVenta() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarVenta(int id) {
        return ventaRepository.findById(id);
    }

    public Venta agregarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta actualizarVenta(Venta venta) {
        Optional<Venta> ventaExistente = buscarVenta(venta.getIdVenta());
        if (ventaExistente.isPresent()) {
            return ventaRepository.save(venta);
        }
        return null;
    }

    public Boolean eliminarVenta(int id) {
        return buscarVenta(id).map(venta -> {
            ventaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
