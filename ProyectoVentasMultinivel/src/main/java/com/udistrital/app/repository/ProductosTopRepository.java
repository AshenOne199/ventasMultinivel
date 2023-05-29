package com.udistrital.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.udistrital.app.entity.dto.ProductosTopDTO;

public interface ProductosTopRepository extends JpaRepository<ProductosTopDTO, Serializable>{

	 @Procedure
	 List<ProductosTopDTO> findTopProductos(@Param("L_IDPERIODO") String idPeriodo);
}
