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

@Entity
@DynamicUpdate
@Table(name = "CLIENTE")
public class Cliente {

	//Llave compuesta
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
	private Integer telefono;

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
	private Integer numeroIdRepActual;

	@Column(name = "i_tipo_id_rep", nullable = false)
	private String tipoIdRepInicial;

	@Column(name = "q_numero_id_rep", nullable = false)
	private Integer numeroIdRepInicial;
	
	public Cliente() {
		
	}
	
	public Cliente(ClientePrimaryKey compositeKey, String nombreCompleto, String apellidoCompleto, Date fechaCreacion,
			String email, Integer telefono, String nombreCiudad, String genero, String password, Date fechaNacimiento,
			String direccion, String tipoIdRepActual, Integer numeroIdRepActual, String tipoIdRepInicial,
			Integer numeroIdRepInicial) {
		super();
		this.compositeKey = compositeKey;
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
		this.fechaCreacion = fechaCreacion;
		this.email = email;
		this.telefono = telefono;
		this.nombreCiudad = nombreCiudad;
		this.genero = genero;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.tipoIdRepActual = tipoIdRepActual;
		this.numeroIdRepActual = numeroIdRepActual;
		this.tipoIdRepInicial = tipoIdRepInicial;
		this.numeroIdRepInicial = numeroIdRepInicial;
	}

	public ClientePrimaryKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(ClientePrimaryKey compositeKey) {
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

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
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

	public String getTipoIdRepActual() {
		return tipoIdRepActual;
	}

	public void setTipoIdRepActual(String tipoIdRepActual) {
		this.tipoIdRepActual = tipoIdRepActual;
	}

	public Integer getNumeroIdRepActual() {
		return numeroIdRepActual;
	}

	public void setNumeroIdRepActual(Integer numeroIdRepActual) {
		this.numeroIdRepActual = numeroIdRepActual;
	}

	public String getTipoIdRepInicial() {
		return tipoIdRepInicial;
	}

	public void setTipoIdRepInicial(String tipoIdRepInicial) {
		this.tipoIdRepInicial = tipoIdRepInicial;
	}

	public Integer getNumeroIdRepInicial() {
		return numeroIdRepInicial;
	}

	public void setNumeroIdRepInicial(Integer numeroIdRepInicial) {
		this.numeroIdRepInicial = numeroIdRepInicial;
	}
	
	

}
