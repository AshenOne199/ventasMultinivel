package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.ProductosTopDTO;
import com.udistrital.app.repository.ProductosTopRepository;

import jakarta.transaction.Transactional;

@Transactional
@RestController
@CrossOrigin
@RequestMapping("/estadisticas")
public class EstadisticasController {

	private final ProductosTopRepository productosTopRepository;

    public EstadisticasController(ProductosTopRepository productosTopRepository) {
        this.productosTopRepository = productosTopRepository;
    }

    
    @GetMapping("/topProductos/{idPeriodo}")
    public List<ProductosTopDTO> obtenerTopProductosSpring(@PathVariable(value = "idPeriodo") String idPeriodo) {
        List<ProductosTopDTO> topProductos = productosTopRepository.findTopProductos(idPeriodo);
        return topProductos;
    }
    
}