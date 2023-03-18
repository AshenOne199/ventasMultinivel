package com.udistrital.app.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udistrital.app.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{
	
	@Query(value = "SELECT * FROM CATEGORIA", nativeQuery = true)
	List<Categoria> getCategorias();
	
	@Query(value = "SELECT * FROM CATEGORIA WHERE (K_IDSUBCATEGORIA IS NULL)", nativeQuery = true)
	List<Categoria> getCategoriasPrincipales();
	
	@Query(value = "SELECT * FROM CATEGORIA WHERE (K_IDSUBCATEGORIA IS :idCategoria)", nativeQuery = true)
	List<Categoria> getSubCategoriasFrom(Integer idCategoria);
}
