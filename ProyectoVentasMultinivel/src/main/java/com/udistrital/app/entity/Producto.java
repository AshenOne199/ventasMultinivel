package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	@Id
	@Column(name = "K_IDPRODUCTO", nullable = false)
	private Short id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "K_IDCATEGORIA", nullable = false)
	private Categoria idCategoria;

	@Size(max = 100)
	@NotNull
	@Column(name = "N_NOMBRE", nullable = false, length = 100)
	private String nombre;

	@Size(max = 200)
	@NotNull
	@Column(name = "N_URLIMAGEN", nullable = false, length = 200)
	private String urlImagen;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Categoria getkIdcategoria() {
		return idCategoria;
	}

	public void setkIdcategoria(Categoria kIdcategoria) {
		this.idCategoria = kIdcategoria;
	}

	public String getnNombre() {
		return nombre;
	}

	public void setnNombre(String nNombre) {
		this.nombre = nNombre;
	}

	public String getnUrlimagen() {
		return urlImagen;
	}

	public void setnUrlimagen(String nUrlimagen) {
		this.urlImagen = nUrlimagen;
	}

}