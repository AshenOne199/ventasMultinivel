package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDto;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {

	@Query(value="SELECT DISTINCT * FROM Categoria C, Region R, Inventario I, Producto P WHERE R.K_IDREGION = :idRegion AND C.K_IDSUBCATEGORIA IS NULL OR (SELECT DISTINCT CS.K_IDSUBCATEGORIA FROM CATEGORIA CS WHERE CS.K_IDSUBCATEGORIA=C.K_IDCATEGORIA)=C.K_IDCATEGORIA AND R.K_IDREGION = I.K_IDREGION AND I.K_IDPRODUCTO = P.K_IDPRODUCTO AND P.K_IDCATEGORIA = C.K_IDCATEGORIA", nativeQuery=true)
	public List<Categoria> findAllCategoriasPorRegion(Short idRegion);

	List<Categoria> findByidSubcategoria(Short kIdsubcategoria);

}


/*
	SELECT DISTINCT C.K_IDCATEGORIA, C.N_NOMBRE 
FROM Categoria C, Region R, Inventario I, Producto P 
WHERE R.K_IDREGION = 3 AND C.K_IDSUBCATEGORIA IS NULL OR (SELECT DISTINCT CS.K_IDSUBCATEGORIA FROM CATEGORIA CS WHERE CS.K_IDSUBCATEGORIA=C.K_IDCATEGORIA)=C.K_IDCATEGORIA
AND R.K_IDREGION = I.K_IDREGION 
AND I.K_IDPRODUCTO = P.K_IDPRODUCTO 
AND P.K_IDCATEGORIA = C.K_IDCATEGORIA;
*/