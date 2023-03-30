package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Periodo;
import com.udistrital.app.repository.PeriodoRepository;

@RestController
@CrossOrigin
public class PeriodoController {

	final private PeriodoRepository periodoRepository;

	public PeriodoController(PeriodoRepository periodoRepository) {
		this.periodoRepository = periodoRepository;
	}

	@GetMapping("/periodos")
	public List<Periodo> getPeriodos() {
		return periodoRepository.findAll();
	}
	
	@GetMapping("/periodo/ultimo/{idPeriodo}")
	public Periodo getPeriodoUltimo(@PathVariable("idPeriodo") String idPeriodo) {
		return periodoRepository.getUltimoPeriodo(idPeriodo);
	}

}
