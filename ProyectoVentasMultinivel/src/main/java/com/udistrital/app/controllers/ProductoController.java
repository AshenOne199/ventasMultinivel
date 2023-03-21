package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.ProductoPorRegionDto;
import com.udistrital.app.services.ProductoService;

@RestController
public class ProductoController {

	final private ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	//Traer todos los productos de una region
	@GetMapping("/regiones/{idRegion}/productos")
	public ResponseEntity<List<ProductoPorRegionDto>> obtenerProductosPorRegion(@PathVariable Short idRegion) {
	    List<ProductoPorRegionDto> productosDto = productoService.getProductosPorRegion(idRegion);
	    return ResponseEntity.ok(productosDto);
	}
	
	
}
