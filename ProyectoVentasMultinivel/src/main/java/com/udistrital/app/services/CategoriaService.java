package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDTO;
import com.udistrital.app.repository.CategoriaRepository;

@Service
public class CategoriaService {

	final private CategoriaRepository categoriaRepository;
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<CategoriaDTO> getCategoriasPorRegion(Short idRegion) {
		return categoriaRepository.findAllCategoriasPorRegion(idRegion);
	}

	public List<CategoriaDTO> findAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDTO> categoriasDto = new ArrayList<>();
		for (Categoria categoria : categorias) {
			CategoriaDTO categoriaDto = new CategoriaDTO(categoria.getId(), categoria.getNombre(), categoria.getIva());
			categoriasDto.add(categoriaDto);
		}
		return categoriasDto;
	}

	public List<Categoria> getSubCategoriasPorCategoria(Short idCategoria) {
		return categoriaRepository.findByIdSubcategoria(idCategoria);
	}

}
