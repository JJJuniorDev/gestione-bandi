package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Bando;
import dto.BandoDTO;
import mapper.BandoMapper;
import repository.BandoRepository;

@Service
public class BandoService {

	@Autowired
	private BandoRepository bandoRepository;
	
	@Autowired
	private BandoMapper mapper;
	
	public List<BandoDTO> getAllBandi(){
		List<Bando> bandiTrovati= bandoRepository.findAll();
		List<BandoDTO> bandiToDTO= bandiTrovati.stream().map(bando -> mapper.toDTO(bando))
				.collect(Collectors.toList());
		return bandiToDTO;
	}
}
