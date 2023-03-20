package com.udistrital.app.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udistrital.app.entity.compositehandle.RepresentanteVentasPrimaryKey;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "REPRESENTANTE_VENTAS")
public class RepresentanteVentas {

	// llave compuesta
	@EmbeddedId
	private RepresentanteVentasPrimaryKey compositeKey;

	@Column(name = "n_nombrecompleto", nullable = false)
	private String nombreCompleto;

	@Column(name = "n_apellidocompleto", nullable = false)
	private String apellidoCompleto;

	@Column(name = "f_fechacreacion", nullable = false)
	@JsonFormat(pattern = "dd/MM/yy")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@Column(name = "o_email", nullable = false)
	private String email;

	@Column(name = "q_telefono", nullable = false)
	private Integer telefono;

	@Column(name = "n_region", nullable = false)
	private String nombreRegion;

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

	@Column(name = "f_fechacontrato", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaContrato;

	@Column(name = "i_tipo", nullable = false)
	private String tipoCargo;

	// Mapping uno a muchos de representante a representante jefe
	@JsonIgnore
	@OneToMany(mappedBy = "jefe", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<RepresentanteVentas> empleados = new HashSet<>();

	// Mapping muchos a uno de representante a representante jefe

	@JsonIgnore
	@ManyToOne
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumns({ @JoinColumn(name = "k_tipo_id_jefe", referencedColumnName = "k_tipo_id"),
			@JoinColumn(name = "k_numero_id_jefe", referencedColumnName = "k_numero_id") })
	public RepresentanteVentas jefe;

}
