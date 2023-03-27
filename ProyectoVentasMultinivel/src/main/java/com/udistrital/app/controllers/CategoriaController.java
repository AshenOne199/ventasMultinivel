package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.CategoriaDto;
import com.udistrital.app.entity.dto.SubCategoriaDto;
import com.udistrital.app.services.CategoriaService;

@RestController
public class CategoriaController {

	final private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping("/categorias")
	public List<CategoriaDto> getAllCategorias() {
		return categoriaService.findAll();
	}

	@GetMapping("/categorias/{idRegion}")
	public List<CategoriaDto> getAllCategoriasPorRegion(@PathVariable(name = "idRegion") Short idRegion) {
		return categoriaService.getCategoriasPorRegion(idRegion);
	}

	@GetMapping("/subcategorias/{idRegion}")
	public List<SubCategoriaDto> getAllSubCategoriasPorRegion(@PathVariable(name = "idRegion") Short idRegion) {
		return categoriaService.getSubCategoriasPorRegion(idRegion);
	}

}
