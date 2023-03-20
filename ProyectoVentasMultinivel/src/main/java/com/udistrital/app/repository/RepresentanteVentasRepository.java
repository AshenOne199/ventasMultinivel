package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.udistrital.app.entity.RepresentanteVentas;
import com.udistrital.app.entity.compositehandle.RepresentanteVentasPrimaryKey;

import jakarta.transaction.Transactional;

@Repository
public interface RepresentanteVentasRepository
		extends JpaRepository<RepresentanteVentas, RepresentanteVentasPrimaryKey> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE REPRESENTANTE_VENTAS set k_numero_id_jefe =:numeroIdJefe, k_tipo_id_jefe =:tipoIdJefe where k_tipo_id =:tipoId and k_numero_id =:numeroId", nativeQuery = true)
	void updateJefeRepresentanteVentas(@Param("tipoIdJefe") String tipoIdJefe,
			@Param("numeroIdJefe") Long numeroIdJefe, @Param("tipoId") String tipoId,
			@Param("numeroId") Long numeroId);
}
