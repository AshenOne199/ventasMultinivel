package com.udistrital.app.entity.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class RepresentanteSaveDto {

	private String tipoId;
	private Long numeroId;

	private String tipoIdJefe;
	private Long numeroIdJefe;

	private String nombreCompleto;
	private String apellidoCompleto;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
	private Date fechaCreacion;
	private String email;
	private Long telefono;
	private String region;
	private String genero;
	private String password;
	
	@Temporal(TemporalType.DATE)
   	@JsonFormat(pattern = "dd/MM/yy")
    private Date fNacimiento;
    private String direccion;
    private String tipo;
    @Temporal(TemporalType.DATE)
   	@JsonFormat(pattern = "dd/MM/yy")
    private Date fechaContrato;
    private String username;
    private String estado;
    
    public RepresentanteSaveDto() {
		
	}
    
	public RepresentanteSaveDto(String tipoId, Long numeroId, String tipoIdJefe, Long numeroIdJefe,
			String nombreCompleto, String apellidoCompleto, Date fechaCreacion, String email, Long telefono,
			String region, String genero, String password, Date fNacimiento, String direccion, String tipo,
			Date fechaContrato, String username, String estado) {
		super();
		this.tipoId = tipoId;
		this.numeroId = numeroId;
		this.tipoIdJefe = tipoIdJefe;
		this.numeroIdJefe = numeroIdJefe;
		this.nombreCompleto = nombreCompleto;
		this.apellidoCompleto = apellidoCompleto;
		this.fechaCreacion = fechaCreacion;
		this.email = email;
		this.telefono = telefono;
		this.region = region;
		this.genero = genero;
		this.password = password;
		this.fNacimiento = fNacimiento;
		this.direccion = direccion;
		this.tipo = tipo;
		this.fechaContrato = fechaContrato;
		this.username = username;
		this.estado = estado;
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
	public String getTipoIdJefe() {
		return tipoIdJefe;
	}
	public void setTipoIdJefe(String tipoIdJefe) {
		this.tipoIdJefe = tipoIdJefe;
	}
	public Long getNumeroIdJefe() {
		return numeroIdJefe;
	}
	public void setNumeroIdJefe(Long numeroIdJefe) {
		this.numeroIdJefe = numeroIdJefe;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    

}
