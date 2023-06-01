package com.udistrital.app.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udistrital.app.config.CustomQueryExecutor;
import com.udistrital.app.entity.RepresentanteVenta;
import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.dto.RepresentanteDTO;
import com.udistrital.app.repository.RepresentanteRepository;

import jakarta.transaction.Transactional;

@Service
public class RepresentanteService {

	final private CustomQueryExecutor ddlExecutor;
	
	final private RepresentanteRepository representanteRepository;

	public RepresentanteService(RepresentanteRepository representanteRepository, CustomQueryExecutor ddlExecutor) {
		this.representanteRepository = representanteRepository;
		this.ddlExecutor = ddlExecutor;
	}

	public RepresentanteDTO getRepresentanteDto(RepresentanteVentaId representanteVentaId) {
		Optional<RepresentanteVenta> representante = representanteRepository.findById(representanteVentaId);
		RepresentanteDTO representanteDto = null;
		if (representante.isPresent()) {
			representanteDto = new RepresentanteDTO(
					new RepresentanteVentaId(representante.get().getId().getTipoId(),
							representante.get().getId().getNumeroId()),
					representante.get().getPersona().getNombreCompleto(),
					representante.get().getPersona().getApellidoCompleto());
		}

		return representanteDto;
	}

	public RepresentanteVenta getRepresentante(RepresentanteVentaId representanteVentaId) {
		Optional<RepresentanteVenta> representante = representanteRepository.findById(representanteVentaId);
		if (representante.isPresent()) {
			return representante.get();
		}
		return null;

	}
	
	@Transactional
	public void save(RepresentanteVenta representante) {
		representanteRepository.save(representante);
		if (representante.getTipo().equalsIgnoreCase("MASTER")) {
			System.out.println(representante.getPersona().getNombreCompleto());
			ddlExecutor.executeRepresentanteMasterCreation((representante.getPersona().getNombreCompleto() + representante.getPersona().getApellidoCompleto()).trim(), "pass");
		} else {
			System.out.println(representante.getPersona().getNombreCompleto());
			ddlExecutor.executeRepresentanteCreation((representante.getPersona().getNombreCompleto() + representante.getPersona().getApellidoCompleto()).trim(), "pass");
		}
	}

}
