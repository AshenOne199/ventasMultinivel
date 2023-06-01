package com.udistrital.app.entity.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSaveDto {

	private String tipoId;
	private Long numeroId;

	private String tipoIdRep;
	private Long numeroIdRep;

	private String nombreCompleto;
	private String apellidoCompleto;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaCreacion;
	
	private String email;
	private Long telefono;
	private String ciudad;
	private String genero;
	private Long cuenta;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fNacimiento;
	private String direccion;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaContrato;

}
