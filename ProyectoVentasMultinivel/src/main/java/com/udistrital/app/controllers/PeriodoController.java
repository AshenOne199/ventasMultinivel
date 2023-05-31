package com.udistrital.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Periodo;
import com.udistrital.app.exceptions.NotFoundException;
import com.udistrital.app.repository.PeriodoRepository;

@RestController
@CrossOrigin
@RequestMapping("/periodo")
public class PeriodoController {

	final private PeriodoRepository periodoRepository;

	public PeriodoController(PeriodoRepository periodoRepository) {
		this.periodoRepository = periodoRepository;
	}

	@GetMapping("/all")
	public List<Periodo> getPeriodos() {
		return periodoRepository.findAll();
	}

	@GetMapping("/ultimo")
	public ResponseEntity<?> getPeriodoUltimo() {

		Optional<Periodo> periodoObtenido = periodoRepository.getUltimoPeriodo();

		if (periodoObtenido.isEmpty()) {
			throw new NotFoundException();
		}

		return ResponseEntity.status(HttpStatus.OK).body(periodoObtenido.get());
	}

	@GetMapping("/findById/{periodo}")
	public ResponseEntity<?> getPeriodos(@PathVariable String periodo) {

		Optional<Periodo> periodoObtenido = periodoRepository.findById(periodo);

		if (periodoObtenido.isEmpty()) {
			throw new NotFoundException();
		}

		return ResponseEntity.status(HttpStatus.OK).body(periodoObtenido.get());
	}

}
