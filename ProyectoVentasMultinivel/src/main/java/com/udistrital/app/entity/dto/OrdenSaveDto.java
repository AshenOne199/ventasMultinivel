package com.udistrital.app.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenSaveDto {

	private Integer idOrden;
	private Short idProducto;
	private Short idRegion;
	private String tipoId;
	private Long numeroId;

	private Short idProductoInv;
	private Short idRegionInv;

	private String tipoIdCliente;
	private Long numeroIdCliente;

	private String idPeriodo;

	private String fechaRegistro;

	private String estado;

	private String tipoIdClienteCal;
	private Long numeroIdClienteCal;

	private Short calificacion;

	private Short cantidad;

	private String tipoIdRep;

	private Long numeroIdRep;


}
