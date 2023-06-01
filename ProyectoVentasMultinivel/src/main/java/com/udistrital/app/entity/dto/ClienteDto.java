package com.udistrital.app.entity.dto;

import com.udistrital.app.entity.ClienteId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	private ClienteId id;
	private String nombreCompleto;
	private String apellidoCompleto;
}
