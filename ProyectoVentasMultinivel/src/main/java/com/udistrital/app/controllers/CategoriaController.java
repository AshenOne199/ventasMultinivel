package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDTO;
import com.udistrital.app.services.CategoriaService;

@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

	final private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping("/all")
	public List<CategoriaDTO> getAllCategorias() {
		return categoriaService.findAll();
	}

	@GetMapping("/region/{idRegion}")
	public List<CategoriaDTO> getAllCategoriasPorRegion(@PathVariable(name = "idRegion") Short idRegion) {
		return categoriaService.getCategoriasPorRegion(idRegion);
	}

	@GetMapping("/subcategorias/{idCategoria}")
	public List<Categoria> getAllSubCategoriasPorCategoria(@PathVariable Short idCategoria) {
		return categoriaService.getSubCategoriasPorCategoria(idCategoria);
	}

}
