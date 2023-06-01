package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.Persona;
import com.udistrital.app.entity.PersonaId;
import com.udistrital.app.entity.RepresentanteVenta;
import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.dto.ClienteDto;
import com.udistrital.app.entity.dto.ClienteSaveDto;
import com.udistrital.app.entity.dto.UpdateRVDto;
import com.udistrital.app.repository.PersonaRepository;
import com.udistrital.app.services.ClienteService;
import com.udistrital.app.services.RepresentanteService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteController {

	final private PersonaRepository personaRepository;
	final private ClienteService clienteService;
	final private RepresentanteService representanteService;
	final private JdbcTemplate jdbcTemplate;

	public ClienteController(JdbcTemplate jdbcTemplate, ClienteService clienteService, RepresentanteService representanteService, PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
		this.clienteService = clienteService;
		this.representanteService = representanteService;
		this.jdbcTemplate = jdbcTemplate;
	}

	// Traer todos los clientes
	@GetMapping("/all")
	public ResponseEntity<List<ClienteDto>> getClientes() {
		List<ClienteDto> clientes = clienteService.findAll();
		return ResponseEntity.ok(clientes);
	}

	// Traer cliente especifico dado Id
	@GetMapping("/findById/{id}/{tipoId}")
	public ResponseEntity<ClienteDto> getCliente(@PathVariable Long id, @PathVariable String tipoId) {
		ClienteId clienteId = new ClienteId(tipoId, id);
		ClienteDto cliente = clienteService.findByTipoIdAndId(clienteId);
		return new ResponseEntity<ClienteDto>(cliente, HttpStatus.OK);
	}

	// Registrar un nuevo cliente
	@PostMapping("/save")
	public ResponseEntity<Cliente> save(@RequestBody ClienteSaveDto c) {
		
		RepresentanteVentaId repId = new RepresentanteVentaId(c.getTipoIdRep(), c.getNumeroIdRep());
		RepresentanteVenta repVentas = representanteService.getRepresentante(repId);
		System.out.println(repVentas.toString());
			
		PersonaId personId = new PersonaId(c.getTipoId(), c.getNumeroId());
		
		Persona persona = new Persona(personId, c.getTipoIdRep(), c.getNumeroIdRep(), c.getNombreCompleto(),
				c.getApellidoCompleto(), c.getEmail(), c.getTelefono(), c.getFechaCreacion(), c.getCiudad(),
				c.getGenero(), c.getFNacimiento(), c.getDireccion());
		
		personaRepository.save(persona);
				
		someUpdate(c);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@Transactional
	public int someUpdate(ClienteSaveDto o) {
	
		String sql = "INSERT INTO CLIENTE (K_TIPO_ID, K_NUMERO_ID, Q_CUENTA, I_TIPO_ID_REP, Q_NUMERO_ID_REP) VALUES (?, ?, ?, ?, ?)";

		return jdbcTemplate.update(sql, o.getTipoId(), o.getNumeroId(), o.getCuenta(), o.getTipoIdRep(), o.getNumeroIdRep());
	}
	

	@GetMapping("/representante/{id}/{tipoId}")
	public ResponseEntity<RepresentanteVenta> getRepresentanteActual(@PathVariable Long id,
			@PathVariable String tipoId) {
		ClienteId clienteId = new ClienteId(tipoId, id);
		Cliente cliente = clienteService.findByTipoIdAndIdEntity(clienteId);
		RepresentanteVentaId representanteVentaId = new RepresentanteVentaId(
				cliente.getRepresentanteVentas().getId().getTipoId(),
				cliente.getRepresentanteVentas().getId().getNumeroId());
		RepresentanteVenta representante = representanteService.getRepresentante(representanteVentaId);
		return new ResponseEntity<RepresentanteVenta>(representante, HttpStatus.OK);
	}

	@PutMapping("/cambioRV")
	public ResponseEntity<ClienteDto> updateRV(@RequestBody UpdateRVDto updateRVDto) {
		ClienteId clienteId = new ClienteId(updateRVDto.getTipoIdCliente(), updateRVDto.getIdCliente());
		ClienteDto cliente = clienteService.findByTipoIdAndId(clienteId);

		RepresentanteVentaId representanteVentaId = new RepresentanteVentaId(updateRVDto.getTipoIdRV(),
				updateRVDto.getIdRV());
		RepresentanteVenta representante = representanteService.getRepresentante(representanteVentaId);
		if (cliente != null && representante != null) {
			clienteService.updateActualRV(clienteId, representanteVentaId);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}