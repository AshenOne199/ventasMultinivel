package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.compositehandle.ClientePrimaryKey;

public interface ClienteRepository extends JpaRepository<Cliente, ClientePrimaryKey> {

	
}
