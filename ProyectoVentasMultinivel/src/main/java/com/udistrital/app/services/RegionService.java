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

	public List<RegionDto> getAllRegiones() {

		List<Region> regiones = regionRepository.findAll();
		List<RegionDto> regionesDTO = new ArrayList<>();
		for (Region region : regiones) {
			regionesDTO.add(new RegionDto(region.getIdRegion(), region.getNombre(), region.getPais().getIdPais()));
		}
		return regionesDTO;

	}

}
