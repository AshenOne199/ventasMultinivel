package com.udistrital.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.Inventario;
import com.udistrital.app.entity.InventarioId;
import com.udistrital.app.entity.Orden;
import com.udistrital.app.entity.OrdenId;
import com.udistrital.app.entity.Periodo;
import com.udistrital.app.entity.dto.OrdenSaveDto;
import com.udistrital.app.repository.ClienteRepository;
import com.udistrital.app.repository.InventarioRepository;
import com.udistrital.app.repository.OrdenRepository;
import com.udistrital.app.repository.PeriodoRepository;
import com.udistrital.app.services.OrdenService;

@RestController
@CrossOrigin
public class OrdenController {

	private final OrdenRepository ordenRepository;
	private final OrdenService ordenService;
	private final InventarioRepository inventarioRepository;
	private final ClienteRepository clienteRepository;
	private final PeriodoRepository periodoRepository;

	public OrdenController(OrdenRepository ordenRepository, OrdenService ordenService, InventarioRepository inventarioRepository, ClienteRepository clienteRepository, PeriodoRepository periodoRepository) {
		this.ordenRepository = ordenRepository;
		this.ordenService = ordenService;
		this.inventarioRepository = inventarioRepository;
		this.clienteRepository = clienteRepository;
		this.periodoRepository = periodoRepository;
	}

	@PostMapping("/nuevaOrden")
	public ResponseEntity<Orden> saveNuevaOrden(@RequestBody OrdenSaveDto o) {
		
		OrdenId ordenId = new OrdenId(o.getIdOrden(), o.getIdProducto(), o.getIdRegion(), o.getTipoId(), o.getNumeroId());
		
		InventarioId inventarioId = new InventarioId(o.getIdProductoInv(), o.getIdRegionInv());
		Optional<Inventario> inventario = inventarioRepository.findById(inventarioId);
		if(inventario.isEmpty()) {
			System.out.println("NO EXISTE INVENTARIO");
		}
			
		ClienteId clienteId =  new ClienteId(o.getTipoIdCliente(), o.getNumeroIdCliente());
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if(cliente.isEmpty()) {
			System.out.println("NO EXISTE CLIENTE");
		}
		
		Optional<Periodo> periodo = periodoRepository.findById(o.getIdPeriodo());
		if(periodo.isEmpty()) {
			System.out.println("NO EXISTE PERIODO");
		}
		
		ClienteId clienteIdCalifica =  new ClienteId(o.getTipoIdClienteCal(), o.getNumeroIdClienteCal());
		Optional<Cliente> clienteCalifica = clienteRepository.findById(clienteIdCalifica);
		if(clienteCalifica.isEmpty()) {
			System.out.println("NO EXISTE CLIENTE_CALIFICA");
		}
		
		Orden orden = new Orden(ordenId, inventario.get(), cliente.get(), periodo.get(), o.getFechaRegistro(), o.getEstado(), clienteCalifica.get(), o.getCalificacion(), o.getCantidad(), o.getTipoIdRep(), o.getNumeroIdRep());
		
		
		return new ResponseEntity<Orden>(ordenRepository.save(orden), HttpStatus.CREATED);
	}

	@PutMapping("/orden/estado/{estado}")
	public ResponseEntity<Optional<Orden>> setEstado(@PathVariable String estado, @RequestBody OrdenId id) {
		ordenRepository.updateestadoById(estado, id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/orden/calificacion/{calificacion}")
	public ResponseEntity<Optional<Orden>> setCalificacion(@PathVariable Short calificacion, @RequestBody OrdenId id) {
		ordenRepository.updateCalificacion(calificacion, id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/orden/maxima")
	public ResponseEntity<Orden> getPrimeraOrden() {
		List<Orden> ordenes = ordenRepository.findAll();
		Optional<Orden> ordenMaxima = ordenes.stream().reduce((first, second) -> second);
		return ResponseEntity.ok(ordenMaxima.get());
	}
	
	@GetMapping("/orden/enCarrito/{idOrden}")
	public ResponseEntity<List<Orden>> getAllOrdenesCarrito(@PathVariable Integer idOrden){
		List<Orden> ordenesEnCarrito = ordenService.findByid_idOrdenAndEstado(idOrden, "EN PROCESO");
		return ResponseEntity.ok(ordenesEnCarrito);
	}
	
	@PutMapping("/orden/cantidad/{cantidad}")
	public ResponseEntity<Optional<Orden>> setCantidad(@PathVariable Short cantidad, @RequestBody OrdenId id) {
		ordenRepository.updateCantidad(cantidad, id);
		return ResponseEntity.ok().build();
	}

}
