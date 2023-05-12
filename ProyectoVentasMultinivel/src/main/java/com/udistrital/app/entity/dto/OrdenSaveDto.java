package com.udistrital.app.entity.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class OrdenSaveDto {

	private Integer idOrden;
	private Short idProducto;
	private Short idRegion;
	private String tipoId;
	private Long numeroId;

	private Short idProductoInv;
	private Short idRegionInv;

	private String tipoIdCliente;
	private Long numeroIdCliente;

	private String idPeriodo;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaRegistro;

	private String estado;

	private String tipoIdClienteCal;
	private Long numeroIdClienteCal;

	private Short calificacion;

	private Short cantidad;

	private String tipoIdRep;

	private Long numeroIdRep;

	public OrdenSaveDto() {

	}

	public OrdenSaveDto(Integer idOrden, Short idProducto, Short idRegion, String tipoId, Long numeroId,
			Short idProductoInv, Short idRegionInv, String tipoIdCliente, Long numeroIdCliente, String idPeriodo,
			Date fechaRegistro, String estado, String tipoIdClienteCal, Long numeroIdClienteCal, Short calificacion,
			Short cantidad, String tipoIdRep, Long numeroIdRep) {
		super();
		this.idOrden = idOrden;
		this.idProducto = idProducto;
		this.idRegion = idRegion;
		this.tipoId = tipoId;
		this.numeroId = numeroId;
		this.idProductoInv = idProductoInv;
		this.idRegionInv = idRegionInv;
		this.tipoIdCliente = tipoIdCliente;
		this.numeroIdCliente = numeroIdCliente;
		this.idPeriodo = idPeriodo;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.tipoIdClienteCal = tipoIdClienteCal;
		this.numeroIdClienteCal = numeroIdClienteCal;
		this.calificacion = calificacion;
		this.cantidad = cantidad;
		this.tipoIdRep = tipoIdRep;
		this.numeroIdRep = numeroIdRep;
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

	public Short getIdProductoInv() {
		return idProductoInv;
	}

	public void setIdProductoInv(Short idProductoInv) {
		this.idProductoInv = idProductoInv;
	}

	public Short getIdRegionInv() {
		return idRegionInv;
	}

	public void setIdRegionInv(Short idRegionInv) {
		this.idRegionInv = idRegionInv;
	}

	public String getTipoIdCliente() {
		return tipoIdCliente;
	}

	public void setTipoIdCliente(String tipoIdCliente) {
		this.tipoIdCliente = tipoIdCliente;
	}

	public Long getNumeroIdCliente() {
		return numeroIdCliente;
	}

	public void setNumeroIdCliente(Long numeroIdCliente) {
		this.numeroIdCliente = numeroIdCliente;
	}

	public String getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoIdClienteCal() {
		return tipoIdClienteCal;
	}

	public void setTipoIdClienteCal(String tipoIdClienteCal) {
		this.tipoIdClienteCal = tipoIdClienteCal;
	}

	public Long getNumeroIdClienteCal() {
		return numeroIdClienteCal;
	}

	public void setNumeroIdClienteCal(Long numeroIdClienteCal) {
		this.numeroIdClienteCal = numeroIdClienteCal;
	}

	public Short getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Short calificacion) {
		this.calificacion = calificacion;
	}

	public Short getCantidad() {
		return cantidad;
	}

	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipoIdRep() {
		return tipoIdRep;
	}

	public void setTipoIdRep(String tipoIdRep) {
		this.tipoIdRep = tipoIdRep;
	}

	public Long getNumeroIdRep() {
		return numeroIdRep;
	}

	public void setNumeroIdRep(Long numeroIdRep) {
		this.numeroIdRep = numeroIdRep;
	}

}
