package com.udistrital.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Orden;
import com.udistrital.app.entity.OrdenId;
import com.udistrital.app.repository.OrdenRepository;
import com.udistrital.app.services.OrdenService;

@RestController
@CrossOrigin
public class OrdenController {

	private final OrdenRepository ordenRepository;
	private final OrdenService ordenService;

	public OrdenController(OrdenRepository ordenRepository, OrdenService ordenService) {
		this.ordenRepository = ordenRepository;
		this.ordenService = ordenService;
	}

	@PostMapping("/nuevaOrden")
	public ResponseEntity<Orden> saveNuevaOrden(@RequestBody Orden orden) {
		return new ResponseEntity<Orden>(ordenRepository.save(orden), HttpStatus.CREATED);
	}

	@PutMapping("/orden/estado/{estado}")
	public ResponseEntity<Optional<Orden>> setEstado(@PathVariable String estado, @RequestBody OrdenId id) {
		ordenRepository.updateestadoById(estado, id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/orden/calificacion/{calificacion}")
	public ResponseEntity<Optional<Orden>> setCalificacion(@PathVariable Short calificacion, @RequestBody OrdenId id) {
		ordenRepository.updateCalificacion(calificacion, id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/orden/maxima")
	public ResponseEntity<Orden> getPrimeraOrden() {
		List<Orden> ordenes = ordenRepository.findAll();
		Optional<Orden> ordenMaxima = ordenes.stream().reduce((first, second) -> second);
		return ResponseEntity.ok(ordenMaxima.get());
	}
	
	@GetMapping("/orden/enCarrito/{idOrden}")
	public ResponseEntity<List<Orden>> getAllOrdenesCarrito(@PathVariable Integer idOrden){
		List<Orden> ordenesEnCarrito = ordenService.findByid_idOrdenAndEstado(idOrden, "EN PROCESO");
		return ResponseEntity.ok(ordenesEnCarrito);
	}

}
