package com.boutique.controller;

import java.util.List;

import com.boutique.model.*;
import com.boutique.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;



@RestController
@RequestMapping("/servicios")
@CrossOrigin("*")
public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@Autowired
	private SedeService sedeService;

	@Autowired
	private TurnoService turnoService;

	// Listar
	@GetMapping
	public List<Servicio> listarServicios() {
		return servicioService.obtenerTodosLosServicios();
	}

	// Buscar
	@GetMapping("/{id}")
	public Servicio obtenerServicioId(@PathVariable("id") int id) {
		return servicioService.obtenerServicioById(id);
	}

	// Agregar
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Servicio agregarServicio(@RequestBody Servicio service) {
		return servicioService.agregarServicio(service);
	}

	// Editar
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Servicio modificarServicio(@PathVariable("id") int id, @RequestBody Servicio service) {
		service.setCodServicio(id);
		return servicioService.guardarServicio(service);
	}

	// Eliminar
	@DeleteMapping("/{id}")
	public void eliminarServicio(@PathVariable("id") int idServicio) {
		servicioService.eliminarServicio(idServicio);
	}


	@GetMapping("/sedes")
	public List<Sede> listarSedes() { return sedeService.findAll(); }

	@GetMapping("/turnos")
	public List<Turno> listarTurnos() { return turnoService.findAll(); }

	// Agregar servicio
	/*
	 * @PostMapping public Servicio registrarServicio(@RequestBody Servicio
	 * servicio, HttpSession session) { Usuario usuario = (Usuario)
	 * session.getAttribute("usuario"); if (usuario != null) {
	 * servicio.setUsuario(usuario); return
	 * servicioService.agregarServicio(servicio); } else { return null; } }
	 */

	// Editar Servicio
	/*
	 * @PutMapping("/{id}") public Servicio actualizarServicio(@PathVariable("id")
	 * int idServicio, @RequestBody Servicio servicio) {
	 * servicio.setCodServicio(idServicio); return
	 * servicioService.guardarServicio(servicio); }
	 */

	// Agregar respuesta
	/*
	 * @PostMapping("/responder") public Respuesta enviarRespuesta(@RequestBody
	 * Respuesta respuesta, HttpSession session) { Usuario usuario = (Usuario)
	 * session.getAttribute("usuario"); Servicio servicio =
	 * servicioService.obtenerServicioById(respuesta.getServicio().getCodServicio())
	 * ; if (usuario != null && servicio != null) { respuesta.setUsuario(usuario);
	 * respuesta.setServicio(servicio); respuesta.setFechaRespuesta(new Date());
	 * return respuestaService.guardarRespuesta(respuesta); } else { return null; }
	 * }
	 */

}
