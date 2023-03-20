package com.udistrital.app.entity.compositehandle;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClientePrimaryKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "k_tipo_id", nullable = false)
	private String tipoId;
	
	@Column(name = "k_numero_id", nullable = false)
	private Integer numeroId;
	
	public ClientePrimaryKey() {
		
	}
	
	public ClientePrimaryKey(String tipoId, Integer numeroId) {
		super();
		this.tipoId = tipoId;
		this.numeroId = numeroId;
	}
	public String getTipoId() {
		return tipoId;
	}
	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}
	public Integer getNumeroId() {
		return numeroId;
	}
	public void setNumeroId(Integer numeroId) {
		this.numeroId = numeroId;
	}
	
}
