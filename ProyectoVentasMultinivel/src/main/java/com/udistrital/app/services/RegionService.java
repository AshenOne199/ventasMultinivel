package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Region;
import com.udistrital.app.entity.dto.RegionDto;
import com.udistrital.app.repository.RegionRepository;

@Service
public class RegionService {

	final private RegionRepository regionRepository;

	public RegionService(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}

	public List<Region> getRegiones() {
		
		List<Region> regiones = regionRepository.findAll();
		
		return regiones;
	}

}
