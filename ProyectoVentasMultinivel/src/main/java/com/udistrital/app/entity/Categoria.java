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

@Getter
@Setter
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @Column(name = "K_IDCATEGORIA", nullable = false)
    private Short id;

    @Column(name = "K_IDSUBCATEGORIA")
    private Short kIdsubcategoria;

    @Size(max = 50)
    @NotNull
    @Column(name = "N_NOMBRE", nullable = false, length = 50)
    private String nNombre;

    @NotNull
    @Column(name = "Q_IVA", nullable = false, precision = 4, scale = 2)
    private BigDecimal qIva;

}