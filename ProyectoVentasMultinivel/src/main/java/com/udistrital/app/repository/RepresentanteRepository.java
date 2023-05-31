package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.RepresentanteVenta;
import com.udistrital.app.entity.RepresentanteVentaId;

public interface RepresentanteRepository extends JpaRepository<RepresentanteVenta, RepresentanteVentaId> {



}
