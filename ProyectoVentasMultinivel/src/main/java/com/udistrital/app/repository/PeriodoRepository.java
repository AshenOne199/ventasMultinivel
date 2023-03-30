package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.Periodo;
import com.udistrital.app.entity.dto.CategoriaDto;

public interface PeriodoRepository extends JpaRepository<Periodo, String> {

	@Query(nativeQuery = true, value = "SELECT * FROM PERIODO WHERE K_IDPERIODO = :idPeriodo")
	public Periodo getUltimoPeriodo(@Param("idPeriodo") String idPeriodo);
	
}
