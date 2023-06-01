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
        name = "ProductosTopDTO.findTopProductos",
        procedureName = "PR_TOP_PRODUCTO",
        resultClasses = ProductosTopDTO.class,
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="L_IDPERIODO", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="P_CURSOR", type=void.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="pm_error", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.OUT, name="pc_error", type=String.class)
    })
})
public class ProductosTopDTO {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCTO")
	private String producto;
	
	@Column(name = "VENDIDO")
	private String vendido;
	
	@Column(name = "pm_error")
	private String pm_error;
	
	@Column(name = "pc_error")
	private String pc_error;
	
	
}
