package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.RegionDto;
import com.udistrital.app.services.RegionService;

@RestController
public class RegionController {

	final private RegionService regionService;

	public RegionController(RegionService regionService) {
		this.regionService = regionService;
	}

	//Obtener todas las regiones registradas
	@GetMapping("/regiones")
	public List<RegionDto> getAllRegiones() {
		return regionService.getAllRegiones();		    
	}


}
