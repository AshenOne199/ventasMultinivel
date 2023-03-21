package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Embeddable
public class ClienteId implements Serializable {
	
    private static final long serialVersionUID = 5186211993182230493L;
    @Size(max = 5)
    @NotNull
    @Column(name = "K_TIPO_ID", nullable = false, length = 5)
    private String tipoId;

    @NotNull
    @Column(name = "K_NUMERO_ID", nullable = false)
    private Long numeroId;
    
    public ClienteId() {
		
	}

    public ClienteId(@Size(max = 5) @NotNull String kTipoId, @NotNull Long kNumeroId) {
		super();
		this.tipoId = kTipoId;
		this.numeroId = kNumeroId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClienteId entity = (ClienteId) o;
        return Objects.equals(this.tipoId, entity.tipoId) &&
                Objects.equals(this.numeroId, entity.numeroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoId, numeroId);
    }

	public String getkTipoId() {
		return tipoId;
	}

	public void setkTipoId(String kTipoId) {
		this.tipoId = kTipoId;
	}

	public Long getkNumeroId() {
		return numeroId;
	}

	public void setkNumeroId(Long kNumeroId) {
		this.numeroId = kNumeroId;
	}

	@Override
	public String toString() {
		return "ClienteId [tipoId=" + tipoId + ", numeroId=" + numeroId + "]";
	}
    
	
    

}