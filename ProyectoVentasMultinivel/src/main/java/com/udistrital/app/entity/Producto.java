package com.udistrital.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
 
    @Id
    @Column(name = "K_IDPRODUCTO")
    private Long idProducto;
 
    @Column(name = "N_NOMBRE")
    private String nombre;
 
    @Column(name = "N_URLIMAGEN")
    private String urlImagen;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "K_IDCATEGORIA")
    private Categoria categoria;
 
    @ManyToMany(mappedBy = "productos")
    private List<Region> regiones = new ArrayList<>();
 
    public Producto() {
		
	}

	public Producto(Long idProducto, String nombre, String urlImagen, Categoria categoria, List<Region> regiones) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
		this.categoria = categoria;
		this.regiones = regiones;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Region> getRegiones() {
		return regiones;
	}

	public void setRegiones(List<Region> regiones) {
		this.regiones = regiones;
	}
    
    
}

