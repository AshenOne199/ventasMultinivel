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

//	public List<RegionDto> getRegiones() {
//		List<RegionDto> regionDtos = new ArrayList<>();
//		List<Region> regiones = regionRepository.findAll();
//		for (Region region : regiones) {
//			RegionDto regionDto = new RegionDto(region.getId(), region.getKIdpais().getNNombre(), region.getNNombre());
//			regionDtos.add(regionDto);
//		}
//		return regionDtos;
//	}

}
