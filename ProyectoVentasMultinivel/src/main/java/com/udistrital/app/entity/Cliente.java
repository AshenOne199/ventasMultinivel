package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "CLIENTE")
public class Cliente {
    @EmbeddedId
    private ClienteId id;

    @NotNull
    @Column(name = "Q_CUENTA", nullable = false)
    private Long qCuenta;

    @Size(max = 3)
    @NotNull
    @Column(name = "I_TIPO_ID_REP", nullable = false, length = 3)
    private String iTipoIdRep;

    @NotNull
    @Column(name = "Q_NUMERO_ID_REP", nullable = false)
    private Long qNumeroIdRep;

}