package com.udistrital.app.entity.dto;

public class RepresentanteIdDto {

	private String tipoId;
	
	private Long numeroId;
	
	public RepresentanteIdDto() {
		
	}

	public RepresentanteIdDto(String tipoId, Long numeroId) {
		super();
		this.tipoId = tipoId;
		this.numeroId = numeroId;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public Long getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(Long numeroId) {
		this.numeroId = numeroId;
	}

	@Override
	public String toString() {
		return "RepresentanteIdDto [tipoId=" + tipoId + ", numeroId=" + numeroId + "]";
	}

	
	
	
	
}
