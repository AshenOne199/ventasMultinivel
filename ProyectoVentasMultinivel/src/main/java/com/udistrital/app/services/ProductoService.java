package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Inventario;
import com.udistrital.app.entity.Producto;
import com.udistrital.app.entity.Region;
import com.udistrital.app.entity.dto.RegionProductoDto;
import com.udistrital.app.repository.InventarioRepository;

@Service
public class ProductoService {

    final private InventarioRepository inventarioRepository;
    
    public ProductoService(InventarioRepository inventarioRepository) {
		this.inventarioRepository = inventarioRepository;
	}
    
    
    public List<RegionProductoDto> obtenerProductosPorRegion(Long idRegion) {
        List<RegionProductoDto> productosDto = new ArrayList<>();
        List<Inventario> inventarios = inventarioRepository.findByRegion_IdRegion(idRegion);
        for (Inventario inventario : inventarios) {
            Producto producto = inventario.getProducto();
            Region region = inventario.getRegion();
            RegionProductoDto productoDto = new RegionProductoDto(region.getNombre(), producto.getNombre(), inventario.getPrecio());
            productosDto.add(productoDto);
        }
        return productosDto;
    }


}

