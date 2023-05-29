package com.udistrital.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PERIODO")
public class Periodo {
	@Id
	@Size(max = 50)
	@Column(name = "K_IDPERIODO", nullable = false, length = 50)
	private String id;

	@NotNull
	@Column(name = "F_FECHAINICIO", nullable = false)
	private LocalDate fechaInicio;

	@NotNull
	@Column(name = "F_FECHAFIN", nullable = false)
	private LocalDate fechaFin;
	
	@NotNull
	@Column(name = "Q_COMISION", nullable = false, length = 50)
	private String comision;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

}