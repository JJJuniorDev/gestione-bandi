package com.gestionebandi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionebandi.dto.UtentiDTO;
import com.gestionebandi.security.JwtUtil;

import xom.gestionebandi.service.LoginService;

@RestController // Indica che questa è una classe controller per API REST
@RequestMapping("/public") 
public class Login {
	
	@Autowired 
	private LoginService service;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> login (@RequestBody UtentiDTO utente) {
		//String risposta = service.login(utente);
		 String ruolo = service.login(utente);
		//if (risposta.equals("login avvenuto con successo")) {
		 if (ruolo != null) {
			String token = jwtUtil.generateToken(utente.getUsername(), ruolo);
			 Map<String, String> tokenMap = new HashMap<>();
		     tokenMap.put("token", "Bearer " + token);
			return ResponseEntity.ok().body(tokenMap);
		}else {
			return ResponseEntity.status(401).body("Credenziali non valide");
		}	
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UtentiDTO utente) {
	    String risposta = service.register(utente);
	    System.out.println("Chiamata a register con utente: " + risposta);

	    if ("registrazione avvenuta con successo".equalsIgnoreCase(risposta)) {
	        return ResponseEntity.ok().body(risposta);
	    } else if ("nome utente già registrato".equalsIgnoreCase(risposta)) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome utente già registrato");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registrazione non avvenuta");
	    }
	}

}
