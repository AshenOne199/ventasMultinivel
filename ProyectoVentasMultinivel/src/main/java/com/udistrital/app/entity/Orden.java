package com.udistrital.app.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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
@Table(name = "ORDEN")
public class Orden {
	
    @EmbeddedId
    private OrdenId id;

    @JsonIgnore
    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "K_IDPRODUCTO", referencedColumnName = "K_IDPRODUCTO", nullable = false),
            @JoinColumn(name = "K_IDREGION", referencedColumnName = "K_IDREGION", nullable = false)
    })
    private Inventario inventario;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID", referencedColumnName = "K_TIPO_ID", nullable = false),
            @JoinColumn(name = "K_NUMERO_ID", referencedColumnName = "K_NUMERO_ID", nullable = false)
    })
    private Cliente cliente;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "K_IDPERIODO", nullable = false)
    private Periodo idPeriodo;

    @Column(name = "F_FECHAREGISTRO", nullable = false)
    private LocalDate fechaRegistro;

    @Size(max = 20)
    @Column(name = "I_ESTADO", nullable = false, length = 20)
    private String estado;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID_CALIF", referencedColumnName = "K_TIPO_ID"),
            @JoinColumn(name = "K_NUMERO_ID_CALIF", referencedColumnName = "K_NUMERO_ID")
    })
    private Cliente clienteCalifica;

    @Column(name = "Q_CALIFICACION")
    private Short calificacion;

    @Column(name = "Q_CANTIDAD", nullable = false)
    private Short cantidad;

    @Size(max = 3)
    @Column(name = "I_TIPO_ID_REP", length = 3)
    private String tipoIdRep;

    @Column(name = "Q_NUMERO_ID_REP")
    private Long numeroIdRep;

}