package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
	
    @Id
    @Column(name = "K_IDCATEGORIA", nullable = false)
    private Short id;

    @Column(name = "K_IDSUBCATEGORIA")
    private Short idSubcategoria;

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

	public Short getkIdsubcategoria() {
		return idSubcategoria;
	}

	public void setkIdsubcategoria(Short kIdsubcategoria) {
		this.idSubcategoria = kIdsubcategoria;
	}

	public String getnNombre() {
		return nombre;
	}

	public void setnNombre(String nNombre) {
		this.nombre = nNombre;
	}
    
    

}