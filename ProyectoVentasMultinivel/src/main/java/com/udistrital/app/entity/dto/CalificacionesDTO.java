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
        name = "CalificacionesDTO.findCalificaciones",
        procedureName = "PR_CALIFICACIONES",
        resultClasses = CalificacionesDTO.class,
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="L_IDPERIODO", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="P_CURSOR", type=void.class)
    })
})
public class CalificacionesDTO {
	
	@Id
	@GeneratedValue
	@Column(name = "CLIENTE")
	private String cliente;
	
	@Column(name = "CALIFICACION")
	private String calificacion;

	@Column(name = "FECHA")
	private String fecha;
	
	@Column(name = "TIPO_ID")
	private String tipoId;
	
	@Column(name = "NUMERO_ID")
	private String numeroId;
}
