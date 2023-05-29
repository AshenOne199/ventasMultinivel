package com.udistrital.app.entity.dto;

public class CategoriaDto {

	private Short id;

	private String nombreCategoria;
	
	private Long iva;

	public CategoriaDto() {

	}

	public CategoriaDto(Short id, String nombreCategoria, Long iva) {
		super();
		this.id = id;
		this.nombreCategoria = nombreCategoria;
		this.iva = iva;
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

	public Long getIva() {
		return iva;
	}

	public void setIva(Long iva) {
		this.iva = iva;
	}
	
	

}
