package com.udistrital.app.entity.dto;

public class RegionDto {

	private Short idRegion;
	private String nombrePais;
	private String nombreRegion;
	

	public RegionDto() {

	}

	public RegionDto(Short idRegion, String nombrePais, String nombreRegion) {
		super();
		this.idRegion = idRegion;
		this.nombrePais = nombrePais;
		this.nombreRegion = nombreRegion;
	}

	public Short getIdRegion() {
		
		return idRegion;
	}

	public void setIdRegion(Short idRegion) {
		this.idRegion = idRegion;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

}
