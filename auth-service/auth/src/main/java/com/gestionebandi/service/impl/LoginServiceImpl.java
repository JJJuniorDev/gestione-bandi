package com.gestionebandi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gestionebandi.dto.UtentiDTO;
import com.gestionebandi.entity.Role;
import com.gestionebandi.repository.LoginRepository;

import xom.gestionebandi.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepository repo;

	@Override
	public String register(UtentiDTO utente) {
	    int risposta = 0;
	    try {
	        risposta = repo.registerUserAndReturnString(
	            utente.getUsername(), 
	            utente.getPassword(), 
	            Role.USER.name()
	        );
	    if (risposta > 0) {
	        return "Registrazione avvenuta con successo";
	    	} else {
	    		return "Registrazione non avvenuta!";	    
	    	}
	        
	    } catch (DataIntegrityViolationException e) {
	        // Gestione specifica del vincolo unique su username
	        return "Nome utente già registrato";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Errore durante la registrazione.";
	    }


	}

	@Override
	public UtentiDTO login(UtentiDTO utente) {  // Cambia il return type da String a UtentiDTO
	    List<String> risposta;
	    try {
	        risposta = repo.login(utente.getUsername(), utente.getPassword());
	        String stored = risposta.get(0);
	        String[] parts = stored.split(",");
	        String storedUsername = parts[0];
	        String storedPassword = parts[1];
	        String storedRole = parts[2];
	        String storedEnteId = parts[3]; // Recupera l'ID ente

	        if(storedUsername.equals(utente.getUsername()) && storedPassword.equals(utente.getPassword())) {
	            UtentiDTO response = new UtentiDTO();
	            response.setUsername(storedUsername);
	            response.setRole(storedRole);
	            response.setEnteId(storedEnteId); // Imposta l'enteId nel DTO
	            return response; // Restituisci l'oggetto completo
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; // Fallimento
	}


}
