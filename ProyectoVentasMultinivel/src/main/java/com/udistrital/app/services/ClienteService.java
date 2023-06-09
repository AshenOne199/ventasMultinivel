package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udistrital.app.config.CustomQueryExecutor;
import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.RepresentanteVentaId;
import com.udistrital.app.entity.dto.ClienteDto;
import com.udistrital.app.repository.ClienteRepository;

@Service
public class ClienteService {

	final private CustomQueryExecutor ddlExecutor;

	final private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository, CustomQueryExecutor ddlExecutor) {
		this.clienteRepository = clienteRepository;
		this.ddlExecutor = ddlExecutor;
	}

	public ClienteDto getClienteLogin(String username, String password) {
		Optional<Cliente> cliente = clienteRepository.findByUsernameAndPassword(username, password);
		ClienteDto clienteDto = new ClienteDto();
		if (cliente.isPresent()) {
			clienteDto.setId(cliente.get().getId());
			clienteDto.setNombreCompleto(cliente.get().getNombreCompleto());
			clienteDto.setApellidoCompleto(cliente.get().getApellidoCompleto());
		}
		return clienteDto;
	}

	public List<ClienteDto> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDto> clientesDto = new ArrayList<>();
		for (Cliente cliente : clientes) {
			ClienteDto clienteDto = new ClienteDto(
					new ClienteId(cliente.getId().getkTipoId(), cliente.getId().getkNumeroId()),
					cliente.getNombreCompleto(), cliente.getApellidoCompleto());
			clientesDto.add(clienteDto);
		}
		return clientesDto;

	}

	public Cliente findByTipoIdAndIdEntity(ClienteId clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		return cliente.get();
	}

	public ClienteDto findByTipoIdAndId(ClienteId clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		ClienteDto clienteDto = new ClienteDto();
		if (cliente.isPresent()) {
			clienteDto = new ClienteDto(
					new ClienteId(cliente.get().getId().getkTipoId(), cliente.get().getId().getkNumeroId()),
					cliente.get().getNombreCompleto(), cliente.get().getApellidoCompleto());
		}
		return clienteDto;
	}

	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		ddlExecutor.executeClientCreation(cliente.getUsername(), cliente.getPassword());
	}

	public void updateActualRV(ClienteId clienteId, RepresentanteVentaId representanteVentaId) {
		clienteRepository.updateRV(clienteId, representanteVentaId);
	}

}
