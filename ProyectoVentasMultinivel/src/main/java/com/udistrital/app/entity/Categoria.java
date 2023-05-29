package com.udistrital.app.entity;

import com.udistrital.app.entity.dto.CategoriaDto;

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

@SqlResultSetMapping(name = "CategoryResult", classes = {
		@ConstructorResult(targetClass = CategoriaDto.class, columns = { @ColumnResult(name = "K_IDCATEGORIA"),
				@ColumnResult(name = "N_NOMBRE") }) })

@NamedNativeQuery(name = "CategoryResult", resultClass = CategoriaDto.class, resultSetMapping = "CategoryResult", query = "SELECT DISTINCT C.K_IDCATEGORIA, C.N_NOMBRE FROM Categoria C, Region R, Inventario I, Producto P WHERE R.K_IDREGION = :idRegion AND C.K_IDSUBCATEGORIA IS NULL OR (SELECT DISTINCT CS.K_IDSUBCATEGORIA FROM CATEGORIA CS WHERE CS.K_IDSUBCATEGORIA=C.K_IDCATEGORIA AND P.K_IDCATEGORIA = CS.K_IDCATEGORIA AND I.K_IDPRODUCTO = P.K_IDPRODUCTO AND R.K_IDREGION = I.K_IDREGION AND R.K_IDREGION = :idRegion)=C.K_IDCATEGORIA AND R.K_IDREGION = I.K_IDREGION AND I.K_IDPRODUCTO = P.K_IDPRODUCTO AND P.K_IDCATEGORIA = C.K_IDCATEGORIA ORDER BY C.K_IDCATEGORIA"
		+ "")
@Entity
@Table(name = "CATEGORIA")
public class Categoria {

	@Id
	@Column(name = "K_IDCATEGORIA", nullable = false)
	private Short id;

	@Column(name = "K_IDSUBCATEGORIA")
	private Short idSubcategoria;

	@Size(max = 100)
	@NotNull
	@Column(name = "N_NOMBRE", nullable = false, length = 100)
	private String nombre;
	
	@NotNull
	@Column(name = "Q_IVA", nullable = false)
	private Long iva;

	public Categoria() {

	}

	public Categoria(Short id, Short idSubcategoria, @Size(max = 100) @NotNull String nombre, @NotNull Long iva) {
		super();
		this.id = id;
		this.idSubcategoria = idSubcategoria;
		this.nombre = nombre;
		this.iva = iva;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getkIdsubcategoria() {
		return idSubcategoria;
	}

	public void setkIdsubcategoria(Short kIdsubcategoria) {
		this.idSubcategoria = kIdsubcategoria;
	}

	public String getnNombre() {
		return nombre;
	}

	public void setnNombre(String nNombre) {
		this.nombre = nNombre;
	}

	public Long getIva() {
		return iva;
	}

	public void setIva(Long iva) {
		this.iva = iva;
	}
}