package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGION")
public class Region {

	@Id
	@Column(name = "K_IDREGION")
	private Integer idRegion;

	@Column(name = "K_IDPAIS")
	private Integer idPais;

	@Column(name = "N_NOMBRE")
	private String nombreRegion;

}
