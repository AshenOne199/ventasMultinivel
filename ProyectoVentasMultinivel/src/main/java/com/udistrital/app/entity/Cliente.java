package com.udistrital.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "CLIENTE")
public class Cliente {
	
    @EmbeddedId
    private ClienteId id;

    @JsonIgnore
    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID", referencedColumnName = "K_TIPO_ID", nullable = false),
            @JoinColumn(name = "K_NUMERO_ID", referencedColumnName = "K_NUMERO_ID", nullable = false)
    })
    private Persona persona;

    @JsonIgnore
    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "I_TIPO_ID_REP", referencedColumnName = "K_TIPO_ID", nullable = false),
            @JoinColumn(name = "Q_NUMERO_ID_REP", referencedColumnName = "K_NUMERO_ID", nullable = false)
    })
    private RepresentanteVenta representanteVentas;

    @Column(name = "Q_CUENTA", nullable = false)
    private Long cuenta;
    
}