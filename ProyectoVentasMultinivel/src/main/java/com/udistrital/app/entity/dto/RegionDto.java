package com.udistrital.app.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionDTO {

    private Short idRegion;
    private String nombrePais;
    private String nombreRegion;

}
