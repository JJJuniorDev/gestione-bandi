package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ProjectDTO;
import service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectServ;
	
	//DA RIMUOVERE IN FUTURO
	@GetMapping
	public List<ProjectDTO> getAllProjects() {
		return projectServ.getAllProjects();
	}
	
	@GetMapping("/{id}")
	public ProjectDTO getProjectById(@PathVariable String id) {
	return projectServ.getProjectById(id);
}
}
