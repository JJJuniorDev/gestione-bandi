package com.gestionebandi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionebandi.dto.UtentiDTO;
import com.gestionebandi.entity.Role;
import com.gestionebandi.security.JwtUtil;

import xom.gestionebandi.service.LoginService;

@RestController // Indica che questa è una classe controller per API REST
@RequestMapping("/public") 
public class Login {
	
	@Autowired 
	private LoginService service;
	
	private final JwtUtil jwtUtil = null;
	
	@GetMapping("/login")
	public ResponseEntity<?> login (@RequestBody UtentiDTO utente) {
		if("username".equals(utente.getUsername())&&"password".equals(utente.getPassword())) {
			String token = jwtUtil.generateToken(utente.getUsername());
			return ResponseEntity.ok().body("Bearer " + token);
		}
		return ResponseEntity.status(401).body("Credenziali non valide");
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register (@RequestBody UtentiDTO utente) {
		String risposta = service.register(utente);
		System.out.println("Chiamata a register con utente: " + risposta);
		if(risposta.equals("registrazione avvenuta con successo")) {
			return ResponseEntity.ok().body(risposta);
		}
		return ResponseEntity.status(401).body("Credenziali non valide");
	}
}
