package com.udistrital.app.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.app.entity.view.VistaUsers;
import com.udistrital.app.services.UserService;

@RestController
public class LoginController {
	
	final private UserService userService;
	
	public LoginController( UserService userService) {
		this.userService = userService;

	}

	@GetMapping("/getUsuario")
    public Optional<VistaUsers> getUsuario(@RequestParam String username, @RequestParam String pass) {
		return userService.findByUsernamAndPassword(username, pass);
    }

}
