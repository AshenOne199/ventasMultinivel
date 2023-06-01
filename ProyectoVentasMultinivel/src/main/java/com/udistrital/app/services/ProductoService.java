package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Inventario;
import com.udistrital.app.entity.dto.ProductoPorRegionDTO;
import com.udistrital.app.repository.InventarioRepository;

@Service
public class ProductoService {

	final private InventarioRepository inventarioRepository;

	public ProductoService(InventarioRepository inventarioRepository) {
		this.inventarioRepository = inventarioRepository;
	}

	public List<ProductoPorRegionDTO> getProductosPorRegionYCategoria(Short idRegion, Short idCategoria) {
		List<ProductoPorRegionDTO> productoPorRegionDtos = new ArrayList<>();
		List<Inventario> inventarios = inventarioRepository.findByidRegion_idAndIdProducto_idCategoria_id(idRegion,
				idCategoria);
		for (Inventario inventario : inventarios) {
			ProductoPorRegionDTO productoPorRegionDto = new ProductoPorRegionDTO(inventario.getId().getIdProducto(),
					inventario.getIdProducto().getNombre(), inventario.getStock(), inventario.getPrecioProducto(),
					inventario.getIdProducto().getUrlImagen());
			productoPorRegionDtos.add(productoPorRegionDto);
		}
		return productoPorRegionDtos;
	}

	public List<ProductoPorRegionDTO> getProductosPorRegionYSubcategoria(Short idRegion, Short idSubCategoria) {
		List<ProductoPorRegionDTO> productoPorRegionDtos = new ArrayList<>();
		List<Inventario> inventarios = inventarioRepository
				.findByidRegion_idAndIdProducto_idCategoria_idSubcategoria(idRegion, idSubCategoria);
		for (Inventario inventario : inventarios) {
			ProductoPorRegionDTO productoPorRegionDto = new ProductoPorRegionDTO(inventario.getId().getIdProducto(),
					inventario.getIdProducto().getNombre(), inventario.getStock(), inventario.getPrecioProducto(),
					inventario.getIdProducto().getUrlImagen());
			productoPorRegionDtos.add(productoPorRegionDto);
		}
		return productoPorRegionDtos;
	}

}