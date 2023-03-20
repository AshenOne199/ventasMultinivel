package com.udistrital.app.entity.dto;

public class CategoriaRegionDto {
    private String regionNombre;
    private String categoriaNombre;
    
    public CategoriaRegionDto() {
		
	}
    
	public CategoriaRegionDto(String regionNombre, String categoriaNombre) {
		super();
		this.regionNombre = regionNombre;
		this.categoriaNombre = categoriaNombre;
	}
	public String getRegionNombre() {
		return regionNombre;
	}
	public void setRegionNombre(String regionNombre) {
		this.regionNombre = regionNombre;
	}
	public String getCategoriaNombre() {
		return categoriaNombre;
	}
	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}
    
}

