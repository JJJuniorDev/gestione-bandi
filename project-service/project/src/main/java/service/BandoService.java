package service;

import java.util.List;
import java.util.stream.Collectors;
import mapper.CandidaturaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.token.JwtUtil;

import Entity.Bando;
import Entity.Candidatura;
import config.CorsConfig;
import dto.BandoDTO;
import mapper.BandoMapper;
import repository.BandoRepository;

@Service
public class BandoService {
	
	private final JwtUtil jwtUtil = null;

    private final CandidaturaMapper candidaturaMapper;

    private final CorsConfig corsConfig;

	@Autowired
	private BandoRepository bandoRepository;
	
	@Autowired
	private BandoMapper mapper;

    BandoService(CorsConfig corsConfig, CandidaturaMapper candidaturaMapper) {
        this.corsConfig = corsConfig;
        this.candidaturaMapper = candidaturaMapper;
    }
	
	public List<BandoDTO> getAllBandi(){
		List<Bando> bandiTrovati= bandoRepository.findAll();
		List<BandoDTO> bandiToDTO= bandiTrovati.stream().map(bando -> mapper.toDTO(bando))
				.collect(Collectors.toList());
		return bandiToDTO;
	}
	
	public BandoDTO createBando(BandoDTO bandoDTO) {
		Bando bando= new Bando();
		bando.setTitolo(bandoDTO.getTitolo());
		bando.setDescrizione(bandoDTO.getDescrizione());
	    bando.setDataInizio(bandoDTO.getDataInizio());
	    bando.setDataFine(bandoDTO.getDataFine());
	    bando.setCategoria(bandoDTO.getCategoria());
	    bando.setAperto(bandoDTO.isAperto());
	    bando.setEnte(mapper.toEntity(bandoDTO).getEnte());
	    if (bandoDTO.getCandidature() != null) {
	    List<Candidatura>candidatureFromDTO=bandoDTO.getCandidature()
	    		.stream()
	    		.map(candidatura -> candidaturaMapper.toEntity(candidatura))
	    		.collect(Collectors.toList());
	   
	    bando.setCandidatureBando(candidatureFromDTO);
	    }
	    Bando saved = bandoRepository.save(bando);
	    return mapper.toDTO(saved); // Converte Entity → DTO
	    
}
}
