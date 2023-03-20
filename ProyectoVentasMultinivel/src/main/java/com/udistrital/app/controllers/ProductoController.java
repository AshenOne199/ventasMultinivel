package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.RegionProductoDto;
import com.udistrital.app.services.ProductoService;

@RestController
public class ProductoController {
	

	final private ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	//Productos de una region en especifico
	@GetMapping("/regiones/{idRegion}/productos")
	public ResponseEntity<List<RegionProductoDto>> obtenerProductosPorRegion(@PathVariable Long idRegion) {
	    List<RegionProductoDto> productosDto = productoService.obtenerProductosPorRegion(idRegion);
	    return ResponseEntity.ok(productosDto);
	}

	
	

}
