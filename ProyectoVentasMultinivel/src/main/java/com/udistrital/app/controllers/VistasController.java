package com.udistrital.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class VistasController {

	final private JdbcTemplate jdbcTemplate;

	public VistasController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/estadisticas/topRegiones/{idPeriodo}")
	public List<Map<String, Object>> getVistaTopRegion(@PathVariable String idPeriodo) {
		String sql = "SELECT * FROM VISTATOPREGION WHERE K_IDPERIODO = ?";
		return jdbcTemplate.queryForList(sql, idPeriodo);
	}

	@GetMapping("/estadisticas/topProductos/{idPeriodo}")
	public List<Map<String, Object>> getTopProductos(@PathVariable String idPeriodo) {
		String sql = "SELECT * FROM VISTATOPPRODUCTO WHERE K_IDPERIODO = ?";
		return jdbcTemplate.queryForList(sql, idPeriodo);
	}
	
	@GetMapping("/estadisticas/topRepresentantes/{idPeriodo}")
	public List<Map<String, Object>> getTopRepresentantes(@PathVariable String idPeriodo) {
		String sql = "SELECT * FROM VISTATOPRV WHERE K_IDPERIODO = ?";
		return jdbcTemplate.queryForList(sql, idPeriodo);
	}
	
	@GetMapping("/calificaciones/{idTipoRep}/{idRep}")
	public List<Map<String, Object>> getClientesConCalificaciones(@PathVariable String idTipoRep, @PathVariable Long idRep) {
		String sql = "SELECT * FROM VISTACALIFICACION WHERE I_TIPO_ID_REP = ? AND Q_NUMERO_ID_REP = ?";
		return jdbcTemplate.queryForList(sql, idTipoRep, idRep);
	}

}
