package com.udistrital.app.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.Persona;
import com.udistrital.app.services.DatabaseAuthService;
import com.udistrital.app.services.PersonaService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class LoginController {

	final private DatabaseAuthService loginService;
	final private PersonaService personaService;
	
	public LoginController(DatabaseAuthService loginService, PersonaService personaService) {
		this.loginService = loginService;
		this.personaService = personaService;
	}

	@PostMapping("/database_login")
	public ResponseEntity<Map<String, String>> databaseLoginAttempt(@RequestParam String username,
			@RequestParam String password) throws IOException {
		return new ResponseEntity<Map<String, String>>(loginService.testConnectionAndUpdate(username, password),
				HttpStatus.OK);
	}

	@PostMapping("/database_password_restore")
	public ResponseEntity<Map<String, String>> changeUserOCIPassword(@RequestParam String username,
			@RequestParam String oldPassword, @RequestParam String newPassword)
			throws IOException, ClassNotFoundException {
		return new ResponseEntity<Map<String, String>>(
				loginService.updateOCIPassword(username, oldPassword, newPassword), HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(){
		loginService.logout();
		return new ResponseEntity<String>("Logout exitoso", HttpStatus.OK);
	}
	
	@PostMapping("getUsuario")
	public ResponseEntity<Persona> getUsuarioPorUsername(@RequestParam String username) {
		String [] cadenaUsername = username.split("_");
		Persona persona = personaService.getUsuarioPorUsername(cadenaUsername[0], cadenaUsername[1]);
		if(persona != null) {
			return ResponseEntity.status(HttpStatus.OK).body(persona);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
