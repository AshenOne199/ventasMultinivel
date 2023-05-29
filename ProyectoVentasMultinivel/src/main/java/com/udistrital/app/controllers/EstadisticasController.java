package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.dto.ProductosTopDTO;
import com.udistrital.app.repository.ProductosTopRepository;

import jakarta.transaction.Transactional;

@Transactional
@RestController
@CrossOrigin
public class EstadisticasController {

	private final ProductosTopRepository productosTopRepository;

    public EstadisticasController(ProductosTopRepository productosTopRepository) {
        this.productosTopRepository = productosTopRepository;
    }

    
    @GetMapping("/estadisticas/topProductos/{idPeriodo}")
    public List<ProductosTopDTO> obtenerTopProductosSpring(@PathVariable(value = "idPeriodo") String idPeriodo) {
        List<ProductosTopDTO> topProductos = productosTopRepository.findTopProductos(idPeriodo);
        return topProductos;
    }
    	
	/*
	 * @GetMapping("/estadisticas/topRegiones/{idPeriodo}") public List<Map<String,
	 * Object>> getVistaTopRegion(@PathVariable String idPeriodo) { String sql =
	 * "SELECT * FROM VISTATOPREGION WHERE K_IDPERIODO = ?"; return
	 * jdbcTemplate.queryForList(sql, idPeriodo); }
	 * 
	 * 
	 * 
	 * @GetMapping("/estadisticas/topRepresentantes/{idPeriodo}") public
	 * List<Map<String, Object>> getTopRepresentantes(@PathVariable String
	 * idPeriodo) { String sql = "SELECT * FROM VISTATOPRV WHERE K_IDPERIODO = ?";
	 * return jdbcTemplate.queryForList(sql, idPeriodo); }
	 * 
	 * @GetMapping("/calificaciones/{idTipoRep}/{idRep}") public List<Map<String,
	 * Object>> getClientesConCalificaciones(@PathVariable String idTipoRep,
	 * 
	 * @PathVariable Long idRep) { String sql =
	 * "SELECT * FROM VISTACALIFICACION WHERE I_TIPO_ID_REP = ? AND Q_NUMERO_ID_REP = ?"
	 * ; return jdbcTemplate.queryForList(sql, idTipoRep, idRep); }
	 * 
	 * @GetMapping("/nomina") public List<Map<String, Object>> getNomina() { String
	 * sql = "SELECT * FROM VISTANOMINA"; return jdbcTemplate.queryForList(sql); }
	 */

}
