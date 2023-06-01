package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.RepresentanteVenta;
import com.udistrital.app.entity.RepresentanteVentaId;

public interface RepresentanteRepository extends JpaRepository<RepresentanteVenta, RepresentanteVentaId> {
	
	List<RepresentanteVenta> findByPersona_CiudadAndTipo(String ciudad, String tipo);


	List<RepresentanteVenta> findByTipo(String tipo);

}
