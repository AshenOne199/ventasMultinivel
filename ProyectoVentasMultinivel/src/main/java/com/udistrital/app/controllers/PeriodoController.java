package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Periodo;
import com.udistrital.app.repository.PeriodoRepository;

@RestController
public class PeriodoController {
	
	final private PeriodoRepository periodoRepository;
	
	public PeriodoController(PeriodoRepository periodoRepository) {
		this.periodoRepository = periodoRepository;
	}
	
	@GetMapping("/periodos")
	public List<Periodo> getPeriodos(){
		return periodoRepository.findAll();
	}

}
