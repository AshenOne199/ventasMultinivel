package com.udistrital.app.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.Inventario;
import com.udistrital.app.entity.InventarioId;
import com.udistrital.app.entity.Orden;
import com.udistrital.app.entity.OrdenId;
import com.udistrital.app.entity.Periodo;
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

		OrdenId ordenId = new OrdenId(o.getIdOrden(), o.getIdProducto(), o.getIdRegion(), o.getTipoId(),
				o.getNumeroId());

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

		Orden orden = new Orden(ordenId, inventario.get(), cliente.get(), periodo.get(),
				convertLocalDate(o.getFechaRegistro()), o.getEstado(), clienteCalifica.get(), o.getCalificacion(),
				o.getCantidad(), o.getTipoIdRep(), o.getNumeroIdRep());

		// ordenRepository.save(orden);
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

	/*
	 * @PutMapping("/orden/estado/{estado}") public ResponseEntity<Optional<Orden>>
	 * setEstado(@PathVariable String estado, @RequestBody OrdenId id) {
	 * ordenRepository.updateestadoById(estado, id); return
	 * ResponseEntity.ok().build(); }
	 *//*
		 * @PutMapping("/calificacion/{calificacion}") public
		 * ResponseEntity<Optional<Orden>> setCalificacion(@PathVariable Boolean
		 * calificacion, @RequestBody OrdenId id) {
		 * ordenRepository.updateCalificacion(calificacion, id); return
		 * ResponseEntity.ok().build(); }
		 */
	@GetMapping("/orden/maxima")
	public ResponseEntity<Orden> getPrimeraOrden() {
		List<Orden> ordenes = ordenRepository.findAll();
		Optional<Orden> ordenMaxima = ordenes.stream().reduce((first, second) -> second);
		return ResponseEntity.ok(ordenMaxima.get());
	}
	/*
	 * @GetMapping("/orden/enCarrito/{idOrden}") public ResponseEntity<List<Orden>>
	 * getAllOrdenesCarrito(@PathVariable Integer idOrden) { List<Orden>
	 * ordenesEnCarrito = ordenService.findByid_idOrdenAndEstado(idOrden,
	 * "EN PROCESO"); return ResponseEntity.ok(ordenesEnCarrito); }
	 * 
	 * @PutMapping("/orden/cantidad/{cantidad}") public
	 * ResponseEntity<Optional<Orden>> setCantidad(@PathVariable Short
	 * cantidad, @RequestBody OrdenId id) { ordenRepository.updateCantidad(cantidad,
	 * id); return ResponseEntity.ok().build(); }
	 */
}
