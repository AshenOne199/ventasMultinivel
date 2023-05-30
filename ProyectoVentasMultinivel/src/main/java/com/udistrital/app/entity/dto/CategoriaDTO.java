package com.udistrital.app.entity.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

	private Short id;

	private String nombreCategoria;
	
	private BigDecimal iva;


}