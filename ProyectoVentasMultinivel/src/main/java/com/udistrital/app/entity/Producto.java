package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "PRODUCTO")
public class Producto {
	
    @Id
    @Column(name = "K_IDPRODUCTO", nullable = false)
    private Short id;

    @MapsId("id")	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "K_IDCATEGORIA", nullable = false)
    private Categoria idCategoria;

    @Size(max = 80)
    @Column(name = "N_NOMBRE", nullable = false, length = 80)
    private String nombre;

    @Size(max = 200)
    @Column(name = "N_URLIMAGEN", nullable = false, length = 200)
    private String urlImagen;

}