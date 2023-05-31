package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.CalificacionesDTO;
import com.udistrital.app.entity.dto.NominaDTO;
import com.udistrital.app.repository.CalificacionesRepository;
import com.udistrital.app.repository.NominaRepository;

import jakarta.transaction.Transactional;

@Transactional
@RestController
@CrossOrigin
@RequestMapping("/procedures")
public class ProceduresController {
	
	private final CalificacionesRepository calificacionesRepository;
	private final NominaRepository nominaRepository;
	
	public ProceduresController(CalificacionesRepository calificacionesRepository, NominaRepository nominaRepository) {
		this.calificacionesRepository = calificacionesRepository;
		this.nominaRepository = nominaRepository;
	}
	
	@GetMapping("/calificaciones/{idPeriodo}")
    public List<CalificacionesDTO> obtenerCalificaciones(@PathVariable(value = "idPeriodo") String idPeriodo) {
        List<CalificacionesDTO> calificaciones = calificacionesRepository.findCalificaciones(idPeriodo);
        return calificaciones;
    }
	
	@GetMapping("/nomina")
    public List<NominaDTO> obtenerNomina() {
        List<NominaDTO> nomina = nominaRepository.findNomina();
        return nomina;
    }

}
