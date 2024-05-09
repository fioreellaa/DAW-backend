package com.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Servicio;
import com.boutique.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository srepo;

    public Servicio guardarServicio(Servicio s){
        return srepo.save(s);
    }
    
    public List<Servicio> obtenerTodosLosServicios() {
    	 List<Servicio> servicios = srepo.findAll();
    	 
        return servicios;
    }
    
    public int obtenerContador() {
    	long contador = srepo.count();
    	int sevcontador = (int) contador;
    	return sevcontador;
    }

	public Servicio obtenerServicioById(int idServ) {
		return srepo.findById(idServ).orElse(null);		
	}
    
}
