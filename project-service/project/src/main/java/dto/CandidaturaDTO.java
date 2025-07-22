package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import Entity.Bando;
import jakarta.persistence.ManyToOne;

public class CandidaturaDTO {

	private String id;
	
	private String title;
	
	private String description;
	
	 private LocalDateTime dataInvio;
 	  
	  private String status;
	  
	  private String userId;

	 
	  private BandoDTO bandoDTO;

	  private LocalDate dataValutazione;
	  
	  private String cliente;
	  
	  private String responsabileId;
	  
	  public String getId() {
		  return id;
	  }

	  public void setId(String id) {
		  this.id = id;
	  }

	  public String getTitle() {
		  return title;
	  }

	  public void setTitle(String title) {
		  this.title = title;
	  }

	  public String getDescription() {
		  return description;
	  }

	  public void setDescription(String description) {
		  this.description = description;
	  }

	  public LocalDateTime getDataInvio() {
		  return dataInvio;
	  }

	  public void setDataInvio(LocalDateTime dataInvio) {
		  this.dataInvio = dataInvio;
	  }

	  public String getStatus() {
		  return status;
	  }

	  public void setStatus(String status) {
		  this.status = status;
	  }

	  public String getUserId() {
		  return userId;
	  }

	  public void setUserId(String userId) {
		  this.userId = userId;
	  }

	  public BandoDTO getBandoDTO() {
		  return bandoDTO;
	  }

	  public void setBandoDTO(BandoDTO bandoDTO) {
		  this.bandoDTO = bandoDTO;
	  }

	  public LocalDate getDataValutazione() {
		  return dataValutazione;
	  }

	  public void setDataValutazione(LocalDate dataValutazione) {
		  this.dataValutazione = dataValutazione;
	  }

	  public String getCliente() {
		  return cliente;
	  }

	  public void setCliente(String cliente) {
		  this.cliente = cliente;
	  }

	  public String getResponsabileId() {
		  return responsabileId;
	  }

	  public void setResponsabileId(String responsabileId) {
		  this.responsabileId = responsabileId;
	  }

	 
	
	  
}
