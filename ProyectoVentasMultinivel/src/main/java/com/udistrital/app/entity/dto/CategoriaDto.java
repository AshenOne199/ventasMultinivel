package com.udistrital.app.entity.dto;

public class CategoriaDto {

	private String nombreCategoria;

	public CategoriaDto() {
		
	}
	
	public CategoriaDto(String nombreCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	
	
}
