package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "REGION")
public class Region {
	
	@Id
	@Column(name = "K_IDREGION")
	private Integer idRegion;
	
	@ManyToOne
    @JoinColumn(name = "K_IDPAIS")
    private Pais pais;
	
	@Column(name = "N_NOMBRE")
	private String nombreRegion;
	
}
