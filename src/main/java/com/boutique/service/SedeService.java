package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.client.CitasClient;
import com.boutique.model.Sede;

@Service
public class SedeService {

	private final CitasClient citasClient;
	
	public SedeService(CitasClient citasClient) {
		this.citasClient = citasClient;
	}

	public List<Sede> findAll() { 
		return citasClient.listarSedes(); 
	}

}
