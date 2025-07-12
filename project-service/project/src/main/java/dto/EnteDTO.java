package dto;

import java.util.ArrayList;
import java.util.List;

public class EnteDTO {

	private  String id;
	private String nome;
	private String codiceIstat;
	private String email;
	private String tipoEnte;
	private List<BandoDTO> bandiAppartenenti= new ArrayList<BandoDTO>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public List<BandoDTO> getBandiAppartenenti() {
		return bandiAppartenenti;
	}
	public void setBandiAppartenenti(List<BandoDTO> bandiAppartenenti) {
		this.bandiAppartenenti = bandiAppartenenti;
	}
	
	
}
