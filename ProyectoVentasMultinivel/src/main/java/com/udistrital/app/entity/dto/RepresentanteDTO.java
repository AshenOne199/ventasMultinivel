package com.udistrital.app.entity.dto;

import com.udistrital.app.entity.RepresentanteVentaId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepresentanteDTO {

	private RepresentanteVentaId id;

	private String nombreCompleto;

	private String apellidoCompleto;
	
}
