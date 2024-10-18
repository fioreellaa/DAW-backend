package com.boutique.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.boutique.client.CitasClient;
import com.boutique.model.Turno;

@Service
public class TurnoService {

	private final CitasClient citasClient;
	
	public TurnoService(CitasClient citasClient) {
		this.citasClient = citasClient;
	}

	public List<Turno> findAll() { 
		return citasClient.listarTurnos(); 
	}

}
