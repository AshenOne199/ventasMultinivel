package com.udistrital.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadisticasController {

	final private JdbcTemplate jdbcTemplate;

	public EstadisticasController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/topRegiones")
	public List<Map<String, Object>> getVistaTopRegion() {
		String sql = "SELECT * FROM VISTATOPREGION";
		return jdbcTemplate.queryForList(sql);
	}

	@GetMapping("/topProductos")
	public List<Map<String, Object>> getTopProductos() {
		String sql = "SELECT * FROM VISTATOPPRODUCTO";
		return jdbcTemplate.queryForList(sql);
	}

}
