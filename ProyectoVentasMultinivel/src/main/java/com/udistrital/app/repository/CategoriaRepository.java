package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDto;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {

	@Query(nativeQuery = true, name = "CategoryResult")
	public List<CategoriaDto> findAllCategoriasPorRegion(@Param("idRegion") Short idRegion);

	List<Categoria> findByidSubcategoria(Short kIdsubcategoria);

}
