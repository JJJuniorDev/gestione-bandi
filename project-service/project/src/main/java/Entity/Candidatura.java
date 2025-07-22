package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidatura")
public class Candidatura {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  
	  private String title;
	  
	  private String description;
	  
	  private LocalDateTime dataInvio;
	  	  
	  private String status;// es: INVIATA, REVISIONE, ACCETTATA, RIFIUTATA
	  
	  @ManyToOne
	  @JoinColumn(name = "bando_id")
	  private Bando bando;
	  
	  private Long userId;
	  private LocalDate dataValutazione;
	// Cliente o ente per cui è presentata la candidatura (se applicabile)
	    private String cliente;

	    // Utente responsabile (solo id esterno, non join a User)
	    private String responsabileId;
	  public Long getId() {
		  return id;
	  }

	  public void setId(Long id) {
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

	
	
	  public Bando getBando() {
		return bando;
	}

	  public void setBando(Bando bando) {
		  this.bando = bando;
	  }

	  public Long getUserId() {
		  return userId;
	  }

	  public void setUserId(Long userId) {
		  this.userId = userId;
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
