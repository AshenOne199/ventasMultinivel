package com.udistrital.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Cliente;
import com.udistrital.app.entity.ClienteId;
import com.udistrital.app.entity.dto.ClienteDto;
import com.udistrital.app.repository.ClienteRepository;

@Service
public class ClienteService {
	
	final private ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public ClienteDto getClienteLogin(String email, String password){
		Optional<Cliente> cliente = clienteRepository.findByEmailAndPassword(email, password);
		ClienteDto clienteDto = new ClienteDto();
		if(cliente.isPresent()) {
			clienteDto.setNombreCompleto(cliente.get().getNombreCompleto());
			clienteDto.setApellidoCompleto(cliente.get().getApellidoCompleto());
		}else {
			clienteDto.setNombreCompleto("NN");
			clienteDto.setApellidoCompleto("No existe");
		}
		
		return clienteDto;
	}

	public List<ClienteDto> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDto> clientesDto = new ArrayList<>();
		for(Cliente cliente : clientes) {
			ClienteDto clienteDto = new ClienteDto(cliente.getNombreCompleto(), cliente.getApellidoCompleto());
			clientesDto.add(clienteDto);
		}
		return clientesDto;
	}

	public ClienteDto findByTipoIdAndId(ClienteId clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		ClienteDto clienteDto = new ClienteDto();
		if(cliente.isPresent()) {
			clienteDto = new ClienteDto(cliente.get().getNombreCompleto(), cliente.get().getApellidoCompleto());
		}
		return clienteDto;
	}

	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	

}
