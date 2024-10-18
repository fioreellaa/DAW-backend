package com.boutique.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boutique.client.CitasClient;
import com.boutique.model.Citas;
import com.boutique.model.Sede;
import com.boutique.model.Turno;

@Service
public class CitaService {
	
	private final CitasClient citasClient;
	
	public CitaService(CitasClient citasClient) {
		this.citasClient = citasClient;
	}
	
//	@Autowired
//	private SedeService sedeService;
//	
//	@Autowired
//	private TurnoService turnoService;
//	
	public List<Citas> listarCitas() {
        return citasClient.listCitas();
    }

	public ResponseEntity<?> addCita(Citas c) {
	    return citasClient.addCita(c);
	}
	
//   
//    
//    public List<Citas> searchBySedeTurnoAndDate(int idSede, int idTurno, LocalDate fecha) {
//    	Optional<Sede> sede = sedeService.findById(idSede);
//    	Optional<Turno> turno = turnoService.findById(idTurno);
//        return citasRepository.findBySedeAndTurnoAndFechaCita(sede, turno, fecha);
//    }
//    
//    public List<Citas> searchByEstado(String estado) {
//        return citasRepository.findByEstado(estado);
//    }
//
//    
//    public Optional<Citas> searchCita(int id) {
//        return citasRepository.findById(id);
//    }
//    
//
//    public Citas updateCita(Citas c) {
//        if(searchCita(c.getCodCita()).isPresent()){
//            return citasRepository.save(c);
//        }
//        return null;
//    }
//
//    public List<Citas> findAllByEmail(String email) {
//        return citasRepository.findAllByEmail(email);
//    }
//
//    /*
//    public Boolean deleteCita(int id) {
//        return searchCita(id).map(pro -> {
//            citasRepository.deleteById(id);
//            return true;
//        }).orElse(false);
//    }*/
}
