package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDto;
import com.udistrital.app.repository.CategoriaRepository;

@Service
public class CategoriaService {

	final private CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<CategoriaDto> getCategoriasPorRegion(Short idRegion) {
		return categoriaRepository.findAllCategoriasPorRegion(idRegion);
	}


	public List<CategoriaDto> findAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDto> categoriasDto = new ArrayList<>();
		for (Categoria categoria : categorias) {
			CategoriaDto categoriaDto = new CategoriaDto(categoria.getId(), categoria.getnNombre());
			categoriasDto.add(categoriaDto);
		}
		return categoriasDto;
	}

	public List<Categoria> getSubCategoriasPorCategoria(Short idCategoria) {
		return categoriaRepository.findByidSubcategoria(idCategoria);
	}

}
