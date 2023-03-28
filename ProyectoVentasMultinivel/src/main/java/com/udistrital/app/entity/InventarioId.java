package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class InventarioId implements Serializable {
	private static final long serialVersionUID = -6877415164709982226L;
	@NotNull
	@Column(name = "K_IDPRODUCTO", nullable = false)
	private Short idProducto;

	@NotNull
	@Column(name = "K_IDREGION", nullable = false)
	private Short idRegion;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		InventarioId entity = (InventarioId) o;
		return Objects.equals(this.idProducto, entity.idProducto) && Objects.equals(this.idRegion, entity.idRegion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto, idRegion);
	}

	public Short getkIdproducto() {
		return idProducto;
	}

	public void setkIdproducto(Short kIdproducto) {
		this.idProducto = kIdproducto;
	}

	public Short getkIdregion() {
		return idRegion;
	}

	public void setkIdregion(Short kIdregion) {
		this.idRegion = kIdregion;
	}

}