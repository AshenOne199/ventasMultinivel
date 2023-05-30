package com.udistrital.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "PERSONA")
public class Persona {
	
    @EmbeddedId
    private PersonaId id;

    @Size(max = 3)
    @Column(name = "I_TIPO_ID", length = 3)
    private String iTipoId;

    @Column(name = "Q_NUMERO_ID")
    private Long qNumeroId;

    @Size(max = 150)
    @NotNull
    @Column(name = "N_NOMBRECOMPLETO", nullable = false, length = 150)
    private String nNombrecompleto;

    @Size(max = 150)
    @NotNull
    @Column(name = "N_APELLIDOCOMPLETO", nullable = false, length = 150)
    private String nApellidocompleto;

    @Size(max = 150)
    @NotNull
    @Column(name = "O_EMAIL", nullable = false, length = 150)
    private String oEmail;

    @NotNull
    @Column(name = "Q_TELEFONO", nullable = false)
    private Long qTelefono;

    @NotNull
    @Column(name = "F_FECHACREACION", nullable = false)
    private LocalDate fFechacreacion;

    @Size(max = 100)
    @NotNull
    @Column(name = "N_CIUDAD", nullable = false, length = 100)
    private String nCiudad;

    @Size(max = 3)
    @NotNull
    @Column(name = "I_GENERO", nullable = false, length = 3)
    private String iGenero;

    @NotNull
    @Column(name = "F_NACIMIENTO", nullable = false)
    private LocalDate fNacimiento;

    @Size(max = 150)
    @NotNull
    @Column(name = "O_DIRECCION", nullable = false, length = 150)
    private String oDireccion;

    @OneToOne(mappedBy = "persona")
    private Cliente cliente;

    @OneToOne(mappedBy = "persona")
    private RepresentanteVenta representanteVenta;

}