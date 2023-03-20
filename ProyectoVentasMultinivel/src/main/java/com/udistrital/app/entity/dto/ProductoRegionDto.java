package com.udistrital.app.entity.dto;

import java.util.List;

public class ProductoRegionDto {

    private String nombreRegion;
    private List<ProductoDto> productos;
    
    public ProductoRegionDto() {
		
	}
    
	public ProductoRegionDto(String nombreRegion, List<ProductoDto> productos) {
		super();
		this.nombreRegion = nombreRegion;
		this.productos = productos;
	}
	public String getNombreRegion() {
		return nombreRegion;
	}
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}
	public List<ProductoDto> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoDto> productos) {
		this.productos = productos;
	}

}

