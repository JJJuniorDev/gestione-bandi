package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CandidaturaDTO;
import service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectServ;
	
	//DA RIMUOVERE IN FUTURO
	@GetMapping
	public List<CandidaturaDTO> getAllCandidature() {
		return projectServ.getAllCandidature();
	}
	
	@GetMapping("/{id}")
	public CandidaturaDTO getCandidaturaById(@PathVariable String id) {
	return projectServ.getCandidaturaById(id);
}
	
	@GetMapping("/user/{userId}")
	public List<CandidaturaDTO> getCandidatureByUserId(@PathVariable String userId) {
		return projectServ.getCandidatureByUserId(userId);
	}
}
