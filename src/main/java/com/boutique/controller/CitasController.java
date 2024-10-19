package com.boutique.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boutique.model.Citas;
import com.boutique.model.Sede;
import com.boutique.model.Servicio;
import com.boutique.model.Turno;
import com.boutique.service.CitaService;
import com.boutique.service.ExternalService;
import com.boutique.service.SedeService;
import com.boutique.service.ServicioService;
import com.boutique.service.TurnoService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/citas")
public class CitasController {

	@Autowired
    private ExternalService externalService;
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private SedeService sedeService;
	
	@Autowired
	private TurnoService turnoService;
	
	@Autowired
	private ServicioService servicioService;

	@GetMapping("/list")
	public List<Citas> listCitas() {
		return citaService.listarCitas();
	}
	
	@PostMapping
	public ResponseEntity<?> addCita(@RequestBody Citas cita) {
		return citaService.addCita(cita);
	}
	
	@GetMapping("/turnos")
	public List<Turno> listTurnos(){
		return turnoService.findAll();
	}
	
	
	@GetMapping("/servicios")
	public List<Servicio> listServicios(){
		return servicioService.obtenerTodosLosServicios();
	}
	
	@GetMapping("/sedes")
	public List<Sede> listSede(){
		return sedeService.findAll();
	}
	
	 @GetMapping("/test-circuit-breaker")
	 public String testCircuitBreaker() {
		 return externalService.callClienteService();
		 }
	
	
//	@GetMapping("/list/fecha/{fecha}")
//	public List<Citas> listCitasByDate(@PathVariable LocalDate fecha) {
//		return citaService.searchByDate(fecha);
//	}
//	
//	@GetMapping("/list/sede/{idSede}")
//	public List<Citas> listCitasBySede(@PathVariable int idSede) {
//		return citaService.searchBySede(idSede);
//	}
//	
//	@GetMapping("/list/estado/{estado}")
//	public List<Citas> listCitasByEstado(@PathVariable String estado) {
//		return citaService.searchByEstado(estado);
//	}
//	
//	@GetMapping("/list/sede/{idSede}/turno/{idTurno}/fecha/{fecha}")
//	public List<Citas> listCitasBySedeTurnoAndFecha(@PathVariable int idSede, @PathVariable int idTurno, @PathVariable LocalDate fecha) {
//		return citaService.searchBySedeTurnoAndDate(idSede, idTurno, fecha);
//	}
//
//	/*
//	 * @GetMapping("/{id}") public Optional<Cita> getCita(@PathVariable int id) {
//	 * return citaService.searchCita(id); }
//	 */
//

//
//	@PutMapping("/{id}/estado")
//	public Citas updateEstado (@PathVariable int id, @RequestBody String estado) {
//		Optional<Citas> citaOptional = citaService.searchCita(id);
//		Citas cita = citaOptional.get();
//	    cita.setEstado(estado);
//	    return citaService.updateCita(cita);
//	}
//
//	@GetMapping("/user")
//	public List<Citas> findByEmail(@RequestParam String email) {
//		return citaService.findAllByEmail(email);
//	}
//	/*
//	 * @PutMapping public Cita updateCita(@RequestBody Cita cita) { return
//	 * citaService.updateCita(cita); }
//	 *
//	 * @DeleteMapping("/{id}") public Boolean deleteCita(@PathVariable int id) {
//	 * return citaService.deleteCita(id); }
//	 */
}

