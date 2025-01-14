package com.boutique.service;

import java.util.List;
import java.util.Optional;

import com.boutique.model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Venta;
import com.boutique.repository.IVentaRepository;

@Service
public class VentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private DetalleService detalleVentaService;

    public List<Venta> listarVenta() { return ventaRepository.findAll(); }

    public Optional<Venta> buscarVenta(int id) {
        return ventaRepository.findById(id);
    }

    public Venta agregarVenta(Venta venta) {
        Venta guardado = ventaRepository.save(venta);
        for (DetalleVenta detalle : venta.getDetalleVentas()) {
            detalleVentaService.agregarDetalle(detalle, guardado.getIdVenta());
        }
        return guardado;
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

//    public List<Venta> buscarVentaPorCliente(int idUsuario) {
//       return ventaRepository.findAllByUsuario_IdUsuario(idUsuario);
//   }
    
    public Venta registrarVentaConDetalles(Venta venta) {
        Venta ventaRegistrada = ventaRepository.save(venta);

        for (DetalleVenta detalle : venta.getDetalleVentas()) {
            detalle.setVenta(ventaRegistrada); 
            detalle.setProducto(detalle.getProducto());  
            detalleVentaService.agregarDetalle(detalle, ventaRegistrada.getIdVenta());
        }

        return ventaRegistrada;
    }

}