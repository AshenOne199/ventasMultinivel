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
@Table(name = "REPRESENTANTE_VENTAS")
public class RepresentanteVenta {
	
    @EmbeddedId
    private RepresentanteVentaId id;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID", referencedColumnName = "K_TIPO_ID", nullable = false),
            @JoinColumn(name = "K_NUMERO_ID", referencedColumnName = "K_NUMERO_ID", nullable = false)
    })
    private Persona persona;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID_JEFE", referencedColumnName = "K_TIPO_ID"),
            @JoinColumn(name = "K_NUMERO_ID_JEFE", referencedColumnName = "K_NUMERO_ID")
    })
    private RepresentanteVenta representanteVentas;

    @Size(max = 15)
    @NotNull
    @Column(name = "I_TIPO", nullable = false, length = 15)
    private String iTipo;

    @Size(max = 15)
    @NotNull
    @Column(name = "I_ESTADO", nullable = false, length = 15)
    private String iEstado;

}