package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Producto;
import com.boutique.repository.ProductoRepositorio;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepositorio pr;

    public List<Producto> listarProducto() {
        return pr.findAll();
    }

    public Optional<Producto> buscarProducto(int id) {
        return pr.findById(id);
    }

    public Producto agregarProducto(Producto p) {
        return pr.save(p);
    }

    public Producto actualizarProducto(Producto p) {
        if(buscarProducto(p.getCodPro()).isPresent()){
            return pr.save(p);
        }
        return null;
    }

    public Boolean deleteProducto(int id) {
        return buscarProducto(id).map(pro -> {
            pr.deleteById(id);
            return true;
        }).orElse(false);
    }
}
