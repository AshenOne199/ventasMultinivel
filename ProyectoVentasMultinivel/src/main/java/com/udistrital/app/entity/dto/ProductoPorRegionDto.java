package com.udistrital.app.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPorRegionDto {

	private Short id;
	private String nombreProducto;
	private Short stock;
	private BigDecimal precio;
	private String url;
}
