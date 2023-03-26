package com.udistrital.app.entity.dto;

public class SubCategoriaDto {

	private Short id;
	
	private String nombreSubcategoria;

	public SubCategoriaDto() {
		
	}

	public SubCategoriaDto(Short id, String nombreSubcategoria) {
		super();
		this.id = id;
		this.nombreSubcategoria = nombreSubcategoria;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNombreSubcategoria() {
		return nombreSubcategoria;
	}

	public void setNombreSubcategoria(String nombreSubcategoria) {
		this.nombreSubcategoria = nombreSubcategoria;
	}
	

	
	
	
}
