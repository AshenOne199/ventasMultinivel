package com.udistrital.app.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.RepresentanteVentas;
import com.udistrital.app.entity.dto.RepresentanteDto;
import com.udistrital.app.repository.RepresentanteRepository;

@Service
public class RepresentanteService {
	
	final private RepresentanteRepository representanteRepository;
	
	public RepresentanteService(RepresentanteRepository representanteRepository) {
		this.representanteRepository = representanteRepository;
	}

	
	public RepresentanteDto getRepresentanteDto(RepresentanteVentaId representanteVentaId) {
		Optional<RepresentanteVentas> representante = representanteRepository.findById(representanteVentaId);
		RepresentanteDto representanteDto = null;
		if(representante.isPresent())
			representanteDto = new RepresentanteDto(representante.get().getNombreCompleto(), representante.get().getApellidoCompleto());
		return representanteDto;
	}
	
	public Optional<RepresentanteVentas> getRepresentante(RepresentanteVentaId representanteVentaId) {
		Optional<RepresentanteVentas> representante = representanteRepository.findById(representanteVentaId);
		return representante;
	}

	
}
