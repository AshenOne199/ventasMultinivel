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


@Entity
@DynamicUpdate
@Table(name = "REPRESENTANTE_VENTAS")
public class RepresentanteVentas {

	// Llave compuesta
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
	
	public RepresentanteVentas() {
		
	}

	public RepresentanteVentas(RepresentanteVentasPrimaryKey compositeKey, String nombreCompleto,
			String apellidoCompleto, Date fechaCreacion, String email, Integer telefono, String nombreRegion,
			String genero, String password, Date fechaNacimiento, String direccion, Date fechaContrato,
			String tipoCargo, Set<RepresentanteVentas> empleados, RepresentanteVentas jefe) {
		super();
		this.compositeKey = compositeKey;
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
		this.fechaCreacion = fechaCreacion;
		this.email = email;
		this.telefono = telefono;
		this.nombreRegion = nombreRegion;
		this.genero = genero;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.fechaContrato = fechaContrato;
		this.tipoCargo = tipoCargo;
		this.empleados = empleados;
		this.jefe = jefe;
	}

	public RepresentanteVentasPrimaryKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(RepresentanteVentasPrimaryKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getApellidoCompleto() {
		return apellidoCompleto;
	}

	public void setApellidoCompleto(String apellidoCompleto) {
		this.apellidoCompleto = apellidoCompleto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(String tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public Set<RepresentanteVentas> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<RepresentanteVentas> empleados) {
		this.empleados = empleados;
	}

	public RepresentanteVentas getJefe() {
		return jefe;
	}

	public void setJefe(RepresentanteVentas jefe) {
		this.jefe = jefe;
	}
	
	
	

}
