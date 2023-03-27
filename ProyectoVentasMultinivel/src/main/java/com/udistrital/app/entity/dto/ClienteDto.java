package com.udistrital.app.entity.dto;

import com.udistrital.app.entity.ClienteId;

public class ClienteDto {

	private ClienteId id;
	private String nombreCompleto;
	private String apellidoCompleto;
	
	
	public ClienteDto() {
		
	}


	public ClienteDto(ClienteId id, String nombreCompleto, String apellidoCompleto) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
	}


	public ClienteId getId() {
		return id;
	}


	public void setId(ClienteId id) {
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
