package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udistrital.app.entity.Producto;
import com.udistrital.app.entity.Region;
import com.udistrital.app.entity.dto.RegionProductoDto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	List<Producto> findByRegiones(Region region);
	
	@Query("SELECT new com.udistrital.app.entity.dto.RegionProductoDto(r.nombre, p.nombre, i.precio) "
            + "FROM Region r "
            + "JOIN r.inventarios i "
            + "JOIN i.producto p ")
    List<RegionProductoDto> obtenerProductosPorRegion();
	
}
