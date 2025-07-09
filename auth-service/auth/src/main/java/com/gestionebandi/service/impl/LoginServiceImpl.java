package com.gestionebandi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
		int risposta = repo.registerUserAndReturnString(utente.getUsername(), utente.getPassword(),Role.USER.name());
		if (risposta > 0) {
			return "registrazione avvenuta con successo";
		}else {
			return "registrazione non avvenuta!";
		}
		
	}


}
