package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Ente;
import dto.EnteDTO;
import mapper.EnteMapper;
import repository.EnteRepository;

@Service
public class EnteService {

    private final EnteMapper enteMapper;

	@Autowired
	private EnteRepository enteRepository;

    EnteService(EnteMapper enteMapper) {
        this.enteMapper = enteMapper;
    }
	
	public List<EnteDTO> getAllEnti(){
		List <Ente> entiTrovati=enteRepository.findAll();
		List <EnteDTO> allEntiDto= entiTrovati.stream().map(EnteMapper::toDTO).collect(Collectors.toList());
		return allEntiDto;
	}

	public EnteDTO getEnteById(String id) {
		Long idToLong=Long.valueOf(id);
		Optional<Ente> enteOpt= enteRepository.findById(idToLong);
		Ente ente= enteOpt.get();
		EnteDTO enteDTO= EnteMapper.toDTO(ente);
		return enteDTO;
	}
}
