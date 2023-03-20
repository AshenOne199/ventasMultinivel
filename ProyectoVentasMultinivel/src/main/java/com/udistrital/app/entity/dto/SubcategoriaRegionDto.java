package com.udistrital.app.entity.dto;

public class SubcategoriaRegionDto {

	private String regionNombre;
    private String subcategoriaNombre;
    
    public SubcategoriaRegionDto() {
		
	}
    
	public SubcategoriaRegionDto(String regionNombre, String subcategoriaNombre) {
		super();
		this.regionNombre = regionNombre;
		this.subcategoriaNombre = subcategoriaNombre;
	}

	public String getRegionNombre() {
		return regionNombre;
	}

	public void setRegionNombre(String regionNombre) {
		this.regionNombre = regionNombre;
	}

	public String getSubcategoriaNombre() {
		return subcategoriaNombre;
	}

	public void setSubcategoriaNombre(String subcategoriaNombre) {
		this.subcategoriaNombre = subcategoriaNombre;
	}
    
	
    
	
}
