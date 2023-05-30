package com.udistrital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PersonaId implements Serializable {
    private static final long serialVersionUID = -2714467248349022237L;
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
        PersonaId entity = (PersonaId) o;
        return Objects.equals(this.kTipoId, entity.kTipoId) &&
                Objects.equals(this.kNumeroId, entity.kNumeroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kTipoId, kNumeroId);
    }

}