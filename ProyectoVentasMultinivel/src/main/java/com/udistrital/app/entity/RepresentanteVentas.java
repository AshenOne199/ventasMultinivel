package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "REPRESENTANTE_VENTAS")
public class RepresentanteVentas {
    @EmbeddedId
    private RepresentanteVentaId id;

    @Size(max = 3)
    @Column(name = "K_TIPO_ID_JEFE", length = 3)
    private String kTipoIdJefe;

    @Column(name = "K_NUMERO_ID_JEFE")
    private Long kNumeroIdJefe;

    @Size(max = 15)
    @NotNull
    @Column(name = "I_TIPO", nullable = false, length = 15)
    private String iTipo;

    @Size(max = 15)
    @NotNull
    @Column(name = "I_ESTADO", nullable = false, length = 15)
    private String iEstado;

}