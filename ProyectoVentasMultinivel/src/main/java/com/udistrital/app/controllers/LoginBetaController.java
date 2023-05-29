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

import com.udistrital.app.services.DatabaseAuthService;
import com.udistrital.app.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class LoginBetaController {

	final private UserService userService;
	final private DatabaseAuthService loginService;

	public LoginBetaController(UserService userService, DatabaseAuthService loginService) {
		this.userService = userService;
		this.loginService = loginService;

	}
	
	@PostMapping("/database_login")
	public ResponseEntity<Map<String, String>> databaseLoginAttempt(@RequestParam String username,
			@RequestParam String password) throws IOException {
		return new ResponseEntity<Map<String, String>>(loginService.testConnectionAndUpdate(username, password), HttpStatus.OK);
	}

	@PostMapping("/database_password_restore")
	public ResponseEntity<Map<String, String>> changeUserOCIPassword(@RequestParam String username,
			@RequestParam String oldPassword, @RequestParam String newPassword)
			throws IOException, ClassNotFoundException {
		return new ResponseEntity<Map<String, String>>(loginService.updateOCIPassword(username, oldPassword, newPassword), HttpStatus.OK);
	}

	@PostMapping("/database/logout")
	public Map<String, String> setDefaultDatabaseCredentials() throws IOException {
		return userService.updateDatasource("U_ADMIN", "pass");
	}
	
}
