package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.udistrital.app.entity.Categoria;
import com.udistrital.app.repository.CategoriaRepository;

@RestController
@RequestMapping("api/v1/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repositorio;
	
	//Método por el cual devuelve todos los registros de Categoria
	@GetMapping("/getCategorias")
	public List<Categoria> getCategorias(){
		return repositorio.getCategorias();
	}
	
	//Método por el cual devuleve las categorias principales que no son subCategoria de nadie
	@GetMapping("/getCategoriasPrincipales")
	public List<Categoria> getCategoriasPrincipales(){
		return repositorio.getCategoriasPrincipales();
	}
	
	//Método por el cual devuelve las subcategorias de un categoria dada la idCategoria
	@GetMapping("/getCategoriasPrincipales")
	public List<Categoria> getSubCategoriasFrom(@RequestParam("idCategoria") Integer idCategoria){
		return repositorio.getSubCategoriasFrom(idCategoria);
	}
	
}
