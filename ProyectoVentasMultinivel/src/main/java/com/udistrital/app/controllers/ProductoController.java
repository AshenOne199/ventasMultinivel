package com.udistrital.app.controllers;

import com.udistrital.app.entity.dto.ProductoPorRegionDto;
import com.udistrital.app.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductoController {

    final private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Traer todos los productos de una region y una categoria en especifico
    @GetMapping("/regiones/{idRegion}/productosPorCategoria/{idCategoria}")
    public ResponseEntity<List<ProductoPorRegionDto>> obtenerProductosPorRegionYCategoria(@PathVariable Short idRegion,
                                                                                          @PathVariable Short idCategoria) {
        List<ProductoPorRegionDto> productosDto = productoService.getProductosPorRegionYCategoria(idRegion,
                idCategoria);
        return ResponseEntity.ok(productosDto);
    }

}
