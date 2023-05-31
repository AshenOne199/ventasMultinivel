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

	public List<ProductoPorRegionDto> getProductosPorRegionYCategoria(Short idRegion, Short idCategoria) {
		List<ProductoPorRegionDto> productoPorRegionDtos = new ArrayList<>();
		List<Inventario> inventarios = inventarioRepository.findByidRegion_idAndIdProducto_idCategoria_id(idRegion,
				idCategoria);
		for (Inventario inventario : inventarios) {
			ProductoPorRegionDto productoPorRegionDto = new ProductoPorRegionDto(inventario.getId().getKIdproducto(),
					inventario.getKIdproducto().getNNombre(), inventario.getQStock(), inventario.getVPrecioproducto(),
					inventario.getKIdproducto().getNUrlimagen());
			productoPorRegionDtos.add(productoPorRegionDto);
		}
		return productoPorRegionDtos;
	}


}
