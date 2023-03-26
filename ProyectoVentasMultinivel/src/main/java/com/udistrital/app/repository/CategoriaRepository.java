package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDto;
import com.udistrital.app.entity.dto.SubCategoriaDto;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{
	
	
	@Query("SELECT DISTINCT new com.udistrital.app.entity.dto.CategoriaDto(C.id, C.nombre) "
			+ "FROM Categoria C, Region R, Inventario I, Producto P WHERE R.id = :idRegion AND R.id = I.idRegion AND I.idProducto = P.id AND P.idCategoria = C.id AND C.idSubcategoria IS NULL")
	public List<CategoriaDto> findAllCategoriasPorRegion(Short idRegion);
	
	@Query("SELECT DISTINCT new com.udistrital.app.entity.dto.SubCategoriaDto(C.id, C.nombre) "
			+ "FROM Categoria C, Region R, Inventario I, Producto P WHERE R.id = :idRegion AND R.id = I.idRegion AND I.idProducto = P.id AND P.idCategoria = C.id AND C.idSubcategoria IS NOT NULL")
	public List<SubCategoriaDto> findAllSubCategoriasPorRegion(Short idRegion);
	
	
}
