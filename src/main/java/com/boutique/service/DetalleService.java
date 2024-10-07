package com.boutique.service;

import java.util.List;
import java.util.Optional;

import com.boutique.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.DetalleVenta;
import com.boutique.repository.IDetalleVentaRepository;

@Service
public class DetalleService {

    @Autowired
    private IDetalleVentaRepository detalleRepository;

    public List<DetalleVenta> listarDetalle() {
        return detalleRepository.findAll();
    }

    public Optional<DetalleVenta> buscarDetalle(int id) {
        return detalleRepository.findById(id);
    }

    public DetalleVenta agregarDetalle(DetalleVenta detalle, int idVenta) {
        Venta venta = new Venta();
        venta.setIdVenta(idVenta);
        detalle.setVenta(venta);
        return detalleRepository.save(detalle);
    }

    public DetalleVenta actualizarDetalle(DetalleVenta detalle) {
        if (buscarDetalle(detalle.getIdDetalle()).isPresent()) {
            return detalleRepository.save(detalle);
        }
        return null;
    }

    public Boolean eliminarDetalle(int id) {
        return buscarDetalle(id).map(det -> {
            detalleRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    public List<DetalleVenta> listarPorIdVenta(int id) { return detalleRepository.findAllByVenta_IdVenta(id); }
}
