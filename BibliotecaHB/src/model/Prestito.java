package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_prestito;
	
	private Date dataInizioPrestito;
	private Date dataRestituzionePrestito;
	
	@ManyToOne
	private Utente utenti;
	
	@ManyToOne
	private Libro libri;
	
	@ManyToOne
	private Biblioteca biblio;
	
	
	public Prestito(){}


	public Prestito(Date dataInizioPrestito, Date dataRestituzionePrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrestito = dataRestituzionePrestito;
	}


	public Long getId_prestito() {
		return id_prestito;
	}


	public void setId_prestito(Long id_prestito) {
		this.id_prestito = id_prestito;
	}


	public Date getDataInizioPrestito() {
		return dataInizioPrestito;
	}


	public void setDataInizioPrestito(Date dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}


	public Date getDataRestituzionePrestito() {
		return dataRestituzionePrestito;
	}


	public void setDataRestituzionePrestito(Date dataRestituzionePrestito) {
		this.dataRestituzionePrestito = dataRestituzionePrestito;
	}


	public Utente getUtenti() {
		return utenti;
	}


	public void setUtenti(Utente utenti) {
		this.utenti = utenti;
	}


	public Libro getLibri() {
		return libri;
	}


	public void setLibri(Libro libri) {
		this.libri = libri;
	}


	public Biblioteca getBiblio() {
		return biblio;
	}


	public void setBiblio(Biblioteca biblio) {
		this.biblio = biblio;
	}
	
	
		
	

}
