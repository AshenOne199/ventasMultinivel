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

	@MapsId("id")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "K_IDPRODUCTO", nullable = false)
	private Producto idProducto;

	@MapsId("id")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "K_IDREGION", nullable = false)
	private Region idRegion;

	@NotNull
	@Column(name = "Q_STOCK", nullable = false)
	private Short stock;

	@NotNull
	@Column(name = "V_PRECIOPRODUCTO", nullable = false, precision = 10, scale = 2)
	private BigDecimal precioProducto;

	public Inventario() {

	}

	public Inventario(InventarioId id, Producto idProducto, Region idRegion, @NotNull Short stock,
			@NotNull BigDecimal precioProducto) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.idRegion = idRegion;
		this.stock = stock;
		this.precioProducto = precioProducto;
	}

	public InventarioId getId() {
		return id;
	}

	public void setId(InventarioId id) {
		this.id = id;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public Region getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Region idRegion) {
		this.idRegion = idRegion;
	}

	public Short getStock() {
		return stock;
	}

	public void setStock(Short stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(BigDecimal precioProducto) {
		this.precioProducto = precioProducto;
	}

}