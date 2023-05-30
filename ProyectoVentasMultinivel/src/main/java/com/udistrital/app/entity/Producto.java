package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @Column(name = "K_IDPRODUCTO", nullable = false)
    private Short id;

    @NotNull
    @Column(name = "K_IDCATEGORIA", nullable = false)
    private Short kIdcategoria;

    @Size(max = 80)
    @NotNull
    @Column(name = "N_NOMBRE", nullable = false, length = 80)
    private String nNombre;

    @Size(max = 200)
    @NotNull
    @Column(name = "N_URLIMAGEN", nullable = false, length = 200)
    private String nUrlimagen;

}