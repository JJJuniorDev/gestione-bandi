package service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import mapper.CandidaturaMapper;
import mapper.EnteMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jwt.token.JwtUtil;

import Entity.Bando;
import Entity.Candidatura;
import Entity.Ente;
import config.CorsConfig;
import config.SecurityConfig;
import dto.BandoDTO;
import jakarta.persistence.EntityManager;
import mapper.BandoMapper;
import repository.BandoRepository;

@Service
public class BandoService {

    private final SecurityConfig securityConfig;
	
	private final JwtUtil jwtUtil = null;

    private final CandidaturaMapper candidaturaMapper;

    private final CorsConfig corsConfig;

	@Autowired
	private BandoRepository bandoRepository;
	
	@Autowired
	private BandoMapper bandoMapper;
	
	@Autowired
	private EnteMapper enteMapper;

	@Autowired
	private EntityManager entityManager;
	
    BandoService(CorsConfig corsConfig, CandidaturaMapper candidaturaMapper, SecurityConfig securityConfig) {
        this.corsConfig = corsConfig;
        this.candidaturaMapper = candidaturaMapper;
        this.securityConfig = securityConfig;
    }
	
	public List<BandoDTO> getAllBandi(){
		List<Bando> bandiTrovati= bandoRepository.findAll();
		List<BandoDTO> bandiToDTO= bandiTrovati.stream().map(bando -> bandoMapper.toDTO(bando))
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
	    bando.setEnte(bandoMapper.toEntity(bandoDTO).getEnte());
	    if (bandoDTO.getCandidature() != null) {
	    List<Candidatura>candidatureFromDTO=bandoDTO.getCandidature()
	    		.stream()
	    		.map(candidatura -> candidaturaMapper.toEntity(candidatura))
	    		.collect(Collectors.toList());
	   
	    bando.setCandidatureBando(candidatureFromDTO);
	    }
	    Bando saved = bandoRepository.save(bando);
	    return bandoMapper.toDTO(saved); // Converte Entity → DTO
	    
}

	public BandoDTO updateBando(BandoDTO bando) {
		Long bandoId= Long.valueOf(bando.getId());
		Optional <Bando> bandoOpt= bandoRepository.findById(bandoId);
		Bando bandoEntity= bandoOpt.get();
		if (bandoOpt.isEmpty()) {
			throw new NoSuchElementException("Bando non trovato");
		}
		bandoEntity.setTitolo(bando.getTitolo());
		bandoEntity.setStato(bando.getStato());	
		bandoEntity.setDescrizione(bando.getDescrizione());
		bandoEntity.setCategoria(bando.getCategoria());
		bandoEntity.setDataInizio(bando.getDataInizio());
		bandoEntity.setDataFine(bando.getDataFine());
		bandoEntity.setAperto(bando.isAperto());
		if (bando.getEnte() != null && bando.getEnte().getId() != null) {
	        Ente enteRef = entityManager.getReference(Ente.class, bando.getEnte().getId());
	        bandoEntity.setEnte(enteRef);
	    }
		//bandoEntity.setResponsabile(bando.getResponsabile());
		//bandoEntity.setTipoOrigine(null);
		//bandoEntity.setBudgetTotale(bando.getBudgetTotale());
		//bandoEntity.setDocumentiRichiesti(bando.getDocumentiRichiesti());
		//bandoEntity.setFinanziamentoMassimo(bando.getFinanziamentoMassimo());
		//bandoEntity.setLinkUfficiale(bando.getLinkUfficiale());
		//bandoEntity.setQuotaContributo(bando.getQuotaContributo());
		Bando updated=bandoRepository.save(bandoEntity);
		return bandoMapper.toDTO(updated);
	}

	public BandoDTO publicateBando(String bandoId) {
		Long bandoIdLong= Long.valueOf(bandoId);
		Optional <Bando> bandoOpt=bandoRepository.findById(bandoIdLong);
		if (bandoOpt.isEmpty()) {
			throw new NoSuchElementException("Bando non trovato");
		}
		Bando bando= bandoOpt.get();
		bando.setStato("PUBBLICATO");
	Bando saved=bandoRepository.save(bando);
	BandoDTO bandoDTO=bandoMapper.toDTO(saved);
	return bandoDTO;
		
	}

	public BandoDTO validateBando(String bandoId) {
		Long bandoIdLong= Long.valueOf(bandoId);
		Optional <Bando> bandoOpt=bandoRepository.findById(bandoIdLong);
		if (bandoOpt.isEmpty()) {
			throw new NoSuchElementException("Bando non trovato");
		}
		Bando bando= bandoOpt.get();
		bando.setStato("VALIDATO");
		Bando validated=bandoRepository.save(bando);
		BandoDTO bandoDTO=bandoMapper.toDTO(validated);
		return bandoDTO;
	}
}
