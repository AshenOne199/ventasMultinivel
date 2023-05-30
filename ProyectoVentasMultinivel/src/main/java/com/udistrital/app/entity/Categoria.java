package com.udistrital.app.entity;

import java.math.BigDecimal;

import com.udistrital.app.entity.dto.CategoriaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
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
@SqlResultSetMapping(name = "CategoryResult", classes = {
		@ConstructorResult(targetClass = CategoriaDTO.class, columns = { @ColumnResult(name = "K_IDCATEGORIA"),
				@ColumnResult(name = "N_NOMBRE"), @ColumnResult(name = "Q_IVA") }) })
@NamedNativeQuery(name = "CategoryResult", resultClass = CategoriaDTO.class, resultSetMapping = "CategoryResult", query = "SELECT DISTINCT C.K_IDCATEGORIA, C.N_NOMBRE, C.Q_IVA FROM Categoria C, Region R, Inventario I, Producto P WHERE R.K_IDREGION = :idRegion AND C.K_IDSUBCATEGORIA IS NULL OR (SELECT DISTINCT CS.K_IDSUBCATEGORIA FROM CATEGORIA CS WHERE CS.K_IDSUBCATEGORIA=C.K_IDCATEGORIA AND P.K_IDCATEGORIA = CS.K_IDCATEGORIA AND I.K_IDPRODUCTO = P.K_IDPRODUCTO AND R.K_IDREGION = I.K_IDREGION AND R.K_IDREGION = :idRegion)=C.K_IDCATEGORIA AND R.K_IDREGION = I.K_IDREGION AND I.K_IDPRODUCTO = P.K_IDPRODUCTO AND P.K_IDCATEGORIA = C.K_IDCATEGORIA ORDER BY C.K_IDCATEGORIA"
		+ "")
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
	
    @Id
    @Column(name = "K_IDCATEGORIA", nullable = false)
    private Short id;

    @Column(name = "K_IDSUBCATEGORIA")
    private Short idSubcategoria;

    @Size(max = 50)
    @NotNull
    @Column(name = "N_NOMBRE", nullable = false, length = 50)
    private String nombre;

    @NotNull
    @Column(name = "Q_IVA", nullable = false, precision = 4, scale = 2)
    private BigDecimal iva;
    
}