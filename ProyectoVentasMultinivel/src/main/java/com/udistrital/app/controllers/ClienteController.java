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

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.services.ClienteService;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/save")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {

		return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/getcliente/{tipoId}/{numeroId}")
	public ResponseEntity<Cliente> findById(@PathVariable("tipoId") String tipoId,
			@PathVariable("numeroId") Integer numeroId) {
		try {
			return new ResponseEntity<Cliente>(clienteService.get(tipoId, numeroId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
	}

	// retorna false para caso de violacion de integridad, true si todo sale bien
	@DeleteMapping("/delete/{tipoId}/{numeroId}")
	public ResponseEntity<Boolean> delete(@PathVariable("tipoId") String tipoId, @PathVariable("numeroId") Integer numeroId) {
		boolean transactionState = clienteService.delete(tipoId, numeroId);
		return new ResponseEntity<Boolean>(transactionState, HttpStatus.OK);
	}

}
