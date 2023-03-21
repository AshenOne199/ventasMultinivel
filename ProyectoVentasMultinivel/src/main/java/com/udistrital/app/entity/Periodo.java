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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getfFechainicio() {
		return fechaInicio;
	}

	public void setfFechainicio(LocalDate fFechainicio) {
		this.fechaInicio = fFechainicio;
	}

	public LocalDate getfFechafin() {
		return fechaFin;
	}

	public void setfFechafin(LocalDate fFechafin) {
		this.fechaFin = fFechafin;
	}

    
    
    
}