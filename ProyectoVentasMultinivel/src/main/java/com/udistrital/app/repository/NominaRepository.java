package com.udistrital.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.udistrital.app.entity.dto.NominaDTO;

public interface NominaRepository extends JpaRepository<NominaDTO, Serializable>{

	 @Procedure
	 List<NominaDTO> findNomina();
	 
}
