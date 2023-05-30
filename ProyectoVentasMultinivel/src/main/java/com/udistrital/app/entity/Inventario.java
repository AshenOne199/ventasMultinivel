package com.udistrital.app.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INVENTARIO")
public class Inventario {
	
    @EmbeddedId
    private InventarioId id;

    
    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "K_IDPRODUCTO", nullable = false)
    private Producto kIdproducto;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "K_IDREGION", nullable = false)
    private Region kIdregion;

    @NotNull
    @Column(name = "Q_STOCK", nullable = false)
    private Short qStock;

    @NotNull
    @Column(name = "V_PRECIOPRODUCTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal vPrecioproducto;

}