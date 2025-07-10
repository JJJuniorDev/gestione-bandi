package xom.gestionebandi.service;


import com.gestionebandi.dto.UtentiDTO;

public interface LoginService {
	
	
	String register(UtentiDTO utente);
	
	String login(UtentiDTO utente);
}
