package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CandidaturaDTO;
import service.CandidaturaService;

@RestController
@RequestMapping("/api/candidature")
public class CandidaturaController {

	@Autowired
	private CandidaturaService candidaturaServ;
	
	//DA RIMUOVERE IN FUTURO
	@GetMapping
	public List<CandidaturaDTO> getAllCandidature() {
		return candidaturaServ.getAllCandidature();
	}
	
	  @PostMapping
	    public ResponseEntity<CandidaturaDTO> createCandidatura(@RequestBody CandidaturaDTO candidaturaDTO) {
	        CandidaturaDTO saved = candidaturaServ.createCandidatura(candidaturaDTO);
	        return ResponseEntity.ok(saved);
	    }
	
	@GetMapping("/{id}")
	public CandidaturaDTO getCandidaturaById(@PathVariable String id) {
	return candidaturaServ.getCandidaturaById(id);
}
	
	@GetMapping("/user/{userId}")
	public List<CandidaturaDTO> getCandidatureByUserId(@PathVariable String userId) {
		return candidaturaServ.getCandidatureByUserId(userId);
	}
	
	@GetMapping("/bando/{bandoId}")
	public List<CandidaturaDTO> getCandidatureByBandoId(@PathVariable String bandoId){
		return candidaturaServ.getCandidatureByBandoId(bandoId);
	}
}
