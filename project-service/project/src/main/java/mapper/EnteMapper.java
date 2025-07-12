package mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import Entity.Bando;
import Entity.Ente;
import dto.BandoDTO;
import dto.EnteDTO;

@Component
public class EnteMapper {

	public static EnteDTO toDTO (Ente ente) {
		if (ente == null) return null;
		EnteDTO dto = new EnteDTO();
		dto.setId(ente.getId() != null ? ente.getId().toString() : null);
		dto.setNome(ente.getNome());
		dto.setCodiceIstat(ente.getCodiceIstat());
		dto.setEmail(ente.getEmail());
		dto.setTipoEnte(ente.getTipoEnte());
		List<BandoDTO> listaToDTO= ente.getBandiAppartenenti().stream().map(BandoMapper::toDTO).collect(Collectors.toList());
		dto.setBandiAppartenenti(listaToDTO);
		return dto;
	}
	
	
	public static Ente toEntity(EnteDTO dto) {
		if (dto == null) return null;
		Ente ente= new Ente();
		ente.setId(ente.getId() != null ? Long.valueOf(dto.getId()) : null);
		ente.setNome(dto.getNome());
		ente.setCodiceIstat(ente.getCodiceIstat());
		ente.setEmail(dto.getEmail());
		ente.setTipoEnte(dto.getTipoEnte());
		List<Bando> listaToEntity= dto.getBandiAppartenenti().stream().map(BandoMapper::toEntity).collect(Collectors.toList());
		ente.setBandiAppartenenti(listaToEntity);
		return ente;
	}
}
