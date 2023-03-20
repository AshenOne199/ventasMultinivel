package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.RepresentanteVentas;
import com.udistrital.app.services.RepresentanteVentasService;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/representante")
public class RepresentanteVentasController {

	@Autowired
	private RepresentanteVentasService representanteVentasService;

	@PostMapping("/save")
	public ResponseEntity<RepresentanteVentas> save(@RequestBody RepresentanteVentas representanteVentas) {
		return new ResponseEntity<>(representanteVentasService.save(representanteVentas), HttpStatus.CREATED);
	}

	@PostMapping("/save/jefe/{tipoId}/{numeroId}")
	public ResponseEntity<RepresentanteVentas> saveWithJefe(@RequestBody RepresentanteVentas representanteVentas,
			@PathVariable("tipoId") String tipoId, @PathVariable("numeroId") Integer numeroId) {
		return new ResponseEntity<>(representanteVentasService.saveWithJefe(representanteVentas, tipoId, numeroId),
				HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<RepresentanteVentas>> findAll() {
		return new ResponseEntity<>(representanteVentasService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/getrep/{tipoId}/{numeroId}")
	public ResponseEntity<RepresentanteVentas> findById(@PathVariable("tipoId") String tipoId,
			@PathVariable("numeroId") Integer numeroId) {
		return new ResponseEntity<RepresentanteVentas>(representanteVentasService.get(tipoId, numeroId), HttpStatus.OK);
	}

	// retorna false para caso de violacion de integridad (referencia en tabla cliente), true si todo sale bien
	@DeleteMapping("/delete/{tipoId}/{numeroId}")
	public ResponseEntity delete(@PathVariable("tipoId") String tipoId, @PathVariable("numeroId") Integer numeroId) {
		boolean transactionState = representanteVentasService.delete(tipoId, numeroId);
		return new ResponseEntity(transactionState, HttpStatus.OK);
	}

}
