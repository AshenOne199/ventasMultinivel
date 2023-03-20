package com.udistrital.app.entity.dto;

public class RegionDto {

    private Long id;
    private String nombre;
    private Long idPais;
        
    public RegionDto() {
		
	}
    
	public RegionDto(Long id, String nombre, Long idPais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idPais = idPais;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
    
	
}

