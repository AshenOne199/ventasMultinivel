package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.Region;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findByProductos_Regiones(Region region);
	
}
