package com.udistrital.app.entity.compositehandle;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ClientePrimaryKey implements Serializable {
	@Column(name = "k_tipo_id", nullable = false)
	private String tipoId;
	@Column(name = "k_numero_id", nullable = false)
	private Long numeroId;
}
