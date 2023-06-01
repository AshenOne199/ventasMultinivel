package com.udistrital.app.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Persona;
import com.udistrital.app.repository.PersonaRepository;

@Service
public class PersonaService {
	
	final private PersonaRepository personaRepository;
	
	public PersonaService(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	public Persona save(Persona representante) {
		
		return personaRepository.save(representante);
	}

	public Persona getUsuarioPorUsername(String nombreCompleto, String apellidoCompleto) {
	    Optional<Persona> p = personaRepository.findByNombreCompletoAndApellidoCompleto(nombreCompleto, apellidoCompleto);
	    if (p.isPresent()) {
	        return p.get();
	    } else {
	        return null;
	    }
	}

}
