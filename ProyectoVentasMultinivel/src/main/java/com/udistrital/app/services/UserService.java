package com.udistrital.app.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udistrital.app.entity.view.VistaUsers;
import com.udistrital.app.repository.UsersRepository;

@Service
public class UserService {

	final private UsersRepository userRepository;
	
	public UserService( UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<VistaUsers> findByUsernamAndPassword(String username, String pass) {
		return userRepository.findByUsernameAndPassword(username, pass);
	}
	
	
	
}
