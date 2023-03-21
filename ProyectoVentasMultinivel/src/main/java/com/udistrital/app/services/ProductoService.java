package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Inventario;
import com.udistrital.app.entity.dto.ProductoPorRegionDto;
import com.udistrital.app.repository.InventarioRepository;

@Service
public class ProductoService {

	final private InventarioRepository inventarioRepository;

	public ProductoService(InventarioRepository inventarioRepository) {
		this.inventarioRepository = inventarioRepository;
	}

	public List<ProductoPorRegionDto> getProductosPorRegion(Short idRegion) {
		List<ProductoPorRegionDto> productoPorRegionDtos = new ArrayList<>();
		List<Inventario> inventarios = inventarioRepository.findByidRegion_id(idRegion);
		for (Inventario inventario : inventarios) {
			ProductoPorRegionDto productoPorRegionDto = new ProductoPorRegionDto(inventario.getkIdproducto().getnNombre(), inventario.getqStock(), inventario.getvPrecioproducto(), inventario.getkIdproducto().getnUrlimagen());
			productoPorRegionDtos.add(productoPorRegionDto);
		}
		return productoPorRegionDtos;
	}

}
