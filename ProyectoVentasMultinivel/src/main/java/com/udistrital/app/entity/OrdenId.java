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
public class OrdenId implements Serializable {
    private static final long serialVersionUID = 4731382458593458597L;
    @NotNull
    @Column(name = "K_IDORDEN", nullable = false)
    private Integer kIdorden;

    @NotNull
    @Column(name = "K_IDPRODUCTO", nullable = false)
    private Short kIdproducto;

    @NotNull
    @Column(name = "K_IDREGION", nullable = false)
    private Short kIdregion;

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
        OrdenId entity = (OrdenId) o;
        return Objects.equals(this.kTipoId, entity.kTipoId) &&
                Objects.equals(this.kNumeroId, entity.kNumeroId) &&
                Objects.equals(this.kIdproducto, entity.kIdproducto) &&
                Objects.equals(this.kIdregion, entity.kIdregion) &&
                Objects.equals(this.kIdorden, entity.kIdorden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kTipoId, kNumeroId, kIdproducto, kIdregion, kIdorden);
    }

}