package mapper;

import org.springframework.stereotype.Component;

import Entity.Bando;
import dto.BandoDTO;

@Component
public class BandoMapper {

	public static BandoDTO toDTO(Bando bando) {
		if (bando == null) return null;
		BandoDTO dto = new BandoDTO();
		dto.setId(bando.getId() != null ? bando.getId().toString() : null);
	    dto.setTitolo(bando.getTitolo());
	    dto.setDescrizione(bando.getDescrizione());
	    dto.setCategoria(bando.getCategoria());
	    dto.setDataInizio(bando.getDataInizio());
	    dto.setDataFine(bando.getDataFine());
	    dto.setAperto(bando.isAperto());
	    dto.setStato(bando.getStato());
	    return dto;
	}
	
	public static Bando toEntity(BandoDTO bandoDTO) {
		if (bandoDTO== null) return null;
		Bando bando= new Bando();
		bando.setId(bandoDTO.getId() != null ? Long.valueOf(bandoDTO.getId()) : null);
	    bando.setDescrizione(bandoDTO.getDescrizione());
	    bando.setTitolo(bandoDTO.getTitolo());
	    bando.setCategoria(bandoDTO.getCategoria());
	    bando.setAperto(bandoDTO.isAperto());
	    bando.setDataInizio(bandoDTO.getDataInizio());
	    bando.setDataFine(bandoDTO.getDataFine());
	    bando.setStato(bandoDTO.getStato());
	    return bando;
	}
}
