package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Candidatura;
import dto.CandidaturaDTO;
import enums.CandidaturaStatus;
import exception.RisorsaNonTrovataException;
import mapper.CandidaturaMapper;
import repository.CandidaturaRepository;


@Service
public class CandidaturaService {

	@Autowired
	private CandidaturaRepository candidaturaRepo;

	@Autowired
	private CandidaturaMapper mapper;
	
	public List<CandidaturaDTO> getAllCandidature() {
		// TODO Auto-generated method stub
	
	List<Candidatura> candidatureTrovate= candidaturaRepo.findAll();
	 List<CandidaturaDTO> candidatureToDTO= candidatureTrovate.stream()
             .map(candidatura -> mapper.toDTO(candidatura))
             .collect(Collectors.toList());
	 
	 return candidatureToDTO;
}

	public CandidaturaDTO getCandidaturaById(String id) {
		Long idConverted= Long.valueOf(id);
		Optional<Candidatura> candidaturaTrovatoOptional= candidaturaRepo.findById(idConverted);
		
		if (candidaturaTrovatoOptional.isEmpty()) {
	        throw new RisorsaNonTrovataException("Candidatura con id " + id + " non trovata");
	    }
		Candidatura candidaturaTrovata= candidaturaTrovatoOptional.get();
		CandidaturaDTO progettoToDTO= mapper.toDTO(candidaturaTrovata);
		return progettoToDTO;
	}

	public List<CandidaturaDTO> getCandidatureByUserId(String userId) {
		Long idConverted= Long.valueOf(userId);
		Optional<List<Candidatura>> candidatureTrovateOptional= candidaturaRepo.findAllByUserId(idConverted);
		List<Candidatura> candidature=candidatureTrovateOptional.get();
		List<CandidaturaDTO> candidatureToDTO= candidature.stream().
				map(candidatura -> mapper.toDTO(candidatura))
				.collect(Collectors.toList());
		
		return candidatureToDTO;
	}

	public CandidaturaDTO createCandidatura(CandidaturaDTO candidaturaDTO) {
		candidaturaDTO.setStatus(CandidaturaStatus.INVIATA.name());
		Candidatura candidaturaDTOtoEntity =mapper.toEntity(candidaturaDTO);
		candidaturaRepo.save(candidaturaDTOtoEntity);
		return candidaturaDTO;
	}
	
}
