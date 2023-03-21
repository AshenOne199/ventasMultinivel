package com.udistrital.app.entity.dto;

public class SubCategoriaDto {

	private String nombreSubcategoria;

	public SubCategoriaDto() {
		
	}
	
	public SubCategoriaDto(String nombreSubcategoria) {
		super();
		this.nombreSubcategoria = nombreSubcategoria;
	}

	public String getNombreSubcategoria() {
		return nombreSubcategoria;
	}

	public void setNombreSubcategoria(String nombreSubcategoria) {
		this.nombreSubcategoria = nombreSubcategoria;
	}
	
	
	
}
