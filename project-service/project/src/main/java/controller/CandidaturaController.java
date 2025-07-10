package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public CandidaturaDTO getCandidaturaById(@PathVariable String id) {
	return candidaturaServ.getCandidaturaById(id);
}
	
	@GetMapping("/user/{userId}")
	public List<CandidaturaDTO> getCandidatureByUserId(@PathVariable String userId) {
		return candidaturaServ.getCandidatureByUserId(userId);
	}
}
