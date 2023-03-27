package com.udistrital.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ORDEN")
public class Orden {
	@Id
	@Column(name = "K_IDORDEN", nullable = false)
	private Integer id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "K_IDPRODUCTO", referencedColumnName = "K_IDPRODUCTO", nullable = false),
			@JoinColumn(name = "K_IDREGION", referencedColumnName = "K_IDREGION", nullable = false) })
	private Inventario inventario;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "K_IDPERIODO", nullable = false)
	private Periodo kIdperiodo;

	@Column(name = "F_FECHAREGISTRO")
	private LocalDate fechaRegistro;

	@Size(max = 100)
	@NotNull
	@Column(name = "I_ESTADO", nullable = false, length = 100)
	private String estado;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "K_TIPO_ID", referencedColumnName = "K_TIPO_ID", nullable = false),
			@JoinColumn(name = "K_NUMERO_ID", referencedColumnName = "K_NUMERO_ID", nullable = false) })
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "K_TIPO_ID_CALIF", referencedColumnName = "K_TIPO_ID"),
			@JoinColumn(name = "K_NUMERO_ID_CALIF", referencedColumnName = "K_NUMERO_ID") })
	private Cliente clienteCalifica;

	@Column(name = "Q_CALIFICACION")
	private Boolean calificacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Periodo getkIdperiodo() {
		return kIdperiodo;
	}

	public void setkIdperiodo(Periodo kIdperiodo) {
		this.kIdperiodo = kIdperiodo;
	}

	public LocalDate getfFecharegistro() {
		return fechaRegistro;
	}

	public void setfFecharegistro(LocalDate fFecharegistro) {
		this.fechaRegistro = fFecharegistro;
	}

	public String getiEstado() {
		return estado;
	}

	public void setiEstado(String iEstado) {
		this.estado = iEstado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente1() {
		return clienteCalifica;
	}

	public void setCliente1(Cliente cliente1) {
		this.clienteCalifica = cliente1;
	}

	public Boolean getqCalificacion() {
		return calificacion;
	}

	public void setqCalificacion(Boolean qCalificacion) {
		this.calificacion = qCalificacion;
	}

}