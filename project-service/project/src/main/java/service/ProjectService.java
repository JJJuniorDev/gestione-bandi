package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Project;
import dto.ProjectDTO;
import mapper.ProjectMapper;
import repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private ProjectMapper mapper;
	
	public List<ProjectDTO> getAllProjects() {
		// TODO Auto-generated method stub
	
	List<Project> progettiTrovati= projectRepo.findAll();
	 List<ProjectDTO> progettiToDTO= progettiTrovati.stream()
             .map(project -> mapper.toDTO(project))
             .collect(Collectors.toList());
	 
	 return progettiToDTO;
}

	public ProjectDTO getProjectById(String id) {
		Long idConverted= Long.valueOf(id);
		Optional<Project> progettoTrovatoOptional= projectRepo.findById(idConverted);
		Project progettoTrovato= progettoTrovatoOptional.get();
		ProjectDTO progettoToDTO= mapper.toDTO(progettoTrovato);
		return progettoToDTO;
	}

	public List<ProjectDTO> getProjectByUserId(String userId) {
		Long idConverted= Long.valueOf(userId);
		Optional<List<Project>> progettiTrovatiOptional= projectRepo.findAllByUserId(idConverted);
		List<Project> progetti=progettiTrovatiOptional.get();
		List<ProjectDTO> progettiToDTO= progetti
				.stream()
				.map(progetto -> mapper.toDTO(progetto))
				.collect(Collectors.toList());
		return progettiToDTO;
	}
	
}
