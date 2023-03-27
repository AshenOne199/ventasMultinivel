package com.udistrital.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	// Traer cliente especifico
	@GetMapping("/representante")
	public ResponseEntity<RepresentanteDto> getCliente(@RequestBody RepresentanteIdDto representanteIdDto) {
		RepresentanteVentaId representanteVentaId = new RepresentanteVentaId(representanteIdDto.getTipoId(),
				representanteIdDto.getNumeroId());
		RepresentanteDto representanteDto = representanteService.getRepresentanteDto(representanteVentaId);
		return new ResponseEntity<RepresentanteDto>(representanteDto, HttpStatus.OK);
	}

}
