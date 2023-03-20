package com.udistrital.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAIS")
public class Pais {

	@Id
    @Column(name = "K_IDPAIS")
    private Long idPais;
    
    @Column(name = "N_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Region> regiones = new ArrayList<>();
    
    public Pais() {
    	
	}

	public Pais(Long idPais, String nombre, List<Region> regiones) {
		super();
		this.idPais = idPais;
		this.nombre = nombre;
		this.regiones = regiones;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Region> getRegiones() {
		return regiones;
	}

	public void setRegiones(List<Region> regiones) {
		this.regiones = regiones;
	}
	
	

}
