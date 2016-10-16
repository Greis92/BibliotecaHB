package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_utente;
	
	private String nome;
	private String cognome;
	private String cf;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Libro> libri = new HashSet<Libro>(3);
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="utenti",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Prestito> prestiti=new HashSet<>();
	
	@ManyToMany
	private Set<Biblioteca> biblioU = new HashSet<>();
	
	
	
	public Utente(){
		this.nome = "";
		this.cognome = "";
		this.cf = "";
	}

	public Utente(String nome, String cognome, String cf) {
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}

	public Long getId_utente() {
		return id_utente;
	}

	public void setId_utente(Long id_utente) {
		this.id_utente = id_utente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}

	public Set<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(Set<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	public Set<Biblioteca> getBiblioU() {
		return biblioU;
	}

	public void setBiblioU(Set<Biblioteca> biblioU) {
		this.biblioU = biblioU;
	}
	
	
	
}
