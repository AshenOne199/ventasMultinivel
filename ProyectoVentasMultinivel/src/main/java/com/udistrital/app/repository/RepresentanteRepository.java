package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.RepresentanteVentas;

public interface RepresentanteRepository extends JpaRepository<RepresentanteVentas, RepresentanteVentaId> {

}
