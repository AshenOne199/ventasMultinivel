package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.ProductoPorRegionDTO;
import com.udistrital.app.services.ProductoService;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductoController {

	final private ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	// Traer todos los productos de una region y una categoria en especifico
	@GetMapping("/region/{idRegion}/categoria/{idCategoria}")
	public ResponseEntity<List<ProductoPorRegionDTO>> obtenerProductosPorRegionYCategoria(@PathVariable Short idRegion,
			@PathVariable Short idCategoria) {
		List<ProductoPorRegionDTO> productosDto = productoService.getProductosPorRegionYCategoria(idRegion,
				idCategoria);
		return ResponseEntity.ok(productosDto);
	}

	@GetMapping("/region/{idRegion}/subCategoria/{idSubcategoria}")
	public ResponseEntity<List<ProductoPorRegionDTO>> obtenerProductosPorRegionYSubcategoria(
			@PathVariable Short idRegion, @PathVariable Short idSubcategoria) {
		List<ProductoPorRegionDTO> productosDto = productoService.getProductosPorRegionYSubcategoria(idRegion,
				idSubcategoria);
		return ResponseEntity.ok(productosDto);
	}

}
