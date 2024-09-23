package com.boutique.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boutique.model.Cita;
import com.boutique.model.Sede;
import com.boutique.service.CitaService;

@RestController
@RequestMapping("/citas")
public class CitasController {

	@Autowired
	private CitaService citaService;

	@GetMapping("/list")
	public List<Cita> listCitas() {
		return citaService.listarCitas();
	}
	
	@GetMapping("/list/fecha/{fecha}")
	public List<Cita> listCitasByDate(@PathVariable LocalDate fecha) {
		return citaService.searchByDate(fecha);
	}
	
	@GetMapping("/list/sede/{idSede}")
	public List<Cita> listCitasBySede(@PathVariable int idSede) {
		return citaService.searchBySede(idSede);
	}
	
	@GetMapping("/list/estado/{estado}")
	public List<Cita> listCitasByEstado(@PathVariable String estado) {
		return citaService.searchByEstado(estado);
	}
	
	@GetMapping("/list/sede/{idSede}/turno/{idTurno}/fecha/{fecha}")
	public List<Cita> listCitasBySedeTurnoAndFecha(@PathVariable int idSede, @PathVariable int idTurno, @PathVariable LocalDate fecha) {
		return citaService.searchBySedeTurnoAndDate(idSede, idTurno, fecha);
	}
	
	/*
	 * @GetMapping("/{id}") public Optional<Cita> getCita(@PathVariable int id) {
	 * return citaService.searchCita(id); }
	 */

	@PostMapping
	public Cita addCita(@RequestBody Cita cita) {
		return citaService.addCita(cita);
	}

	/*
	 * @PutMapping public Cita updateCita(@RequestBody Cita cita) { return
	 * citaService.updateCita(cita); }
	 * 
	 * @DeleteMapping("/{id}") public Boolean deleteCita(@PathVariable int id) {
	 * return citaService.deleteCita(id); }
	 */

}