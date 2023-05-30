package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name = "CLIENTE")
public class Cliente {
	
    @EmbeddedId
    private ClienteId id;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID", referencedColumnName = "K_TIPO_ID", nullable = false),
            @JoinColumn(name = "K_NUMERO_ID", referencedColumnName = "K_NUMERO_ID", nullable = false)
    })
    private Persona persona;

    @NotNull
    @Column(name = "Q_CUENTA", nullable = false)
    private Long qCuenta;

    @MapsId("id")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "I_TIPO_ID_REP", referencedColumnName = "K_TIPO_ID", nullable = false),
            @JoinColumn(name = "Q_NUMERO_ID_REP", referencedColumnName = "K_NUMERO_ID", nullable = false)
    })
    private RepresentanteVenta representanteVentas;

}