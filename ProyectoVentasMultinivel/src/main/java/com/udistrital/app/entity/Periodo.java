package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PERIODO")
public class Periodo {
    @Id
    @Size(max = 50)
    @Column(name = "K_IDPERIODO", nullable = false, length = 50)
    private String kIdperiodo;

    @NotNull
    @Column(name = "F_FECHAINICIO", nullable = false)
    private LocalDate fFechainicio;

    @NotNull
    @Column(name = "F_FECHAFIN", nullable = false)
    private LocalDate fFechafin;

    @NotNull
    @Column(name = "Q_COMISION", nullable = false, precision = 4, scale = 2)
    private BigDecimal qComision;

}