package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
    
    @Column(name = "K_IDPRODUCTO", nullable = false)
    private Short idProducto;

    @Column(name = "K_IDREGION", nullable = false)
    private Short idRegion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventarioId entity = (InventarioId) o;
        return Objects.equals(this.idProducto, entity.idProducto) &&
                Objects.equals(this.idRegion, entity.idRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idRegion);
    }

}