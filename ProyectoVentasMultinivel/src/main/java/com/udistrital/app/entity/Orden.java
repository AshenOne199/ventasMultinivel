package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ORDEN")
public class Orden {
    @EmbeddedId
    private OrdenId id;

    @Size(max = 30)
    @NotNull
    @Column(name = "K_IDPERIODO", nullable = false, length = 30)
    private String kIdperiodo;

    @NotNull
    @Column(name = "F_FECHAREGISTRO", nullable = false)
    private LocalDate fFecharegistro;

    @Size(max = 20)
    @NotNull
    @Column(name = "I_ESTADO", nullable = false, length = 20)
    private String iEstado;

    @Size(max = 3)
    @Column(name = "K_TIPO_ID_CALIF", length = 3)
    private String kTipoIdCalif;

    @Column(name = "K_NUMERO_ID_CALIF")
    private Long kNumeroIdCalif;

    @Column(name = "Q_CALIFICACION")
    private Boolean qCalificacion;

    @NotNull
    @Column(name = "Q_CANTIDAD", nullable = false)
    private Short qCantidad;

    @Size(max = 3)
    @Column(name = "I_TIPO_ID_REP", length = 3)
    private String iTipoIdRep;

    @Column(name = "Q_NUMERO_ID_REP")
    private Long qNumeroIdRep;

}