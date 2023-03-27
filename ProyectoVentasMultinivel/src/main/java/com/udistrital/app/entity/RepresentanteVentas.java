package com.udistrital.app.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "REPRESENTANTE_VENTAS")
public class RepresentanteVentas {
	
    @EmbeddedId
    private RepresentanteVentaId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "K_TIPO_ID_JEFE", referencedColumnName = "K_TIPO_ID"),
            @JoinColumn(name = "K_NUMERO_ID_JEFE", referencedColumnName = "K_NUMERO_ID")
    })
    private RepresentanteVentas representanteVentas;

    @Size(max = 200)

    @Column(name = "N_NOMBRECOMPLETO", nullable = false, length = 200)
    private String nombreCompleto;

    @Size(max = 200)

    @Column(name = "N_APELLIDOCOMPLETO", nullable = false, length = 200)
    private String apellidoCompleto;


    @Column(name = "F_FECHACREACION", nullable = false)
    private LocalDate fechaCreacion;

    @Size(max = 150)

    @Column(name = "O_EMAIL", nullable = false, length = 150)
    private String email;


    @Column(name = "Q_TELEFONO", nullable = false)
    private Long telefono;

    @Size(max = 100)

    @Column(name = "N_REGION", nullable = false, length = 100)
    private String region;

    @Size(max = 3)

    @Column(name = "I_GENERO", nullable = false, length = 3)
    private String genero;

    @Size(max = 200)

    @Column(name = "O_PASSWORD", nullable = false, length = 200)
    private String password;


    @Column(name = "F_NACIMIENTO", nullable = false)
    private LocalDate fNacimiento;

    @Size(max = 150)

    @Column(name = "O_DIRECCION", nullable = false, length = 150)
    private String direccion;

    @Size(max = 10)

    @Column(name = "I_TIPO", nullable = false, length = 10)
    private String tipo;


    @Column(name = "F_FECHACONTRATO", nullable = false)
    private LocalDate fechaContrato;
    
    @Size(max = 100)
    @Column(name = "N_USERNAME", nullable = false, length = 100)
    private String username;

    @Size(max = 50)
    @Column(name = "I_ESTADO", nullable = false, length = 50)
    private String estado;
    

    public RepresentanteVentas() {
		
	}


	public RepresentanteVentas(RepresentanteVentaId id, RepresentanteVentas representanteVentas,
			@Size(max = 200) String nombreCompleto, @Size(max = 200) String apellidoCompleto, LocalDate fechaCreacion,
			@Size(max = 150) String email, Long telefono, @Size(max = 100) String region, @Size(max = 3) String genero,
			@Size(max = 200) String password, LocalDate fNacimiento, @Size(max = 150) String direccion,
			@Size(max = 10) String tipo, LocalDate fechaContrato, @Size(max = 100) String username,
			@Size(max = 50) String estado) {
		super();
		this.id = id;
		this.representanteVentas = representanteVentas;
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


	public RepresentanteVentaId getId() {
		return id;
	}


	public void setId(RepresentanteVentaId id) {
		this.id = id;
	}


	public RepresentanteVentas getRepresentanteVentas() {
		return representanteVentas;
	}


	public void setRepresentanteVentas(RepresentanteVentas representanteVentas) {
		this.representanteVentas = representanteVentas;
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


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
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


	public LocalDate getfNacimiento() {
		return fNacimiento;
	}


	public void setfNacimiento(LocalDate fNacimiento) {
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


	public LocalDate getFechaContrato() {
		return fechaContrato;
	}


	public void setFechaContrato(LocalDate fechaContrato) {
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