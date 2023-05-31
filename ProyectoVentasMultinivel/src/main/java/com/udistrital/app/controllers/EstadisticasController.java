package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.ProductosTopDTO;
import com.udistrital.app.entity.dto.RegionesTopDTO;
import com.udistrital.app.entity.dto.RepresentantesTopDTO;
import com.udistrital.app.repository.ProductosTopRepository;
import com.udistrital.app.repository.RegionesTopRepository;
import com.udistrital.app.repository.RepresentantesTopRepository;

import jakarta.transaction.Transactional;

@Transactional
@RestController
@CrossOrigin
@RequestMapping("/estadisticas")
public class EstadisticasController {

	private final ProductosTopRepository productosTopRepository;
	private final RegionesTopRepository regionesTopRepository;
	private final RepresentantesTopRepository representanteRepository;

    public EstadisticasController(ProductosTopRepository productosTopRepository, RegionesTopRepository regionesTopRepository, RepresentantesTopRepository representanteRepository) {
        this.productosTopRepository = productosTopRepository;
        this.regionesTopRepository = regionesTopRepository;
        this.representanteRepository = representanteRepository;
    }

    
    @GetMapping("/topProductos/{idPeriodo}")
    public List<ProductosTopDTO> obtenerTopProductos(@PathVariable(value = "idPeriodo") String idPeriodo) {
        List<ProductosTopDTO> topProductos = productosTopRepository.findTopProductos(idPeriodo);
        return topProductos;
    }
    
    @GetMapping("/topRegiones/{idPeriodo}")
    public List<RegionesTopDTO> obtenerTopRegiones(@PathVariable(value = "idPeriodo") String idPeriodo) {
        List<RegionesTopDTO> topRegiones = regionesTopRepository.findTopRegiones(idPeriodo);
        return topRegiones;
    }
    
    @GetMapping("/topRepresentantes/{idPeriodo}")
	public List<RepresentantesTopDTO> obtenerTopRepresentantes(@PathVariable(value = "idPeriodo") String idPeriodo) {
    	List<RepresentantesTopDTO> topRerpesentantes = representanteRepository.findTopRepresentantes(idPeriodo);
        return topRerpesentantes;
	}
    
    
}