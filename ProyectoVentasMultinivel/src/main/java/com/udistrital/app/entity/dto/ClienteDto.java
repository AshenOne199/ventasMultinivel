package com.udistrital.app.entity.dto;

public class ClienteDto {

	private String nombreCompleto;
	private String apellidoCompleto;
	
	public ClienteDto() {
		
	}

	public ClienteDto(String nombreCompleto, String apellidoCompleto) {
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
	
	
	
}
