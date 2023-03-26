package com.udistrital.app.entity.dto;

import java.math.BigDecimal;

public class ProductoPorRegionDto {
	
	private Short id;
	private String nombreProducto;
	private Short stock;
	private BigDecimal precio;
	private String url;
	
	public ProductoPorRegionDto() {
		
	}

	public ProductoPorRegionDto(Short id, String nombreProducto, Short stock, BigDecimal precio, String url) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
		this.precio = precio;
		this.url = url;
	}

	
	
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Short getStock() {
		return stock;
	}

	public void setStock(Short stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
