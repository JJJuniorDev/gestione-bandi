package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
  //CASCADE= SE ELIMINO UN BANDO ANCHE TUTTE LE CANDIDATURE CORRELATA
  //ORPHAN REMOVAL SE CANDIDATURA RIMOSSA DALL'ARRAY ANCHE DAL DB
  @OneToMany(mappedBy = "bando", cascade= CascadeType.ALL, orphanRemoval = true)
  private List<Candidatura> candidatureBando= new ArrayList<Candidatura>(); 
  
  @ManyToOne
  @JoinColumn(name = "ente_id")  // colonna FK nella tabella 'bando'
  private Ente ente;
  
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
  public List<Candidatura> getCandidatureBando() {
	return candidatureBando;
  }
  public void setCandidatureBando(List<Candidatura> candidatureBando) {
	this.candidatureBando = candidatureBando;
  }
  public Ente getEnte() {
	return ente;
  }
  public void setEnte(Ente ente) {
	this.ente = ente;
  }

  
  // altro: importo massimo, documento PDF, requisiti, ecc.
  
  
}
