package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Inventario;
import com.udistrital.app.entity.InventarioId;

public interface InventarioRepository extends JpaRepository<Inventario, InventarioId> {

	List<Inventario> findByidRegion_idAndIdProducto_idCategoria_id(Short idRegion, Short idCatehoria);

	List<Inventario> findByidRegion_idAndIdProducto_idCategoria_idSubcategoria(Short idRegion, Short idCatehoria);

}
