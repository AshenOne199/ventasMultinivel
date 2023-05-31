package com.udistrital.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.udistrital.app.entity.dto.RepresentantesTopDTO;

public interface RepresentantesTopRepository extends JpaRepository<RepresentantesTopDTO, Serializable>{

	 @Procedure
	 List<RepresentantesTopDTO> findTopRepresentantes(@Param("L_IDPERIODO") String idPeriodo);
	 
}