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
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.RepresentanteVentas;
import com.udistrital.app.entity.dto.RepresentanteDto;
import com.udistrital.app.entity.dto.RepresentanteIdDto;
import com.udistrital.app.entity.dto.RepresentanteSaveDto;
import com.udistrital.app.services.RepresentanteService;

@RestController
@CrossOrigin
public class RepresentanteController {

	final private RepresentanteService representanteService;

	public RepresentanteController(RepresentanteService representanteService) {
		this.representanteService = representanteService;
	}

	// Traer representante dado un id
	@GetMapping("/representante")
	public ResponseEntity<RepresentanteDto> getRepresentante(@RequestBody RepresentanteIdDto representanteIdDto) {
		RepresentanteVentaId representanteVentaId = new RepresentanteVentaId(representanteIdDto.getTipoId(), representanteIdDto.getNumeroId());
		RepresentanteDto representanteDto = representanteService.getRepresentanteDto(representanteVentaId);
		return new ResponseEntity<RepresentanteDto>(representanteDto, HttpStatus.OK);
	}
	
	@GetMapping("/representante/{username}/{password}")
	public ResponseEntity<RepresentanteDto> getRepresentantePorUsernameYPassword(@PathVariable String username, @PathVariable String password) {
		RepresentanteDto representante = representanteService.getRepresentantePorUserYPass(username, password);
		return new ResponseEntity<RepresentanteDto>(representante, HttpStatus.OK);
	}
	
	@PostMapping("/representante/save")
	public ResponseEntity<RepresentanteVentas> save(@RequestBody RepresentanteSaveDto r) {
		RepresentanteVentaId representanteVentaId = new RepresentanteVentaId(r.getTipoId(), r.getNumeroId());
		
		RepresentanteVentaId representanteVentaIdJefe = new RepresentanteVentaId(r.getTipoIdJefe(), r.getNumeroIdJefe());
		Optional<RepresentanteVentas> representanteJefe = representanteService.getRepresentante(representanteVentaIdJefe);
		RepresentanteVentas representanteFinal = null;
		if(representanteJefe.isEmpty()) {
			representanteFinal = new RepresentanteVentas(representanteVentaId, null, r.getNombreCompleto(), 
					r.getApellidoCompleto(), r.getFechaCreacion(), r.getEmail(), r.getTelefono(),
					r.getRegion(), r.getGenero(), r.getPassword(), r.getfNacimiento(), r.getDireccion(), 
					r.getTipo(), r.getFechaContrato(), r.getUsername(), r.getEstado());
		}else {
			representanteFinal = new RepresentanteVentas(representanteVentaId, representanteJefe.get(), r.getNombreCompleto(), 
					r.getApellidoCompleto(), r.getFechaCreacion(), r.getEmail(), r.getTelefono(),
					r.getRegion(), r.getGenero(), r.getPassword(), r.getfNacimiento(), r.getDireccion(), 
					r.getTipo(), r.getFechaContrato(), r.getUsername(), r.getEstado());
		}

		
		representanteService.save(representanteFinal);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/representantes/{nombreRegion}/{rango}")
	public ResponseEntity<List<RepresentanteVentas>> getRepresentantesPorRegionRango(@PathVariable String nombreRegion, @PathVariable String rango) {
		List<RepresentanteVentas> representantes = representanteService.findByregionAndTipo(nombreRegion, rango);
		return new ResponseEntity<List<RepresentanteVentas>>(representantes, HttpStatus.OK);
	}
	
	@GetMapping("/representantes/{rango}")
	public ResponseEntity<List<RepresentanteVentas>> getRepresentantesPorRango(@PathVariable String rango) {
		List<RepresentanteVentas> representantes = representanteService.findByTipo(rango);
		return new ResponseEntity<List<RepresentanteVentas>>(representantes, HttpStatus.OK);
	}
	
	@GetMapping("/representantes")
	public ResponseEntity<List<RepresentanteVentas>> getAll() {
		List<RepresentanteVentas> representantes = representanteService.findAll();
		return new ResponseEntity<List<RepresentanteVentas>>(representantes, HttpStatus.OK);
	}

}
