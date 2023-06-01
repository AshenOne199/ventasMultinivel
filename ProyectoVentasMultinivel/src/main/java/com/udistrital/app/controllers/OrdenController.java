package com.udistrital.app.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.udistrital.app.entity.*;
import com.udistrital.app.entity.dto.OrdenIdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.udistrital.app.entity.dto.OrdenSaveDto;
import com.udistrital.app.exceptions.NoFoundClientException;
import com.udistrital.app.exceptions.NoFoundInventraioException;
import com.udistrital.app.exceptions.NoFoundPeriodException;
import com.udistrital.app.repository.ClienteRepository;
import com.udistrital.app.repository.InventarioRepository;
import com.udistrital.app.repository.OrdenRepository;
import com.udistrital.app.repository.PeriodoRepository;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin
@RequestMapping("/orden")
public class OrdenController {

	private final OrdenRepository ordenRepository;
	private final InventarioRepository inventarioRepository;
	private final ClienteRepository clienteRepository;
	private final PeriodoRepository periodoRepository;
	final private JdbcTemplate jdbcTemplate;

	public OrdenController(OrdenRepository ordenRepository, InventarioRepository inventarioRepository,
			ClienteRepository clienteRepository, PeriodoRepository periodoRepository, JdbcTemplate jdbcTemplate) {
		this.ordenRepository = ordenRepository;
		this.inventarioRepository = inventarioRepository;
		this.clienteRepository = clienteRepository;
		this.periodoRepository = periodoRepository;
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostMapping("/nuevaOrden")
	public ResponseEntity<Orden> saveNuevaOrden(@RequestBody OrdenSaveDto o) {


		InventarioId inventarioId = new InventarioId(o.getIdProductoInv(), o.getIdRegionInv());
		Optional<Inventario> inventario = inventarioRepository.findById(inventarioId);
		if (!inventario.isPresent()) {
			throw new NoFoundInventraioException();

		}

		ClienteId clienteId = new ClienteId(o.getTipoIdCliente(), o.getNumeroIdCliente());
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if (cliente.isEmpty()) {
			throw new NoFoundClientException();
		}

		Optional<Periodo> periodo = periodoRepository.findById(o.getIdPeriodo());
		if (periodo.isEmpty()) {
			throw new NoFoundPeriodException();
		}

		ClienteId clienteIdCalifica = new ClienteId(o.getTipoIdClienteCal(), o.getNumeroIdClienteCal());
		Optional<Cliente> clienteCalifica = clienteRepository.findById(clienteIdCalifica);
		if (clienteCalifica.isEmpty()) {
			throw new NoFoundClientException();
		}
		
		someUpdate(o);

		return ResponseEntity.ok().build();
	}

	private LocalDate convertLocalDate(String fechaString) {

		String[] partes = fechaString.split("-");
		int year = Integer.parseInt(partes[0]);
		int month = Integer.parseInt(partes[1]);

		LocalDate fecha = LocalDate.of(year, month, 1);
		return fecha;
	}

	@Transactional
	public int someUpdate(OrdenSaveDto o) {

		String sql = "INSERT INTO orden (k_idorden, k_idproducto, k_idregion, k_idperiodo, f_fecharegistro, i_estado, k_tipo_id, k_numero_id, k_tipo_id_calif, k_numero_id_calif, q_calificacion, q_cantidad, i_tipo_id_rep, q_numero_id_rep) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		return jdbcTemplate.update(sql, o.getIdOrden(), o.getIdProducto(), o.getIdRegion(), o.getIdPeriodo(),
				convertLocalDate(o.getFechaRegistro()), o.getEstado(), o.getTipoId(), o.getNumeroId(),
				o.getTipoIdClienteCal(), o.getNumeroIdClienteCal(), o.getCalificacion(), o.getCantidad(),
				o.getTipoIdRep(), o.getNumeroIdRep());
	}


	 @PutMapping("/estado/{estado}")
	 public ResponseEntity<Optional<Orden>> setEstado(@PathVariable String estado, @RequestBody OrdenIdDto id) {

		Optional<Orden> ordOld = ordenRepository.findById(new OrdenId(id.getIdOrden(), id.getIdProducto(),id.getIdRegion(),id.getTipoId(),id.getNumeroId()));

		Orden ordNew = ordOld.get();

		ordNew.setIEstado(estado);

	  	ordenRepository.save(ordNew);
	  	return ResponseEntity.ok().build();
	}


	@PutMapping("/calificacion/{calificacion}") public ResponseEntity<Optional<Orden>> setCalificacion(@PathVariable Short calificacion, @RequestBody OrdenIdDto id) {

		Optional<Orden> ordOld = ordenRepository.findById(new OrdenId(id.getIdOrden(), id.getIdProducto(),id.getIdRegion(),id.getTipoId(),id.getNumeroId()));

		Orden ordNew = ordOld.get();

		ordNew.setQCalificacion(calificacion);
		ordenRepository.save(ordNew);

		  return ResponseEntity.ok().build();
	}

	@GetMapping("/maxima")
	public ResponseEntity<Orden> getPrimeraOrden() {
		List<Orden> ordenes = ordenRepository.findAll();
		Optional<Orden> ordenMaxima = ordenes.stream().reduce((first, second) -> second);
		return ResponseEntity.ok(ordenMaxima.get());
	}

	 @GetMapping("/enCarrito/{idOrden}")
	 public ResponseEntity<List<Orden>>	 getAllOrdenesCarrito(@PathVariable Integer idOrden) {

		List<Orden> ordenesEnCarrito = ordenRepository.findAllById(idOrden);

		return ResponseEntity.ok(ordenesEnCarrito);
	}

	 @PutMapping("/cantidad/{cantidad}")
	 public ResponseEntity<Optional<Orden>> setCantidad(@PathVariable Short cantidad, @RequestBody OrdenIdDto id) {

		 Optional<Orden> ordOld = ordenRepository.findById(new OrdenId(id.getIdOrden(), id.getIdProducto(),id.getIdRegion(),id.getTipoId(),id.getNumeroId()));

		 Orden ordNew = ordOld.get();

		 ordNew.setQCantidad(cantidad);

		 ordenRepository.save(ordNew);

		 return ResponseEntity.ok().build();
	 }

}
