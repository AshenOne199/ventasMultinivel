package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "PRODUCTO")
public class Producto {
	
	@Id
	@Column(name = "K_IDPRODUCTO")
	private Integer idProducto;
	
	@Column(name = "K_IDCATEGORIA")
	private Integer idCategoria;
	
	@Column(name = "N_NOMBRE")
	private String nombreProducto;
	
	@Column(name = "N_URLIMAGEN")
	private String urlImagen;

}
