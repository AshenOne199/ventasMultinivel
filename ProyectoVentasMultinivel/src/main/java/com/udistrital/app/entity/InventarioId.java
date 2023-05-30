package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class InventarioId implements Serializable {
	
    private static final long serialVersionUID = 3995260559747321056L;
    
    @NotNull
    @Column(name = "K_IDPRODUCTO", nullable = false)
    private Short kIdproducto;

    @NotNull
    @Column(name = "K_IDREGION", nullable = false)
    private Short kIdregion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventarioId entity = (InventarioId) o;
        return Objects.equals(this.kIdproducto, entity.kIdproducto) &&
                Objects.equals(this.kIdregion, entity.kIdregion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kIdproducto, kIdregion);
    }

}