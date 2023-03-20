package com.udistrital.app.entity;

import java.io.Serializable;

public class InventarioId implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private Long producto;
    private Long region;
    
    public InventarioId() {

	}
    
	public InventarioId(Long producto, Long region) {
		this.producto = producto;
		this.region = region;
	}
	public Long getProducto() {
		return producto;
	}
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	public Long getRegion() {
		return region;
	}
	public void setRegion(Long region) {
		this.region = region;
	}
 
    
}
