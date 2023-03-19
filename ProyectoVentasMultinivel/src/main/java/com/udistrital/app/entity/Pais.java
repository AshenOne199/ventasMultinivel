package com.udistrital.app.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "PAIS")
public class Pais {
	
	@Id
	@Column(name = "K_IDPAIS")
	private Integer idPais;
	
	@Column(name = "N_NOMBRE")
	private String nombrePais;
	
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private Set<Region> regiones;
	

}
