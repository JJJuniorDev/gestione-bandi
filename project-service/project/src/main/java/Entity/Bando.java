package Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bando")
public class Bando {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titolo;
  private String descrizione;
  private LocalDate dataInizio;
  private LocalDate dataFine;
  private String categoria;
  private boolean aperto;
  public Long getId() {
	return id;
  }
  public void setId(Long id) {
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

  // altro: importo massimo, documento PDF, requisiti, ecc.
  
  
}
