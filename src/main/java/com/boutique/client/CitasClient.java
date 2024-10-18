package com.boutique.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boutique.model.Citas;
import com.boutique.model.Sede;
import com.boutique.model.Servicio;
import com.boutique.model.Turno;

@FeignClient(name="citas-service", url = "http://localhost:8081")
public interface CitasClient {
	
	
	// CITAS
	
	@GetMapping("/citas/list")
	List<Citas> listCitas();
	
	@PostMapping("/citas")
	ResponseEntity<?> addCita(@RequestBody Citas cita);
	
	
	// SEDES

	@GetMapping("/citas/sedes")
	List<Sede> listarSedes();
	
	// TURNOS
	
	@GetMapping("/citas/turnos")
	List<Turno> listarTurnos();
	
	// SERVICIOS
	@GetMapping("/citas/servicios")
	List<Servicio> listarServicios();
	
}