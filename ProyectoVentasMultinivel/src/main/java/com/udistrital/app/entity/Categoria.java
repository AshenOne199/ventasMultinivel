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
@Table(name = "CATEGORIA")
public class Categoria {

	@Id
	@Column(name = "K_IDCATEGORIA")
	private Integer idCategoria;
	
	@Column(name = "K_IDSUBCATEGORIA")
	private Integer idSubCategoria;
	
	@Column(name = "N_NOMBRE")
	private String nombreCategoria;
	
}
