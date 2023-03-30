package com.udistrital.app.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ORDEN")
public class Orden {

	@EmbeddedId
	private OrdenId id;

	@MapsId("id")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "K_IDPRODUCTO", referencedColumnName = "K_IDPRODUCTO", nullable = false),
			@JoinColumn(name = "K_IDREGION", referencedColumnName = "K_IDREGION", nullable = false) })
	private Inventario inventario;


	@MapsId("id")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "K_TIPO_ID", referencedColumnName = "K_TIPO_ID", nullable = false),
			@JoinColumn(name = "K_NUMERO_ID", referencedColumnName = "K_NUMERO_ID", nullable = false) })
	private Cliente cliente;


	@MapsId("id")
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "K_IDPERIODO", nullable = false)
	private Periodo idPeriodo;

	@Column(name = "F_FECHAREGISTRO")
	private LocalDate fechaRegistro;

	@Size(max = 100)
	@NotNull
	@Column(name = "I_ESTADO", nullable = false, length = 100)
	private String estado;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "K_TIPO_ID_CALIF", referencedColumnName = "K_TIPO_ID"),
			@JoinColumn(name = "K_NUMERO_ID_CALIF", referencedColumnName = "K_NUMERO_ID") })
	private Cliente clienteCalifica;

	@Column(name = "Q_CALIFICACION")
	private Short calificacion;

	@NotNull
	@Column(name = "Q_CANTIDAD", nullable = false)
	private Short cantidad;

	@Size(max = 3)
	@Column(name = "I_TIPO_ID_REP", length = 3)
	private String tipoIdRep;

	@Column(name = "Q_NUMERO_ID_REP")
	private Long numeroIdRep;

	public Orden() {

	}

	public Orden(OrdenId id, Inventario inventario, Cliente cliente, @NotNull Periodo idPeriodo,
			LocalDate fechaRegistro, @Size(max = 100) @NotNull String estado, Cliente clienteCalifica,
			Short calificacion, @NotNull Short cantidad, @Size(max = 3) String tipoIdRep, Long numeroIdRep) {
		super();
		this.id = id;
		this.inventario = inventario;
		this.cliente = cliente;
		this.idPeriodo = idPeriodo;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.clienteCalifica = clienteCalifica;
		this.calificacion = calificacion;
		this.cantidad = cantidad;
		this.tipoIdRep = tipoIdRep;
		this.numeroIdRep = numeroIdRep;
	}

	public OrdenId getId() {
		return id;
	}

	public void setId(OrdenId id) {
		this.id = id;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Periodo getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Periodo idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getClienteCalifica() {
		return clienteCalifica;
	}

	public void setClienteCalifica(Cliente clienteCalifica) {
		this.clienteCalifica = clienteCalifica;
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