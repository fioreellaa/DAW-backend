package com.boutique.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.boutique.model.Cita;
import com.boutique.model.Sede;
import com.boutique.model.Turno;
import com.boutique.repository.ICitasRepository;
import com.boutique.repository.ISedeRepository;

@Service
public class CitaService {

	@Autowired
	private ICitasRepository citasRepository;
	
	@Autowired
	private SedeService sedeService;
	
	@Autowired
	private TurnoService turnoService;
	
	public List<Cita> listarCitas() {
        return citasRepository.findAll();
    }

	public boolean canAddCita(Sede idSede, Turno idTurno, LocalDate fecha) {
        long count = citasRepository.countBySedeAndTurnoAndFechaCita(idSede, idTurno, fecha);
        return count < 3;
    }
	
    public Cita addCita(Cita c) {
    	if (canAddCita(c.getSede(), c.getTurno(), c.getFechaCita())) {
    		c.setEstado("RESERVADA");
            return citasRepository.save(c);  
        } else {
            System.out.println("No se pueden agregar más citas en esta sede, turno y fecha.");
            return null;
        }
    }
    
    public List<Cita> searchByDate(LocalDate fecha) {
    	return citasRepository.findByFechaCita(fecha);
    }
    
    public List<Cita> searchBySede(int idSede) {
    	Optional<Sede> sede = sedeService.findById(idSede);
    	return citasRepository.findBySede(sede);
    }
    
    public List<Cita> searchByTurno(int idTurno) {
    	Optional<Turno> turno = turnoService.findById(idTurno);
    	return citasRepository.findByTurno(turno);
    }
    
    public List<Cita> searchBySedeTurnoAndDate(int idSede, int idTurno, LocalDate fecha) {
    	Optional<Sede> sede = sedeService.findById(idSede);
    	Optional<Turno> turno = turnoService.findById(idTurno);
        return citasRepository.findBySedeAndTurnoAndFechaCita(sede, turno, fecha);
    }
    
    public List<Cita> searchByEstado(String estado) {
        return citasRepository.findByEstado(estado);
    }

    /*
    public Optional<Cita> searchCita(int id) {
        return citasRepository.findById(id);
    }
    
    public Cita updateCita(Cita c) {
        if(searchCita(c.getCodCita()).isPresent()){
            return citasRepository.save(c);
        }
        return null;
    }

    
    public Boolean deleteCita(int id) {
        return searchCita(id).map(pro -> {
            citasRepository.deleteById(id);
            return true;
        }).orElse(false);
    }*/
}
