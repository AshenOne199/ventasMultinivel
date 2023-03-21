package com.udistrital.app.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "INVENTARIO")
public class Inventario {
    @EmbeddedId
    private InventarioId id;

    @MapsId("idProducto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "K_IDPRODUCTO", nullable = false)
    private Producto idProducto;

    @MapsId("idRegion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "K_IDREGION", nullable = false)
    private Region idRegion;

    @NotNull
    @Column(name = "Q_STOCK", nullable = false)
    private Short stock;

    @NotNull
    @Column(name = "V_PRECIOPRODUCTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioProducto;

	public InventarioId getId() {
		return id;
	}

	public void setId(InventarioId id) {
		this.id = id;
	}

	public Producto getkIdproducto() {
		return idProducto;
	}

	public void setkIdproducto(Producto kIdproducto) {
		this.idProducto = kIdproducto;
	}

	public Region getkIdregion() {
		return idRegion;
	}

	public void setkIdregion(Region kIdregion) {
		this.idRegion = kIdregion;
	}

	public Short getqStock() {
		return stock;
	}

	public void setqStock(Short qStock) {
		this.stock = qStock;
	}

	public BigDecimal getvPrecioproducto() {
		return precioProducto;
	}

	public void setvPrecioproducto(BigDecimal vPrecioproducto) {
		this.precioProducto = vPrecioproducto;
	}
    
    

}