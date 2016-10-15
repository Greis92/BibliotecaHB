package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Biblioteca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id_biblioteca;
	
	private String nomeBiblioteca;
	
	@ManyToOne
	private Prestito prestito;
	
	@ManyToMany(mappedBy="biblioU",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Utente> utente = new HashSet<>();
	
	@ManyToMany(mappedBy="biblioL",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Libro> libri = new HashSet<>();
	
	
	
	public Biblioteca(){
		this.nomeBiblioteca = "";
	}

	public Biblioteca(String nomeBiblioteca) {
		this.nomeBiblioteca = nomeBiblioteca;
	}

	public String getId_biblioteca() {
		return id_biblioteca;
	}

	public void setId_biblioteca(String id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}

	public String getNomeBiblioteca() {
		return nomeBiblioteca;
	}

	public void setNomeBiblioteca(String nomeBiblioteca) {
		this.nomeBiblioteca = nomeBiblioteca;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
	}

	public Set<Utente> getUtente() {
		return utente;
	}

	public void setUtente(Set<Utente> utente) {
		this.utente = utente;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}
	
	
	
	
}
