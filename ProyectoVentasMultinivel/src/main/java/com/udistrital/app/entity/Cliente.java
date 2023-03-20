package com.udistrital.app.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udistrital.app.entity.compositehandle.ClientePrimaryKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "CLIENTE")
public class Cliente {

	// llave compuesta
	@EmbeddedId
	private ClientePrimaryKey compositeKey;

	@Column(name = "n_nombrecompleto", nullable = false)
	private String nombreCompleto;

	@Column(name = "n_apellidocompleto", nullable = false)
	private String apellidoCompleto;

	@Column(name = "f_fechacreacion", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaCreacion;

	@Column(name = "o_email", nullable = false)
	private String email;

	@Column(name = "q_telefono", nullable = false)
	private Long telefono;

	@Column(name = "n_ciudad", nullable = false)
	private String nombreCiudad;

	@Column(name = "i_genero", nullable = false)
	private String genero;

	@Column(name = "o_password", nullable = false)
	private String password;

	@Column(name = "f_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaNacimiento;

	@Column(name = "o_direccion", nullable = false)
	private String direccion;

	// Mapping uno a uno de cliente a representante actual

	@Column(name = "k_tipo_id_rep", nullable = false)
	private String tipoIdRepActual;

	@Column(name = "k_id_numero_rep", nullable = false)
	private Long numeroIdRepActual;

	@Column(name = "i_tipo_id_rep", nullable = false)
	private String tipoIdRepInicial;

	@Column(name = "q_numero_id_rep", nullable = false)
	private Integer numeroIdRepInicial;

}
