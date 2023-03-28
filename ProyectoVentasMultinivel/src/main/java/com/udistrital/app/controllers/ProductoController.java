package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.ProductoPorRegionDto;
import com.udistrital.app.services.ProductoService;

@RestController
@CrossOrigin
public class ProductoController {

	final private ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	// Traer todos los productos de una region y una categoria en especifico
	@GetMapping("/regiones/{idRegion}/productosPorCategoria/{idCategoria}")
	public ResponseEntity<List<ProductoPorRegionDto>> obtenerProductosPorRegionYCategoria(@PathVariable Short idRegion,
			@PathVariable Short idCategoria) {
		List<ProductoPorRegionDto> productosDto = productoService.getProductosPorRegionYCategoria(idRegion,
				idCategoria);
		return ResponseEntity.ok(productosDto);
	}

	@GetMapping("/regiones/{idRegion}/productosPorSubcategoria/{idSubcategoria}")
	public ResponseEntity<List<ProductoPorRegionDto>> obtenerProductosPorRegionYSubcategoria(
			@PathVariable Short idRegion, @PathVariable Short idSubcategoria) {
		List<ProductoPorRegionDto> productosDto = productoService.getProductosPorRegionYSubcategoria(idRegion,
				idSubcategoria);
		return ResponseEntity.ok(productosDto);
	}

}
