package mapper;

import org.springframework.stereotype.Component;

import Entity.Candidatura;
import dto.CandidaturaDTO;

@Component
public class CandidaturaMapper {

    public static CandidaturaDTO toDTO(Candidatura candidatura) {
        if (candidatura == null) return null;
        CandidaturaDTO dto = new CandidaturaDTO();
        dto.setId(candidatura.getId() != null ? candidatura.getId().toString() : null);
        dto.setTitle(candidatura.getTitle());
        dto.setDescription(candidatura.getDescription());
        dto.setDataInvio(candidatura.getDataInvio());
        dto.setStatus(candidatura.getStatus());
        dto.setUserId(candidatura.getUserId() != null ? candidatura.getUserId().toString() : null);
        // Converti il Bando in DTO, se esiste
        if (candidatura.getBando() != null) {
            dto.setBandoDTO(BandoMapper.toDTO(candidatura.getBando()));
        }
        return dto;
    }

    public static Candidatura toEntity(CandidaturaDTO dto) {
        if (dto == null) return null;
        Candidatura candidatura = new Candidatura();
        candidatura.setId(dto.getId() != null ? Long.valueOf(dto.getId()) : null);
        candidatura.setTitle(dto.getTitle());
        candidatura.setDescription(dto.getDescription());
        candidatura.setDataInvio(dto.getDataInvio());
        candidatura.setStatus(dto.getStatus());
        candidatura.setUserId(dto.getUserId() != null ? Long.valueOf(dto.getUserId()) : null);
        candidatura.setBando(BandoMapper.toEntity(dto.getBandoDTO()));//TRASFORMARE LISTA DA DTO A NORMAL
        return candidatura;
    }
}
