package com.udistrital.app.entity.dto;

import java.math.BigDecimal;

public class ProductoDto {

    private Long id;
    private String nombre;
    private String urlImagen;
    private BigDecimal precio;
        
    public ProductoDto() {
		
	}
    
	public ProductoDto(Long id, String nombre, String urlImagen, BigDecimal precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
