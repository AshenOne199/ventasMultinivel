package com.udistrital.app.entity.dto;

import com.udistrital.app.entity.RepresentanteVentaId;

public class RepresentanteDto {

	private RepresentanteVentaId id;
	
	private String nombreCompleto;
	
	private String apellidoCompleto;
	
	public RepresentanteDto() {
		
	}

	public RepresentanteDto(RepresentanteVentaId id, String nombreCompleto, String apellidoCompleto) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
	}

	public RepresentanteVentaId getId() {
		return id;
	}

	public void setId(RepresentanteVentaId id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getApellidoCompleto() {
		return apellidoCompleto;
	}

	public void setApellidoCompleto(String apellidoCompleto) {
		this.apellidoCompleto = apellidoCompleto;
	}

	
	
}
