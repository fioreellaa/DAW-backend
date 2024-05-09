package com.boutique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Respuesta;
import com.boutique.repository.IRespuesta;

@Service
public class RespuestaService {

	@Autowired
	private IRespuesta respuestaRepository;
	
	public Respuesta guardarRespuesta(Respuesta r) {
		return respuestaRepository.save(r);
	}
}
