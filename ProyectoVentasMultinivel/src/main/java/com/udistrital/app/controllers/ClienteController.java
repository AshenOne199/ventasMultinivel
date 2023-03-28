package com.udistrital.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.RepresentanteVentas;
import com.udistrital.app.entity.dto.ClienteDto;
import com.udistrital.app.entity.dto.ClienteIdDto;
import com.udistrital.app.entity.dto.ClienteSaveDto;
import com.udistrital.app.services.ClienteService;
import com.udistrital.app.services.RepresentanteService;

@RestController
@CrossOrigin
@RequestMapping("/api/cliente")
public class ClienteController {

	final private ClienteService clienteService;
	final private RepresentanteService representanteService;

	public ClienteController(ClienteService clienteService, RepresentanteService representanteService) {
		this.clienteService = clienteService;
		this.representanteService = representanteService;
	}

	// Traer un cliente dado un email y password
	@GetMapping("/cliente/{username}/{password}")
	public ResponseEntity<ClienteDto> getClienteLogin(@PathVariable String username, @PathVariable String password) {
		ClienteDto clienteLogin = clienteService.getClienteLogin(username, password);
		return ResponseEntity.ok(clienteLogin);
	}

	// Traer todos los clientes
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDto>> getClientes() {
		List<ClienteDto> clientes = clienteService.findAll();
		return ResponseEntity.ok(clientes);
	}

	// Traer cliente especifico dado Id
	@GetMapping("/cliente")
	public ResponseEntity<ClienteDto> getCliente(@RequestBody ClienteIdDto clienteIdDto) {
		ClienteId clienteId = new ClienteId(clienteIdDto.getTipoId(), clienteIdDto.getId());
		ClienteDto cliente = clienteService.findByTipoIdAndId(clienteId);
		return new ResponseEntity<ClienteDto>(cliente, HttpStatus.OK);
	}

	// Registrar un nuevo cliente
	@PostMapping("/cliente/save")
	public ResponseEntity<Cliente> save(@RequestBody ClienteSaveDto c) {
		RepresentanteVentaId representanteVentaId = new RepresentanteVentaId(c.getTipoIdRep(), c.getNumeroIdRep());
		Optional<RepresentanteVentas> representante = representanteService.getRepresentante(representanteVentaId);
		ClienteId clienteId = new ClienteId(c.getTipoId(), c.getNumeroId());
		Cliente cliente = new Cliente(clienteId, representante.get(), c.getTipoIdRepInicial(), c.getNumeroIdRepInicial(), c.getNombreCompleto(), c.getApellidoCompleto(),
				c.getFechaCreacion(), c.getEmail(), c.getTelefono(), c.getCiudad(), c.getGenero(), c.getPassword(), c.getfNacimiento(), c.getDireccion(), c.getUsername());
		clienteService.save(cliente);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
