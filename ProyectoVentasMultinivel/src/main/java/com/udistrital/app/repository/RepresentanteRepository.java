package com.udistrital.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.RepresentanteVentas;

public interface RepresentanteRepository extends JpaRepository<RepresentanteVentas, RepresentanteVentaId> {

	Optional<RepresentanteVentas> findByUsernameAndPassword(String username, String password);

}
