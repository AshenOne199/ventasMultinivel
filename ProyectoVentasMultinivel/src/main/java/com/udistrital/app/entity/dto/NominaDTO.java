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
        name = "NominaDTO.findNomina",
        procedureName = "PR_NOMINA",
        resultClasses = NominaDTO.class,
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="P_CURSOR", type=void.class)
    })
})
public class NominaDTO {
	
	@Id
	@GeneratedValue
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "CARGO")
	private String cargo;
	
	@Column(name = "NUM_VENTAS")
	private String numVentas;
	
	@Column(name = "CALIFICACION")
	private String calificacion;
	
	@Column(name = "COMISION_TOTAL")
	private String comision;
	
	@Column(name = "ESTADO")
	private String estado;

}
