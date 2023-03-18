package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.udistrital.app.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {

	@Query(value = "SELECT * FROM PRODUCTO", nativeQuery = true)
	List<Producto> getProductos();
	
	@Query(value = "SELECT * FROM PRODUCTO WHERE K_IDPRODUCTO = :idProducto", nativeQuery = true)
	List<Producto> getProducto(Integer idProducto);
	
}
