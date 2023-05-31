package com.udistrital.app.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "ProductosTopDTO.findTopProductos",
        procedureName = "PR_TOPPRODUCTO",
        resultClasses = ProductosTopDTO.class,
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="L_IDPERIODO", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name="P_CURSOR", type=void.class)
    })
})
public class ProductosTopDTO {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCTO")
	private String producto;
	
	@Column(name = "VENDIDO")
	private String vendido;
	

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getVendido() {
		return vendido;
	}

	public void setVendido(String vendido) {
		this.vendido = vendido;
	}
	
}
