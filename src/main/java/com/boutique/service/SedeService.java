package com.boutique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.model.Sede;
import com.boutique.repository.ISedeRepository;

@Service
public class SedeService {

	@Autowired
	private ISedeRepository sedeRepository;

	public List<Sede> findAll() { return sedeRepository.findAll(); }

	public Optional<Sede> findById(int idSede) {
		return sedeRepository.findById(idSede);
	}

}
