package com.udistrital.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.compositehandle.ClientePrimaryKey;
import com.udistrital.app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente save(Cliente cliente) {

		return clienteRepository.save(cliente);
	}

	public boolean delete(String tipoId, Integer numeroId) {
		try {
			ClientePrimaryKey primaryKey = new ClientePrimaryKey(tipoId, numeroId);
			clienteRepository.deleteById(primaryKey);
			return true;
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Cliente get(String tipoId, Integer numeroId) {
		ClientePrimaryKey primaryKey = new ClientePrimaryKey(tipoId, numeroId);
		Optional<Cliente> clientOptional = clienteRepository.findById(primaryKey);
		Cliente client = clientOptional.get();
		return client;
	}

}
