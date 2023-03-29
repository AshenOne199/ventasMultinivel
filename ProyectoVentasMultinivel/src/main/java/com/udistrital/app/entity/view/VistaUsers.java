package com.udistrital.app.entity.view;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VISTAUSERS")
@Immutable
public class VistaUsers {

	@Id
	@Column(name = "N_USERNAME")
	private String username;

	@Column(name = "O_PASSWORD")
	private String password;

	@Column(name = "I_ESTADO")
	private String estado;

	@Column(name = "ROL")
	private String rol;

	public VistaUsers() {

	}

	public VistaUsers(String username, String password, String estado, String rol) {
		super();
		this.username = username;
		this.password = password;
		this.estado = estado;
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
