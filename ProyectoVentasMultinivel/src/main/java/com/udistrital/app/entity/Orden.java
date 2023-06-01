package com.udistrital.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "ORDEN")
public class Orden {
	
    @EmbeddedId
    private OrdenId id;

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
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "K_IDPERIODO", nullable = false)
    private Periodo kIdperiodo;

    @NotNull
    @Column(name = "F_FECHAREGISTRO", nullable = false)
    private LocalDate fFecharegistro;

    @Size(max = 20)
    @NotNull
    @Column(name = "I_ESTADO", nullable = false, length = 20)
    private String iEstado;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID_CALIF", referencedColumnName = "K_TIPO_ID"),
            @JoinColumn(name = "K_NUMERO_ID_CALIF", referencedColumnName = "K_NUMERO_ID")
    })
    private Cliente cliente1;

    @Column(name = "Q_CALIFICACION")
    private Short qCalificacion;

    @NotNull
    @Column(name = "Q_CANTIDAD", nullable = false)
    private Short qCantidad;

    @Size(max = 3)
    @Column(name = "I_TIPO_ID_REP", length = 3)
    private String iTipoIdRep;

    @Column(name = "Q_NUMERO_ID_REP")
    private Long qNumeroIdRep;

}