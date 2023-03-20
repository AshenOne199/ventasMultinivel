package com.udistrital.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
 
    @Id
    @Column(name = "K_IDCATEGORIA")
    private Long idCategoria;
 
    @Column(name = "N_NOMBRE")
    private String nombre;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "K_IDSUBCATEGORIA")
    private Categoria subcategoria;
 
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public Categoria() {
		
	}
    
	public Categoria(Long idCategoria, String nombre, Categoria subcategoria, List<Producto> productos) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.subcategoria = subcategoria;
		this.productos = productos;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Categoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}