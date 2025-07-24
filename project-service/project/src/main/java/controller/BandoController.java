package controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Ente;
import com.gestionebandi.config.SecurityConfig;

import dto.BandoDTO;
import dto.EnteDTO;
import service.BandoService;
import service.EnteService;

@RestController
@RequestMapping("/api/bandi")
public class BandoController {

	private static final Logger logger = Logger.getLogger(SecurityConfig.class.getName());
	@Autowired
	private BandoService bandoService;
	
	@Autowired
	private EnteService enteService;
	
	@GetMapping("/ente/{enteId}")
	public List<BandoDTO> getBandiByEnteId(@PathVariable String enteId){
		EnteDTO ente=this.enteService.getEnteById(enteId);
		List<BandoDTO> bandiDaEnte= ente.getBandiAppartenenti();
		return bandiDaEnte;
	}
	
	@GetMapping
	public List<BandoDTO> getAllBandi(){
	    String username = SecurityContextHolder.getContext().getAuthentication().getName();
	    logger.info("Questo è un messaggio informativo della getBandi." + username);
	    System.out.println("Utente autenticato: " + username);
	    return this.bandoService.getAllBandi();
	}
	
	@PostMapping("/new")
	public ResponseEntity<BandoDTO> createBando(@RequestBody BandoDTO bando ) {
		BandoDTO saved = this.bandoService.createBando(bando);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BandoDTO> updateBando(@RequestBody BandoDTO bando){
		BandoDTO updated= this.bandoService.updateBando(bando);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
	}
}
