package com.udistrital.app.controllers;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.view.VistaUsers;
import com.udistrital.app.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginController {

	final private UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping("/getUsuario")
    public ResponseEntity<VistaUsers> getUsuario(@RequestParam String username, @RequestParam String pass) {
		Optional<VistaUsers> usuario = userService.findByUsernamAndPassword(username, pass);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		return ResponseEntity.notFound().build();
    }

	@PostMapping("/database")
	public Map<String, String> updateDatabaseCredentials(@RequestParam String username, @RequestParam String password)
			throws IOException {
		
		return userService.updateDatasource(username, password);
	}

}
