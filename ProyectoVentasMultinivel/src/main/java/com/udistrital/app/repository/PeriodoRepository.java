package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udistrital.app.entity.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo, String> {

	@Query(nativeQuery = true, value = "SELECT DISTINCT * FROM PERIODO ORDER BY K_IDPERIODO DESC FETCH FIRST ROW ONLY")
	public Periodo getUltimoPeriodo();

}
