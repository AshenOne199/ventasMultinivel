package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "REGION")
public class Region {
	@Id
	@Column(name = "K_IDREGION", nullable = false)
	private Short id;

	@MapsId("id")
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "K_IDPAIS", nullable = false)
	private Pais idPais;

	@Size(max = 50)
	@NotNull
	@Column(name = "N_NOMBRE", nullable = false, length = 50)
	private String nombre;

	public Region() {
		
	}
	
	public Region(Short id, @NotNull Pais idPais, @Size(max = 50) @NotNull String nombre) {
		super();
		this.id = id;
		this.idPais = idPais;
		this.nombre = nombre;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Pais getkIdpais() {
		return idPais;
	}

	public void setkIdpais(Pais kIdpais) {
		this.idPais = kIdpais;
	}

	public String getnNombre() {
		return nombre;
	}

	public void setnNombre(String nNombre) {
		this.nombre = nNombre;
	}

}