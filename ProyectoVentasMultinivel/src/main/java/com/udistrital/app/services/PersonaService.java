package com.udistrital.app.services;

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
}
