package com.udistrital.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.Orden;
import com.udistrital.app.repository.OrdenRepository;

@Service
public class OrdenService {
	
	private final OrdenRepository ordenRepository;

	public OrdenService(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}

	public List<Orden> findByid_idOrdenAndEstado(Integer idOrden, String estado) {

		return ordenRepository.findByid_idOrdenAndEstado(idOrden, estado);
	}
	

	

}
