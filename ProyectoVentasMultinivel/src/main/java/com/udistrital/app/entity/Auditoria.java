package com.udistrital.app.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "AUDITORIA")
public class Auditoria {
	
    @Id
    @Column(name = "K_ID", nullable = false)
    private Short id;

    @Size(max = 50)
    @NotNull
    @Column(name = "N_TABLA", nullable = false, length = 50)
    private String nTabla;

    @Column(name = "Q_CALIFICACION")
    private Boolean qCalificacion;

    @Column(name = "K_IDORDEN")
    private Integer kIdorden;

    @Column(name = "K_IDPRODUCTO")
    private Short kIdproducto;

    @Column(name = "K_IDREGION")
    private Short kIdregion;

    @Column(name = "Q_COMISION", precision = 4, scale = 2)
    private BigDecimal qComision;

    @Column(name = "K_NUMERO_ID_REP")
    private Long kNumeroIdRep;

    @Size(max = 3)
    @Column(name = "K_TIPO_ID_REP", length = 3)
    private String kTipoIdRep;

}