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
			ProductoPorRegionDto productoPorRegionDto = new ProductoPorRegionDto(inventario.getId().getkIdproducto(),
					inventario.getIdProducto().getnNombre(), inventario.getStock(), inventario.getPrecioProducto(),
					inventario.getIdProducto().getnUrlimagen());
			productoPorRegionDtos.add(productoPorRegionDto);
		}
		return productoPorRegionDtos;
	}

	public List<ProductoPorRegionDto> getProductosPorRegionYSubcategoria(Short idRegion, Short idSubCategoria) {
		List<ProductoPorRegionDto> productoPorRegionDtos = new ArrayList<>();
		List<Inventario> inventarios = inventarioRepository
				.findByidRegion_idAndIdProducto_idCategoria_idSubcategoria(idRegion, idSubCategoria);
		for (Inventario inventario : inventarios) {
			ProductoPorRegionDto productoPorRegionDto = new ProductoPorRegionDto(inventario.getId().getkIdproducto(),
					inventario.getIdProducto().getnNombre(), inventario.getStock(), inventario.getPrecioProducto(),
					inventario.getIdProducto().getnUrlimagen());
			productoPorRegionDtos.add(productoPorRegionDto);
		}
		return productoPorRegionDtos;
	}

}
