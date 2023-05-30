package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.RegionDto;
import com.udistrital.app.services.RegionService;

@RestController
@CrossOrigin
public class RegionController {

	final private RegionService regionService;

	public RegionController(RegionService regionService) {
		this.regionService = regionService;
	}

//	// Traer todas las regiones
//	@GetMapping("/regiones")
//	public ResponseEntity<List<RegionDto>> getRegiones() {
//		return ResponseEntity.ok(regionService.getRegiones());
//	}

}
