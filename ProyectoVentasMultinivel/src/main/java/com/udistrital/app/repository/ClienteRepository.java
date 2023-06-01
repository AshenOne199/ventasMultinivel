package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.RepresentanteVentaId;

import jakarta.transaction.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, ClienteId> {

	@Transactional
	@Modifying
	@Query("update Cliente c set c.representanteVentas.id = ?2 WHERE c.id = ?1")
	void updateRV(ClienteId clienteId, RepresentanteVentaId id);
	
	

}
