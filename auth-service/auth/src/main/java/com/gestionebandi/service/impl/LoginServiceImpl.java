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
	public String login(UtentiDTO utente) {
		List<String> risposta;
		try {
			risposta = repo.login(utente.getUsername(), utente.getPassword());
			String stored = risposta.get(0);  // esempio: "test,123456"
			String[] parts = stored.split(",");  // split separa la stringa in base alla virgola
			String storedUsername = parts[0];   // "test"
			String storedPassword = parts[1];   // "123456"
			String storedRole = parts[2]; //RUOLO AGGIUNTO IN BEARER
			if(storedUsername.equals(utente.getUsername()) && storedPassword.equals(utente.getPassword())) {
				//return "login avvenuto con successo";
				System.out.println("login avvenuto con successo");
				return storedRole;
			}
		} catch (Exception e) {
			 e.printStackTrace(); // per debug
			    return "Username o password sbagliati";
		}
		return null;
	}


}
