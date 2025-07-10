package dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BandoDTO {

	private String id;
	private String titolo;
	 private String descrizione;
	  private LocalDate dataInizio;
	  private LocalDate dataFine;
	  private String categoria;
	  private boolean aperto;
	  private List<CandidaturaDTO> candidature=new ArrayList<CandidaturaDTO>();
	  
	  public String getId() {
		  return id;
	  }
	  public void setId(String id) {
		  this.id = id;
	  }
	  public String getTitolo() {
		  return titolo;
	  }
	  public void setTitolo(String titolo) {
		  this.titolo = titolo;
	  }
	  public String getDescrizione() {
		  return descrizione;
	  }
	  public void setDescrizione(String descrizione) {
		  this.descrizione = descrizione;
	  }
	  public LocalDate getDataInizio() {
		  return dataInizio;
	  }
	  public void setDataInizio(LocalDate dataInizio) {
		  this.dataInizio = dataInizio;
	  }
	  public LocalDate getDataFine() {
		  return dataFine;
	  }
	  public void setDataFine(LocalDate dataFine) {
		  this.dataFine = dataFine;
	  }
	  public String getCategoria() {
		  return categoria;
	  }
	  public void setCategoria(String categoria) {
		  this.categoria = categoria;
	  }
	  public boolean isAperto() {
		  return aperto;
	  }
	  public void setAperto(boolean aperto) {
		  this.aperto = aperto;
	  }
	  public List<CandidaturaDTO> getCandidature() {
		  return candidature;
	  }
	  public void setCandidature(List<CandidaturaDTO> candidature) {
		  this.candidature = candidature;
	  }
	  
	  
}
