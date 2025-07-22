package controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionebandi.config.SecurityConfig;

import dto.BandoDTO;
import service.BandoService;

@RestController
@RequestMapping("/api/bandi")
public class BandoController {

	private static final Logger logger = Logger.getLogger(SecurityConfig.class.getName());
	@Autowired
	private BandoService bandoService;
	
	
	@GetMapping
	public List<BandoDTO> getAllBandi(){
	    String username = SecurityContextHolder.getContext().getAuthentication().getName();
	    logger.info("Questo è un messaggio informativo della getBandi." + username);
	    System.out.println("Utente autenticato: " + username);
	    return this.bandoService.getAllBandi();
	}
}
