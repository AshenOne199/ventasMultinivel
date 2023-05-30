package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import com.udistrital.app.exception.RegionNoExitsException;
import com.udistrital.app.repository.RegionRepository;
import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.dto.CategoriaDto;
import com.udistrital.app.repository.CategoriaRepository;

@Service
public class CategoriaService {

	final private CategoriaRepository categoriaRepository;
	final private RegionRepository regionRepository;
	public CategoriaService(CategoriaRepository categoriaRepository, RegionRepository regionRepository) {
		this.categoriaRepository = categoriaRepository;
		this.regionRepository = regionRepository;
	}

	public List<CategoriaDto> getCategoriasPorRegion(Short idRegion) {

		if (!regionRepository.findById(idRegion).isPresent()){
			throw new RegionNoExitsException();
		}
		List<Categoria> categorias = categoriaRepository.findAllCategoriasPorRegion(idRegion);
		List<CategoriaDto> categoriasDto = new ArrayList<>();
		for (Categoria categoria : categorias) {
			CategoriaDto categoriaDto = new CategoriaDto(categoria.getId(), categoria.getnNombre(), categoria.getIva());
			categoriasDto.add(categoriaDto);
		}
		return categoriasDto;
	}

	public List<CategoriaDto> findAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDto> categoriasDto = new ArrayList<>();
		for (Categoria categoria : categorias) {
			CategoriaDto categoriaDto = new CategoriaDto(categoria.getId(), categoria.getnNombre(), categoria.getIva());
			categoriasDto.add(categoriaDto);
		}
		return categoriasDto;
	}

	public List<Categoria> getSubCategoriasPorCategoria(Short idCategoria) {
		return categoriaRepository.findByidSubcategoria(idCategoria);
	}

}
