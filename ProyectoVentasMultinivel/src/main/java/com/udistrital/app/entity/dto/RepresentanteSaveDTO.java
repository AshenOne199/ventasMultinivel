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
public class RepresentanteSaveDTO {

	private String tipoId;
	private Long numeroId;

	private String tipoIdJefe;
	private Long numeroIdJefe;

	private String nombreCompleto;
	private String apellidoCompleto;

	private String email;
	
	private Long telefono;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaCreacion;
	
	private String region;
	
	private String genero;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fNacimiento;
	
	private String direccion;
	
	private String tipo;
	
	private String estado;
	
}
