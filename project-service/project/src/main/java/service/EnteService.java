package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Ente;
import dto.EnteDTO;
import mapper.EnteMapper;
import repository.EnteRepository;

@Service
public class EnteService {

	@Autowired
	private EnteRepository enteRepository;
	
	public List<EnteDTO> getAllEnti(){
		List <Ente> entiTrovati=enteRepository.findAll();
		List <EnteDTO> allEntiDto= entiTrovati.stream().map(EnteMapper::toDTO).collect(Collectors.toList());
		return allEntiDto;
	}
}
