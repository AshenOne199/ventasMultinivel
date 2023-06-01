package com.udistrital.app.entity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenIdDto {

    private Integer idOrden;


    private Short idProducto;


    private Short idRegion;


    private String tipoId;


    private Long numeroId;

}
