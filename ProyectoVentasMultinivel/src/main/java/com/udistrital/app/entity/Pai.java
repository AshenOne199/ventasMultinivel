package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PAIS")
public class Pai {
    @Id
    @Column(name = "K_IDPAIS", nullable = false)
    private Short id;

    @Size(max = 50)
    @NotNull
    @Column(name = "N_NOMBRE", nullable = false, length = 50)
    private String nNombre;

}