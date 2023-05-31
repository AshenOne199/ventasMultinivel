package com.udistrital.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERIODO")
public class Periodo {
	
    @Id
    @Size(max = 50)
    @Column(name = "K_IDPERIODO", nullable = false, length = 50)
    private String idPeriodo;

    @Column(name = "F_FECHAINICIO", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "F_FECHAFIN", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "Q_COMISION", nullable = false, precision = 4, scale = 2)
    private BigDecimal comision;

}