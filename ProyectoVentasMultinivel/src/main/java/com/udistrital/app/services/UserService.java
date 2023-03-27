package com.udistrital.app.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.udistrital.app.entity.view.VistaUsers;
import com.udistrital.app.repository.UsersRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserService {

	final private UsersRepository userRepository;

	@Value("${database.username}")
	private String username;

	@Value("${database.password}")
	private String password;

	public UserService(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<VistaUsers> findByUsernamAndPassword(String username, String pass) {
		return userRepository.findByUsernameAndPassword(username, pass);
	}

	public Map<String, String> updateDatasource(String newUsername, String newPassword) throws IOException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resources/application.properties"));
			properties.setProperty("database.username", newUsername);
			properties.setProperty("database.password", newPassword);
			properties.store(new FileOutputStream("src/main/resources/application.properties"), null);
			org.springframework.boot.devtools.restart.Restarter.getInstance().restart();
			return Map.of("connection", "ok");

		} catch (Exception e) {
			e.printStackTrace();
			return Map.of("connection", "failed");
		}
	}


}
