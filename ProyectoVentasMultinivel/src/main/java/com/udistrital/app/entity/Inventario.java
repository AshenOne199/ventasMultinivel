package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "INVENTARIO")
public class Inventario {
    @EmbeddedId
    private InventarioId id;

    @NotNull
    @Column(name = "Q_STOCK", nullable = false)
    private Short qStock;

    @NotNull
    @Column(name = "V_PRECIOPRODUCTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal vPrecioproducto;

}