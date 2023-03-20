package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.CategoriaRegionDto;
import com.udistrital.app.entity.dto.SubcategoriaRegionDto;
import com.udistrital.app.services.CategoriaService;

@RestController
public class CategoriaController {

	final private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	// Categorias de una region especifica
	@GetMapping("/categorias/{idRegion}")
	public ResponseEntity<List<CategoriaRegionDto>> obtenerCategoriasPorRegion(@PathVariable Long idRegion) {
		List<CategoriaRegionDto> categoriaDto = categoriaService.obtenerCategoriasPorRegion(idRegion);
		return ResponseEntity.ok(categoriaDto);
	}

	// Subcategorias de una region especifica
	@GetMapping("/subcategorias/{idRegion}")
	public ResponseEntity<List<SubcategoriaRegionDto>> obtenerSubCategoriasPorRegion(@PathVariable Long idRegion) {
		List<SubcategoriaRegionDto> subcategoriaRegionDtos = categoriaService.obtenerSubCategoriasPorRegion(idRegion);
		return ResponseEntity.ok(subcategoriaRegionDtos);
	}

}
