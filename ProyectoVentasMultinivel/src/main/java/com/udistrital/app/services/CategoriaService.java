package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.udistrital.app.entity.Categoria;
import com.udistrital.app.entity.Region;
import com.udistrital.app.entity.dto.CategoriaRegionDto;
import com.udistrital.app.entity.dto.SubcategoriaRegionDto;
import com.udistrital.app.repository.CategoriaRepository;
import com.udistrital.app.repository.RegionRepository;

@Service
public class CategoriaService {
    
    final private CategoriaRepository categoriaRepository;

    final private RegionRepository regionRepository;
    
    public CategoriaService(CategoriaRepository categoriaRepository, RegionRepository regionRepository) {
		this.categoriaRepository = categoriaRepository;
		this.regionRepository = regionRepository;
	}

    public List<CategoriaRegionDto> obtenerCategoriasPorRegion(Long idRegion) {
        List<CategoriaRegionDto> categoriasRegion = new ArrayList<>();
        Region region = regionRepository.findById(idRegion)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la región con id " + idRegion));
        List<Categoria> categorias = categoriaRepository.findByProductos_Regiones(region);
        for (Categoria categoria : categorias) {
            CategoriaRegionDto categoriaRegionDto = new CategoriaRegionDto();
            categoriaRegionDto.setCategoriaNombre(categoria.getNombre());
            categoriaRegionDto.setRegionNombre(region.getNombre());
            categoriasRegion.add(categoriaRegionDto);
        }
        return categoriasRegion;
    }
    
    public List<SubcategoriaRegionDto> obtenerSubCategoriasPorRegion(Long idRegion) {
        List<SubcategoriaRegionDto> subcategoriaRegionDtos = new ArrayList<>();
        Region region = regionRepository.findById(idRegion)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la región con id " + idRegion));
        List<Categoria> categorias = categoriaRepository.findByProductos_Regiones(region);
        for (Categoria categoria : categorias) {
            SubcategoriaRegionDto subcategoriaRegionDto = new SubcategoriaRegionDto();
            subcategoriaRegionDto.setRegionNombre(region.getNombre());
            if(categoria.getSubcategoria() != null)
            	subcategoriaRegionDto.setSubcategoriaNombre(categoria.getNombre());
            else
            	subcategoriaRegionDto.setSubcategoriaNombre("Sin subcategoria");
            subcategoriaRegionDtos.add(subcategoriaRegionDto);
        }
        return subcategoriaRegionDtos;
    }
    

}
