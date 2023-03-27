package com.udistrital.app.entity.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class ClienteSaveDto {

	private String tipoId;
	private Long numeroId;

	private String tipoIdRep;
	private Long numeroIdRep;

	private String tipoIdRepInicial;
	private Long numeroIdRepInicial;

	private String nombreCompleto;
	private String apellidoCompleto;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaCreacion;
	private String email;
	private Long telefono;
	private String ciudad;
	private String genero;
	private String password;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fNacimiento;
	private String direccion;
	private String tipo;
	private Date fechaContrato;

	public ClienteSaveDto() {

	}

	public ClienteSaveDto(String tipoId, Long numeroId, String tipoIdRep, Long numeroIdRep, String tipoIdRepInicial,
			Long numeroIdRepInicial, String nombreCompleto, String apellidoCompleto, Date fechaCreacion, String email,
			Long telefono, String ciudad, String genero, String password, Date fNacimiento, String direccion,
			String tipo, Date fechaContrato) {
		super();
		this.tipoId = tipoId;
		this.numeroId = numeroId;
		this.tipoIdRep = tipoIdRep;
		this.numeroIdRep = numeroIdRep;
		this.tipoIdRepInicial = tipoIdRepInicial;
		this.numeroIdRepInicial = numeroIdRepInicial;
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
		this.fechaCreacion = fechaCreacion;
		this.email = email;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.genero = genero;
		this.password = password;
		this.fNacimiento = fNacimiento;
		this.direccion = direccion;
		this.tipo = tipo;
		this.fechaContrato = fechaContrato;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public Long getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(Long numeroId) {
		this.numeroId = numeroId;
	}

	public String getTipoIdRep() {
		return tipoIdRep;
	}

	public void setTipoIdRep(String tipoIdRep) {
		this.tipoIdRep = tipoIdRep;
	}

	public Long getNumeroIdRep() {
		return numeroIdRep;
	}

	public void setNumeroIdRep(Long numeroIdRep) {
		this.numeroIdRep = numeroIdRep;
	}

	public String getTipoIdRepInicial() {
		return tipoIdRepInicial;
	}

	public void setTipoIdRepInicial(String tipoIdRepInicial) {
		this.tipoIdRepInicial = tipoIdRepInicial;
	}

	public Long getNumeroIdRepInicial() {
		return numeroIdRepInicial;
	}

	public void setNumeroIdRepInicial(Long numeroIdRepInicial) {
		this.numeroIdRepInicial = numeroIdRepInicial;
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

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	@Override
	public String toString() {
		return "ClienteSaveDto [tipoId=" + tipoId + ", numeroId=" + numeroId + ", tipoIdRep=" + tipoIdRep
				+ ", numeroIdRep=" + numeroIdRep + ", tipoIdRepInicial=" + tipoIdRepInicial + ", numeroIdRepInicial="
				+ numeroIdRepInicial + ", nombreCompleto=" + nombreCompleto + ", apellidoCompleto=" + apellidoCompleto
				+ ", fechaCreacion=" + fechaCreacion + ", email=" + email + ", telefono=" + telefono + ", ciudad="
				+ ciudad + ", genero=" + genero + ", password=" + password + ", fNacimiento=" + fNacimiento
				+ ", direccion=" + direccion + ", tipo=" + tipo + ", fechaContrato=" + fechaContrato + "]";
	}

}
