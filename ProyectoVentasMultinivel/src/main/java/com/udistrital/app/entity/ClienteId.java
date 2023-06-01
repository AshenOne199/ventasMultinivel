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
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class ClienteId implements Serializable {
	
    private static final long serialVersionUID = 789389564724503516L;
    
    @Size(max = 3)
    @Column(name = "K_TIPO_ID", nullable = false, length = 3)
    private String tipoId;

    @Column(name = "K_NUMERO_ID", nullable = false)
    private Long numeroId;

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

}