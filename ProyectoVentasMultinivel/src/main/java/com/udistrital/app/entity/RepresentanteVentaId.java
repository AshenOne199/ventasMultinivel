package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;

@Embeddable
public class RepresentanteVentaId implements Serializable {

	private static final long serialVersionUID = 5470956872260265407L;

	@Size(max = 3)
	@Column(name = "K_TIPO_ID", nullable = false, length = 3)
	private String tipoId;

	@Column(name = "K_NUMERO_ID", nullable = false)
	private Long numeroId;

	public RepresentanteVentaId() {

	}

	public RepresentanteVentaId(@Size(max = 3) String tipoId, Long numeroId) {
		super();
		this.tipoId = tipoId;
		this.numeroId = numeroId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		RepresentanteVentaId entity = (RepresentanteVentaId) o;
		return Objects.equals(this.tipoId, entity.tipoId) && Objects.equals(this.numeroId, entity.numeroId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoId, numeroId);
	}

	public String getkTipoId() {
		return tipoId;
	}

	public void setkTipoId(String kTipoId) {
		this.tipoId = kTipoId;
	}

	public Long getkNumeroId() {
		return numeroId;
	}

	public void setkNumeroId(Long kNumeroId) {
		this.numeroId = kNumeroId;
	}

	@Override
	public String toString() {
		return "RepresentanteVentaId [tipoId=" + tipoId + ", numeroId=" + numeroId + "]";
	}

}