package com.udistrital.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.config.CustomQueryExecutor;
import com.udistrital.app.entity.RepresentanteVentas;
import com.udistrital.app.repository.RepresentanteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class RepresentanteService {

	@PersistenceContext
	public EntityManager entityManager;

	final private CustomQueryExecutor ddlExecutor;

	final private RepresentanteRepository representanteRepository;

	public RepresentanteService(RepresentanteRepository representanteRepository, CustomQueryExecutor ddlExecutor) {
		this.ddlExecutor = ddlExecutor;
		this.representanteRepository = representanteRepository;
	}

//	public RepresentanteDto getRepresentanteDto(RepresentanteVentaId representanteVentaId) {
//		Optional<RepresentanteVentas> representante = representanteRepository.findById(representanteVentaId);
//		RepresentanteDto representanteDto = null;
//		if (representante.isPresent())
//			representanteDto = new RepresentanteDto(
//					new RepresentanteVentaId(representante.get().getId().getkTipoId(),
//							representante.get().getId().getkNumeroId()),
//					representante.get().getNombreCompleto(), representante.get().getApellidoCompleto());
//		return representanteDto;
//	}
//
//	public Optional<RepresentanteVentas> getRepresentante(RepresentanteVentaId representanteVentaId) {
//		Optional<RepresentanteVentas> representante = representanteRepository.findById(representanteVentaId);
//		return representante;
//	}

//	public RepresentanteDto getRepresentantePorUserYPass(String username, String password) {
//		Optional<RepresentanteVentas> representante = representanteRepository.findByUsernameAndPassword(username,
//				password);
//		RepresentanteDto representanteDto = null;
//		if (representante.isPresent())
//			representanteDto = new RepresentanteDto(
//					new RepresentanteVentaId(representante.get().getId().getkTipoId(),
//							representante.get().getId().getkNumeroId()),
//					representante.get().getNombreCompleto(), representante.get().getApellidoCompleto());
//		return representanteDto;
//
//	}

//	public void save(RepresentanteVentas representante) {
//		representanteRepository.save(representante);
//		if (representante.getTipo().equalsIgnoreCase("MASTER")) {
//			ddlExecutor.executeRepresentanteMasterCreation(representante.getUsername(), representante.getPassword());
//		} else {
//			ddlExecutor.executeRepresentanteCreation(representante.getUsername(), representante.getPassword());
//		}
//	}

	public List<RepresentanteVentas> findByregionAndTipo(String nombreRegion, String rango) {
		return representanteRepository.findByregionAndTipo(nombreRegion, rango);
	}

	public List<RepresentanteVentas> findByTipo(String rango) {
		return representanteRepository.findByTipo(rango);
	}

	public List<RepresentanteVentas> findAll() {
		return representanteRepository.findAll();
	}

}
