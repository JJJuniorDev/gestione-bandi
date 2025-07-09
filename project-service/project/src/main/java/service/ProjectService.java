package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Candidatura;
import dto.CandidaturaDTO;
import mapper.CandidaturaMapper;
import repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private CandidaturaMapper mapper;
	
	public List<CandidaturaDTO> getAllCandidature() {
		// TODO Auto-generated method stub
	
	List<Candidatura> candidatureTrovate= projectRepo.findAll();
	 List<CandidaturaDTO> candidatureToDTO= candidatureTrovate.stream()
             .map(candidatura -> mapper.toDTO(candidatura))
             .collect(Collectors.toList());
	 
	 return candidatureToDTO;
}

	public CandidaturaDTO getCandidaturaById(String id) {
		Long idConverted= Long.valueOf(id);
		Optional<Candidatura> candidaturaTrovatoOptional= projectRepo.findById(idConverted);
		Candidatura candidaturaTrovata= candidaturaTrovatoOptional.get();
		CandidaturaDTO progettoToDTO= mapper.toDTO(candidaturaTrovata);
		return progettoToDTO;
	}

	public List<CandidaturaDTO> getCandidatureByUserId(String userId) {
		Long idConverted= Long.valueOf(userId);
		Optional<List<Candidatura>> candidatureTrovateOptional= projectRepo.findAllByUserId(idConverted);
		List<Candidatura> candidature=candidatureTrovateOptional.get();
		List<CandidaturaDTO> candidatureToDTO= candidature.stream().
				map(candidatura -> mapper.toDTO(candidatura))
				.collect(Collectors.toList());
		
		return candidatureToDTO;
	}
	
}
