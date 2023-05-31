package com.udistrital.app.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "RepresentantesTopDTO.findTopRepresentantes",
        procedureName = "PR_TOP_RV",
        resultClasses = RepresentantesTopDTO.class,
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="L_IDPERIODO", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="P_CURSOR", type=void.class)
    })
})
public class RepresentantesTopDTO {
	
	@Id
	@GeneratedValue
	@Column(name = "REPRESENTANTE")
	private String nombreCompleto;
	
	@Column(name = "PRODUCTO")
	private String cantidad;
	
	@Column(name = "PERIODO")
	private String periodo;

}
