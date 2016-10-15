package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Prestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id_prestito;
	
	private Date dataInizioPrestito;
	private Date dataRestituzionePrestito;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="prestito",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Utente> utenti=new HashSet<>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="prestito",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Libro> libri=new HashSet<>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="prestito",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Biblioteca> biblio=new HashSet<>();
	
	
	public Prestito(){}


	public Prestito(Date dataInizioPrestito, Date dataRestituzionePrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrestito = dataRestituzionePrestito;
	}


	public String getId_prestito() {
		return id_prestito;
	}


	public void setId_prestito(String id_prestito) {
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


	public Set<Utente> getUtenti() {
		return utenti;
	}


	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}


	public Set<Libro> getLibri() {
		return libri;
	}


	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}


	public Set<Biblioteca> getBiblio() {
		return biblio;
	}


	public void setBiblio(Set<Biblioteca> biblio) {
		this.biblio = biblio;
	}
	
	
		
	

}
