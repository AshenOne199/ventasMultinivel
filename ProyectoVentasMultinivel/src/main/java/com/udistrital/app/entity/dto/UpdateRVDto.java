package com.udistrital.app.entity.dto;

public class UpdateRVDto {

	private String tipoIdCliente;
	private Long idCliente;

	private String tipoIdRV;
	private Long idRV;

	public UpdateRVDto() {

	}

	public UpdateRVDto(String tipoIdCliente, Long idCliente, String tipoIdRV, Long idRV) {
		super();
		this.tipoIdCliente = tipoIdCliente;
		this.idCliente = idCliente;
		this.tipoIdRV = tipoIdRV;
		this.idRV = idRV;
	}

	public String getTipoIdCliente() {
		return tipoIdCliente;
	}

	public void setTipoIdCliente(String tipoIdCliente) {
		this.tipoIdCliente = tipoIdCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoIdRV() {
		return tipoIdRV;
	}

	public void setTipoIdRV(String tipoIdRV) {
		this.tipoIdRV = tipoIdRV;
	}

	public Long getIdRV() {
		return idRV;
	}

	public void setIdRV(Long idRV) {
		this.idRV = idRV;
	}

}
