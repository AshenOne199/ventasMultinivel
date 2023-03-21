package com.udistrital.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.dto.CategoriaDto;
import com.udistrital.app.entity.dto.SubCategoriaDto;
import com.udistrital.app.repository.CategoriaRepository;

@Service
public class CategoriaService {

	final private CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	
	public List<CategoriaDto> getCategoriasPorRegion(Short idRegion){
		return categoriaRepository.findAllCategoriasPorRegion(idRegion);	
	}
	
	public List<SubCategoriaDto> getSubCategoriasPorRegion(Short idRegion){
		return categoriaRepository.findAllSubCategoriasPorRegion(idRegion);	
	}
	
}
