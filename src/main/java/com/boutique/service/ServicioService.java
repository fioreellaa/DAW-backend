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
	
	//Buscar
	public Servicio obtenerServicioById(int idServ) {
		return srepo.findById(idServ).orElse(null);		
	}
	    
	//Agregar
	public Servicio agregarServicio(Servicio servicio) {
	    return srepo.save(servicio);
	}

	//Eliminar
	public void eliminarServicio(int idServicio) {
		srepo.deleteById(idServicio);
	}

    
}
