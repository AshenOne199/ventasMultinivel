package com.udistrital.app.entity.dto;

public class RepresentanteDto {

	private String nombreCompleto;
	
	private String apellidoCompleto;
	
	public RepresentanteDto() {
		
	}

	public RepresentanteDto(String nombreCompleto, String apellidoCompleto) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
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

	@Override
	public String toString() {
		return "RepresentanteDto [nombreCompleto=" + nombreCompleto + ", apellidoCompleto=" + apellidoCompleto + "]";
	}
	
	
}
