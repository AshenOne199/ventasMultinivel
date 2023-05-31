package com.udistrital.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.udistrital.app.entity.dto.RegionesTopDTO;

public interface RegionesTopRepository extends JpaRepository<RegionesTopDTO, Serializable>{

	 @Procedure
	 List<RegionesTopDTO> findTopRegiones(@Param("L_IDPERIODO") String idPeriodo);
	 
}
