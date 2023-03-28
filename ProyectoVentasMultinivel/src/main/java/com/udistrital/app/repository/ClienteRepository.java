package com.udistrital.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.RepresentanteVentaId;

public interface ClienteRepository extends JpaRepository<Cliente, ClienteId> {

	Optional<Cliente> findByUsernameAndPassword(String oEmail, String oPassword);
	
	
	@Transactional
	@Modifying
	@Query("update Cliente c set c.representanteVentas.id = ?2 WHERE c.id = ?1")
	void updateRV(ClienteId clienteId, RepresentanteVentaId id);

}
