package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "PAIS")
public class Pais {
	
    @Id
    @Column(name = "K_IDPAIS", nullable = false)
    private Short id;

    @Size(max = 50)
    @Column(name = "N_NOMBRE", nullable = false, length = 50)
    private String nombre;

}