package com.udistrital.app.entity.dto;

import java.math.BigDecimal;

public class RegionProductoDto {
	
    private String regionNombre;
    private String productoNombre;
    private BigDecimal precio;

    public RegionProductoDto() {
		
	}
    
    public RegionProductoDto(String regionNombre, String productoNombre, BigDecimal precio) {
        this.regionNombre = regionNombre;
        this.productoNombre = productoNombre;
        this.precio = precio;
    }

	public String getRegionNombre() {
		return regionNombre;
	}

	public void setRegionNombre(String regionNombre) {
		this.regionNombre = regionNombre;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}

