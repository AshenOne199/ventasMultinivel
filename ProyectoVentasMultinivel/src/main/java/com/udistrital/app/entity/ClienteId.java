package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ClienteId implements Serializable {
	
    private static final long serialVersionUID = 789389564724503516L;
    
    @Size(max = 3)
    @NotNull
    @Column(name = "K_TIPO_ID", nullable = false, length = 3)
    private String kTipoId;

    @NotNull
    @Column(name = "K_NUMERO_ID", nullable = false)
    private Long kNumeroId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClienteId entity = (ClienteId) o;
        return Objects.equals(this.kTipoId, entity.kTipoId) &&
                Objects.equals(this.kNumeroId, entity.kNumeroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kTipoId, kNumeroId);
    }

}