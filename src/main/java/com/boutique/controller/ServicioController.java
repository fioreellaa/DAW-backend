package com.boutique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.model.Servicio;
import com.boutique.model.Usuario;
import com.boutique.service.ServicioService;
import com.boutique.service.UsuarioService;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
    private ServicioService servicioService;
	
	@GetMapping("/list")
	private List  
	
	
	@PostMapping("/registrar")
    public Servicio registrarServicio(@RequestBody Servicio servicio) {
        return servicioService.guardarServicio(servicio);
    }
	
	

}
