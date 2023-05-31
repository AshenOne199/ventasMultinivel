package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Inventario;
import com.udistrital.app.entity.InventarioId;
import org.springframework.data.jpa.repository.Query;

public interface InventarioRepository extends JpaRepository<Inventario, InventarioId> {


	@Query(value = "SELECT i.* FROM Inventario i JOIN Producto p ON i.K_IDPRODUCTO = p.K_IDPRODUCTO WHERE i.K_IDREGION = :idRegion AND p.K_IDCATEGORIA = :idCatehoria", nativeQuery = true)
	List<Inventario> findByidRegion_idAndIdProducto_idCategoria_id(Short idRegion, Short idCatehoria);


}
