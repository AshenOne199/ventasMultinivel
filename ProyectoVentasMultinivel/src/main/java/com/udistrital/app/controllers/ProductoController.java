package com.udistrital.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Producto;
import com.udistrital.app.repository.ProductoRepository;

@RestController
@RequestMapping("api/v1/categorias")
@CrossOrigin(origins = "*")
public class ProductoController {

	@Autowired
	private ProductoRepository repositorio;
	
	//Método por el cual devuelve todos los registros de Producto
	@GetMapping("/getProductos")
	public List<Producto> getProductos(){
		return repositorio.getProductos();
	}
	
	//Método por el cual devuelve el registro de un producto por su idProducto
	@GetMapping("/getProducto")
	public List<Producto> getProducto(@RequestParam("idProducto") Integer idProducto){
		return repositorio.getProducto(idProducto);
	}
	
}
