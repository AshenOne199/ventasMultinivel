package com.udistrital.app.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRVDto {

	private String tipoIdCliente;
	private Long idCliente;

	private String tipoIdRV;
	private Long idRV;
}
