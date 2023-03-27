package com.udistrital.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;

public interface ClienteRepository extends JpaRepository<Cliente, ClienteId> {

	Optional<Cliente> findByEmailAndPassword(String oEmail, String oPassword);

	
}
