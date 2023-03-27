package com.udistrital.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.dto.RepresentanteDto;
import com.udistrital.app.entity.dto.RepresentanteIdDto;
import com.udistrital.app.services.RepresentanteService;

@RestController
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

}
