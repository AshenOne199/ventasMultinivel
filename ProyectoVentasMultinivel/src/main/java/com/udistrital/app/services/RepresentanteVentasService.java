package com.udistrital.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udistrital.app.entity.RepresentanteVentas;
import com.udistrital.app.entity.compositehandle.RepresentanteVentasPrimaryKey;
import com.udistrital.app.repository.RepresentanteVentasRepository;

@Service
public class RepresentanteVentasService {
	@Autowired
	private RepresentanteVentasRepository representanteVentasRepository;

	public List<RepresentanteVentas> findAll() {
		return representanteVentasRepository.findAll();
	}

	public RepresentanteVentas save(RepresentanteVentas representanteVentas) {
		System.out.println(representanteVentas.getApellidoCompleto());
		return representanteVentasRepository.save(representanteVentas);
	}

	public RepresentanteVentas saveWithJefe(RepresentanteVentas representanteVentas, String tipoIdJefe,
			Long numeroIdJefe) {
		RepresentanteVentas representante = representanteVentasRepository.save(representanteVentas);
		String repTipoId = representante.getCompositeKey().getTipoId();
		Long repNumeroId = representante.getCompositeKey().getNumeroId();
		if (!(repTipoId == tipoIdJefe && repNumeroId == numeroIdJefe)) {
			representanteVentasRepository.updateJefeRepresentanteVentas(tipoIdJefe, numeroIdJefe, repTipoId,
					repNumeroId);
		}

		return representante;
	}

	public RepresentanteVentas get(String tipoId, Long numeroId) {
		RepresentanteVentasPrimaryKey primaryKey = new RepresentanteVentasPrimaryKey(tipoId, numeroId);
		Optional<RepresentanteVentas> repOptional = representanteVentasRepository.findById(primaryKey);
		RepresentanteVentas wantedRep = repOptional.get();
		return wantedRep;
	}

	public boolean delete(String tipoId, Long numeroId) {
		try {
			RepresentanteVentasPrimaryKey primaryKey = new RepresentanteVentasPrimaryKey(tipoId, numeroId);
			representanteVentasRepository.deleteById(primaryKey);
			return true;
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return false;
		}
	}

}
