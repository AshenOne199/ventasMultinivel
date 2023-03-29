package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;

@Embeddable
public class OrdenId {

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

}
