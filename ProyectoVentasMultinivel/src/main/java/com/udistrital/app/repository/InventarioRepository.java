package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{
	
	List<Inventario> findByRegion_IdRegion(Long idRegion);

}
