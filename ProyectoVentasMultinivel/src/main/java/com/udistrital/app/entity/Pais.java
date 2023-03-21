package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PAIS")
public class Pais {
    @Id
    @Column(name = "K_IDPAIS", nullable = false)
    private Short id;

    @Size(max = 100)
    @NotNull
    @Column(name = "N_NOMBRE", nullable = false, length = 100)
    private String nombre;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getnNombre() {
		return nombre;
	}

	public void setnNombre(String nNombre) {
		this.nombre = nNombre;
	}

    
    
}