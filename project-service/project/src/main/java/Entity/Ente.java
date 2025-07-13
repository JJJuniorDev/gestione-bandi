package Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ente")
public class Ente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome; //Milano Roma etc
	
	private String codiceIstat; //CODICE ISTAT COMUNE
	
	private String email; //EMAIL UFFICIALE
	
	private String tipoEnte; //PROVINCIA, COMUNE; REGIONE ecc.
	
	@OneToMany(mappedBy = "ente", cascade= CascadeType.ALL, orphanRemoval = true )
	private List<Bando> bandiAppartenenti = new ArrayList<Bando>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceIstat() {
		return codiceIstat;
	}

	public void setCodiceIstat(String codiceIstat) {
		this.codiceIstat = codiceIstat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoEnte() {
		return tipoEnte;
	}

	public void setTipoEnte(String tipoEnte) {
		this.tipoEnte = tipoEnte;
	}

	public List<Bando> getBandiAppartenenti() {
		return bandiAppartenenti;
	}

	public void setBandiAppartenenti(List<Bando> bandiAppartenenti) {
		this.bandiAppartenenti = bandiAppartenenti;
	}
	
	
}
