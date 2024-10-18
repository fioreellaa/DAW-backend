package com.boutique.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boutique.client.CitasClient;
import com.boutique.model.Servicio;

@Service
public class ServicioService {

private final CitasClient citasClient;
	
	public ServicioService(CitasClient citasClient) {
		this.citasClient = citasClient;
	}
	
    public List<Servicio> obtenerTodosLosServicios() {
    	 List<Servicio> servicios = citasClient.listarServicios();
    	 
        return servicios;
    }
    
}
