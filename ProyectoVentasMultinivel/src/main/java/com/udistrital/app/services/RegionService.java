package com.udistrital.app.services;

import com.udistrital.app.entity.Region;
import com.udistrital.app.entity.dto.RegionDTO;
import com.udistrital.app.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {

    final private RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<RegionDTO> getRegiones() {
        List<RegionDTO> regionDtos = new ArrayList<>();
        List<Region> regiones = regionRepository.findAll();
        for (Region region : regiones) {
            RegionDTO regionDto = new RegionDTO(region.getId(), region.getIdPais().getNNombre(), region.getNombre());
            regionDtos.add(regionDto);
        }
        return regionDtos;
    }

}
