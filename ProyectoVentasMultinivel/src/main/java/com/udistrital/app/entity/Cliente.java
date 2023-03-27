package com.udistrital.app.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	
    @EmbeddedId
    private ClienteId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID_REP", referencedColumnName = "K_TIPO_ID", nullable = false),
            @JoinColumn(name = "K_ID_NUMERO_REP", referencedColumnName = "K_NUMERO_ID", nullable = false)
    })
    private RepresentanteVentas representanteVentas;

    @Size(max = 200)
    
    @Column(name = "I_TIPO_ID_REP", nullable = false, length = 200)
    private String tipoIdRep;
    
    
    @Column(name = "Q_NUMERO_ID_REP", nullable = false, length = 200)
    private Long idRep;
    
    @Size(max = 200)
    
    @Column(name = "N_NOMBRECOMPLETO", nullable = false, length = 200)
    private String nombreCompleto;

    @Size(max = 200)
    
    @Column(name = "N_APELLIDOCOMPLETO", nullable = false, length = 200)
    private String apellidoCompleto;

    
    @Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
    @Column(name = "F_FECHACREACION", nullable = false)
    private Date fechaCreacion;

    @Size(max = 150)
    
    @Column(name = "O_EMAIL", nullable = false, length = 150)
    private String email;

    
    @Column(name = "Q_TELEFONO", nullable = false)
    private Long telefono;

    @Size(max = 150)
    
    @Column(name = "N_CIUDAD", nullable = false, length = 150)
    private String ciudad;

    @Size(max = 3)
    
    @Column(name = "I_GENERO", nullable = false, length = 3)
    private String genero;

    @Size(max = 100)
    
    @Column(name = "O_PASSWORD", nullable = false, length = 100)
    private String password;

    
    @Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yy")
    @Column(name = "F_NACIMIENTO", nullable = false)
    private Date fNacimiento;

    @Size(max = 200)
    
    @Column(name = "O_DIRECCION", nullable = false, length = 200)
    private String direccion;
    
    @Size(max = 100)
    @Column(name = "N_USERNAME", nullable = false, length = 100)
    private String username;

    public Cliente() {
		
	}

	public Cliente(ClienteId id, RepresentanteVentas representanteVentas, @Size(max = 200) String tipoIdRep, Long idRep,
			@Size(max = 200) String nombreCompleto, @Size(max = 200) String apellidoCompleto, Date fechaCreacion,
			@Size(max = 150) String email, Long telefono, @Size(max = 150) String ciudad, @Size(max = 3) String genero,
			@Size(max = 100) String password, Date fNacimiento, @Size(max = 200) String direccion,
			@Size(max = 100) String username) {
		super();
		this.id = id;
		this.representanteVentas = representanteVentas;
		this.tipoIdRep = tipoIdRep;
		this.idRep = idRep;
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
		this.username = username;
	}

	public ClienteId getId() {
		return id;
	}

	public void setId(ClienteId id) {
		this.id = id;
	}

	public RepresentanteVentas getRepresentanteVentas() {
		return representanteVentas;
	}

	public void setRepresentanteVentas(RepresentanteVentas representanteVentas) {
		this.representanteVentas = representanteVentas;
	}

	public String getTipoIdRep() {
		return tipoIdRep;
	}

	public void setTipoIdRep(String tipoIdRep) {
		this.tipoIdRep = tipoIdRep;
	}

	public Long getIdRep() {
		return idRep;
	}

	public void setIdRep(Long idRep) {
		this.idRep = idRep;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

}