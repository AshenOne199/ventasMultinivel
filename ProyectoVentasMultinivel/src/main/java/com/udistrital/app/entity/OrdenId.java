package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;

@Embeddable
public class OrdenId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "K_IDORDEN", nullable = false)
	private Integer idOrden;

	@Column(name = "K_IDPRODUCTO", nullable = false)
	private Short idProducto;

	@Column(name = "K_IDREGION", nullable = false)
	private Short idRegion;

	@Size(max = 5)
	@Column(name = "K_TIPO_ID", nullable = false, length = 5)
	private String tipoId;

	@Column(name = "K_NUMERO_ID", nullable = false)
	private Long numeroId;

	@Override
	public int hashCode() {
		return Objects.hash(idOrden, idProducto, idRegion, numeroId, tipoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenId other = (OrdenId) obj;
		return Objects.equals(idOrden, other.idOrden) && Objects.equals(idProducto, other.idProducto)
				&& Objects.equals(idRegion, other.idRegion) && Objects.equals(numeroId, other.numeroId)
				&& Objects.equals(tipoId, other.tipoId);
	}

	public OrdenId() {

	}

	public OrdenId(Integer idOrden, Short idProducto, Short idRegion, @Size(max = 5) String tipoId, Long numeroId) {
		super();
		this.idOrden = idOrden;
		this.idProducto = idProducto;
		this.idRegion = idRegion;
		this.tipoId = tipoId;
		this.numeroId = numeroId;
	}

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Short getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Short idProducto) {
		this.idProducto = idProducto;
	}

	public Short getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Short idRegion) {
		this.idRegion = idRegion;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public Long getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(Long numeroId) {
		this.numeroId = numeroId;
	}

	@Override
	public String toString() {
		return "OrdenId [idOrden=" + idOrden + ", idProducto=" + idProducto + ", idRegion=" + idRegion + ", tipoId="
				+ tipoId + ", numeroId=" + numeroId + "]";
	}

}
