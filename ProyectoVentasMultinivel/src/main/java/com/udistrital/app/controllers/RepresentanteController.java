package com.udistrital.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Persona;
import com.udistrital.app.entity.PersonaId;
import com.udistrital.app.entity.RepresentanteVenta;
import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.dto.RepresentanteDTO;
import com.udistrital.app.entity.dto.RepresentanteSaveDTO;
import com.udistrital.app.services.PersonaService;
import com.udistrital.app.services.RepresentanteService;

@RestController
@CrossOrigin
@RequestMapping("/representante")
public class RepresentanteController {

	final private RepresentanteService representanteService;
	final private PersonaService personaService;

	public RepresentanteController(RepresentanteService representanteService, PersonaService personaService) {
		this.representanteService = representanteService;
		this.personaService = personaService;
	}

	@GetMapping("/findById/{id}/{tipoId}")
	public ResponseEntity<RepresentanteDTO> getRepresentante(@PathVariable Long id, @PathVariable String tipoId) {
		RepresentanteVentaId representanteVentaId = new RepresentanteVentaId(tipoId, id);
		RepresentanteDTO representanteDto = representanteService.getRepresentanteDto(representanteVentaId);
		return new ResponseEntity<RepresentanteDTO>(representanteDto, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<RepresentanteVenta> save(@RequestBody RepresentanteSaveDTO r) {

		PersonaId personaRepId = new PersonaId(r.getTipoId(), r.getNumeroId());

		RepresentanteVentaId repJefe = new RepresentanteVentaId(r.getTipoIdJefe(), r.getNumeroIdJefe());

		RepresentanteVenta repJefeEncontrado = representanteService.getRepresentante(repJefe);

		Persona personaRep = new Persona(personaRepId, r.getTipoIdJefe(), r.getNumeroIdJefe(), r.getNombreCompleto(),
				r.getApellidoCompleto(), r.getEmail(), r.getTelefono(), r.getFechaCreacion(), r.getRegion(),
				r.getGenero(), r.getFNacimiento(), r.getDireccion());

		Persona personaRe = personaService.save(personaRep);

		RepresentanteVentaId repId = new RepresentanteVentaId(personaRe.getTipoId(), personaRe.getNumeroId());

		RepresentanteVenta rep = new RepresentanteVenta(repId, personaRe, repJefeEncontrado, r.getTipo(), r.getEstado());
	
		representanteService.save(rep);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
