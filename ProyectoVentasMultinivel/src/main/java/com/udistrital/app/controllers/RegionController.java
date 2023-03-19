package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Region;
import com.udistrital.app.repository.RegionRepository;

@RestController
public class RegionController {
	
	final private RegionRepository regionRepository;
	
	public RegionController(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;	
	}
	
	@GetMapping("/getRegiones")
	public List<Region> getRegiones() {	
		return regionRepository.findAll();
	}

}
