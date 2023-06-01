package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Persona;
import com.udistrital.app.entity.PersonaId;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, PersonaId> {
	
    Optional<Persona> findByNombreCompletoAndApellidoCompleto(String nombreCompleto, String apellidoCompleto);
	
	

}
