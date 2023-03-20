package com.udistrital.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGION")
public class Region {

	@Id
    @Column(name = "K_IDREGION")
    private Long idRegion;

    @Column(name = "N_NOMBRE")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "K_IDPAIS")
    private Pais pais;
 
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventario> inventarios = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "INVENTARIO",
        joinColumns = @JoinColumn(name = "K_IDREGION"),
        inverseJoinColumns = @JoinColumn(name = "K_IDPRODUCTO")
    )
    private List<Producto> productos = new ArrayList<>();
    
    public Region() {
    	
    }
    
	public Region(Long idRegion, String nombre, Pais pais, List<Inventario> inventarios, List<Producto> productos) {
		super();
		this.idRegion = idRegion;
		this.nombre = nombre;
		this.pais = pais;
		this.inventarios = inventarios;
		this.productos = productos;
	}

	public Long getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Long idRegion) {
		this.idRegion = idRegion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Inventario> getInventarios() {
		return inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
