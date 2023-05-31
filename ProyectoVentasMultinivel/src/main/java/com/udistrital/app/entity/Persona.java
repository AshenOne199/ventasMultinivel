package com.udistrital.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "PERSONA")
public class Persona {
	
    @EmbeddedId
    private PersonaId id;

    @Size(max = 3)
    @Column(name = "I_TIPO_ID", length = 3)
    private String tipoId;

    @Column(name = "Q_NUMERO_ID")
    private Long numeroId;

    @Size(max = 150)
    @Column(name = "N_NOMBRECOMPLETO", nullable = false, length = 150)
    private String nombreCompleto;

    @Size(max = 150)
    @Column(name = "N_APELLIDOCOMPLETO", nullable = false, length = 150)
    private String apellidoCompleto;

    @Size(max = 150)
    @Column(name = "O_EMAIL", nullable = false, length = 150)
    private String email;

    @Column(name = "Q_TELEFONO", nullable = false)
    private Long telefono;

    @Column(name = "F_FECHACREACION", nullable = false)
    private Date fechaCreacion;

    @Size(max = 100)
    @Column(name = "N_CIUDAD", nullable = false, length = 100)
    private String ciudad;

    @Size(max = 3)
    @Column(name = "I_GENERO", nullable = false, length = 3)
    private String genero;

    @Column(name = "F_NACIMIENTO", nullable = false)
    private Date fechaNacimiento;

    @Size(max = 150)
    @Column(name = "O_DIRECCION", nullable = false, length = 150)
    private String direccion;

}