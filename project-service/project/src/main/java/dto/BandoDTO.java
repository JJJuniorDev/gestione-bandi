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
	  private EnteDTO ente;
	  private String budgetTotale;
	  private String finanziamentoMassimo;
	  private String quotaContributo;
	  private String tipoOrigine;
	  private String linkUfficiale;
	  private String stato;
	  private List<String> documentiRichiesti;
	  private String responsabile;
	  
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
	  public EnteDTO getEnte() {
		  return ente;
	  }
	  public void setEnte(EnteDTO ente) {
		  this.ente = ente;
	  }
	  public String getBudgetTotale() {
		  return budgetTotale;
	  }
	  public void setBudgetTotale(String budgetTotale) {
		  this.budgetTotale = budgetTotale;
	  }
	  public String getFinanziamentoMassimo() {
		  return finanziamentoMassimo;
	  }
	  public void setFinanziamentoMassimo(String finanziamentoMassimo) {
		  this.finanziamentoMassimo = finanziamentoMassimo;
	  }
	  public String getQuotaContributo() {
		  return quotaContributo;
	  }
	  public void setQuotaContributo(String quotaContributo) {
		  this.quotaContributo = quotaContributo;
	  }
	  public String getTipoOrigine() {
		  return tipoOrigine;
	  }
	  public void setTipoOrigine(String tipoOrigine) {
		  this.tipoOrigine = tipoOrigine;
	  }
	  public String getLinkUfficiale() {
		  return linkUfficiale;
	  }
	  public void setLinkUfficiale(String linkUfficiale) {
		  this.linkUfficiale = linkUfficiale;
	  }
	  public String getStato() {
		  return stato;
	  }
	  public void setStato(String stato) {
		  this.stato = stato;
	  }
	  public List<String> getDocumentiRichiesti() {
		  return documentiRichiesti;
	  }
	  public void setDocumentiRichiesti(List<String> documentiRichiesti) {
		  this.documentiRichiesti = documentiRichiesti;
	  }
	  public String getResponsabile() {
		  return responsabile;
	  }
	  public void setResponsabile(String responsabile) {
		  this.responsabile = responsabile;
	  }
	  
	  
}
