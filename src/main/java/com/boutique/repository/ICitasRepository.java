package com.boutique.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boutique.model.Cita;
import com.boutique.model.Sede;
import com.boutique.model.Turno;

@Repository
public interface ICitasRepository extends JpaRepository<Cita, Integer>{

	List<Cita> findByFechaCita(LocalDate fecha);

	List<Cita> findBySede(Optional<Sede> sede);

	List<Cita> findByEstado(String estado);

	List<Cita> findBySedeAndTurnoAndFechaCita(Optional<Sede> sede, Optional<Turno> turno, LocalDate fechaCita);

	long countBySedeAndTurnoAndFechaCita(Sede sede, Turno turno, LocalDate fechaCita);

	List<Cita> findByTurno(Optional<Turno> turno);
	
}
