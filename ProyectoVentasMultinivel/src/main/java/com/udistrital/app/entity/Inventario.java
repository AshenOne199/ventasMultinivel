package com.udistrital.app.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVENTARIO")
@IdClass(InventarioId.class)
public class Inventario {
 
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "K_IDPRODUCTO")
    private Producto producto;
 
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "K_IDREGION")
    private Region region;
 
    @Column(name = "Q_STOCK")
    private Integer stock;
 
    @Column(name = "V_PRECIOPRODUCTO")
    private BigDecimal precio;
 
    public Inventario() {
		
	}

	public Inventario(Producto producto, Region region, Integer stock, BigDecimal precio) {
		super();
		this.producto = producto;
		this.region = region;
		this.stock = stock;
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
    
    
}

