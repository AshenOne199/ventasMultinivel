package com.udistrital.app.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class OrdenId implements Serializable {
	
    private static final long serialVersionUID = 4731382458593458597L;
    
    @Column(name = "K_IDORDEN", nullable = false)
    private Integer idOrden;

    @Column(name = "K_IDPRODUCTO", nullable = false)
    private Short idProducto;

    @Column(name = "K_IDREGION", nullable = false)
    private Short idRegion;

    @Size(max = 3)
    @Column(name = "K_TIPO_ID", nullable = false, length = 3)
    private String tipoId;

    @Column(name = "K_NUMERO_ID", nullable = false)
    private Long numeroId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrdenId entity = (OrdenId) o;
        return Objects.equals(this.tipoId, entity.tipoId) &&
                Objects.equals(this.numeroId, entity.numeroId) &&
                Objects.equals(this.idProducto, entity.idProducto) &&
                Objects.equals(this.idRegion, entity.idRegion) &&
                Objects.equals(this.idOrden, entity.idOrden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoId, numeroId, idProducto, idRegion, idOrden);
    }

}