package com.udistrital.app.entity.compositehandle;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class RepresentanteVentasPrimaryKey implements Serializable {
	@Column(name = "k_tipo_id", nullable = false)
	private String tipoId;
	@Column(name = "k_numero_id", nullable = false)
	private Long numeroId;
}
