package com.udistrital.app.entity.dto;

public class ClienteIdDto {
	
	private String tipoId;
	private Long id;
	
	public ClienteIdDto(String tipoId, Long id) {
		super();
		this.tipoId = tipoId;
		this.id = id;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ClienteIdDto [tipoId=" + tipoId + ", id=" + id + "]";
	}
	
}
