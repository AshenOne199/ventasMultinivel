package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDto;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {


	@Query(value = "SELECT * FROM CATEGORIA WHERE K_IDCATEGORIA IN (SELECT P.K_IDCATEGORIA FROM PRODUCTO P, INVENTARIO I WHERE P.K_IDPRODUCTO = I.K_IDPRODUCTO AND I.K_IDREGION = :idRegion)", nativeQuery = true)
	List<Categoria> findAllCategoriasPorRegion(@Param("idRegion") Short idRegion);

	List<Categoria> findByidSubcategoria(Short kIdsubcategoria);

}
