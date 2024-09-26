package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.CategoriaProducto;
import com.boutique.repository.ICategoriaProductoRepository;

@Service
public class CategoriaProductoService {

    @Autowired
    private ICategoriaProductoRepository categoriaProductoRepository;

    public List<CategoriaProducto> listarCategoria() {
        return categoriaProductoRepository.findAll();
    }

    public Optional<CategoriaProducto> buscarCategoria(int id) {
        return categoriaProductoRepository.findById(id);
    }

    public CategoriaProducto agregarCategoria(CategoriaProducto categoria) {
        return categoriaProductoRepository.save(categoria);
    }

    public CategoriaProducto actualizarCategoria(CategoriaProducto categoria) {
        Optional<CategoriaProducto> categoriaExistente = buscarCategoria(categoria.getIdCategoria());
        if (categoriaExistente.isPresent()) {
            return categoriaProductoRepository.save(categoria);
        }
        return null;
    }

    public Boolean eliminarCategoria(int id) {
        return buscarCategoria(id).map(cat -> {
            categoriaProductoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
