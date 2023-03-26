package com.udistrital.app.entity.dto;

public class CategoriaDto {

	private Short id;
	
	private String nombreCategoria;

	public CategoriaDto() {
		
	}

	public CategoriaDto(Short id, String nombreCategoria) {
		super();
		this.id = id;
		this.nombreCategoria = nombreCategoria;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	
	
	
	
}
