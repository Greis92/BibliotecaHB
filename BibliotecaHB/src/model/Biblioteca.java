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
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_biblioteca;

	private String nomeBiblioteca;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "biblio", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Prestito> prestiti = new HashSet<>();

	@ManyToMany(mappedBy = "biblioU", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Utente> utenti = new HashSet<>();

	@ManyToMany(mappedBy = "biblioL", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Libro> libri = new HashSet<>();

	public Biblioteca() {
		this.nomeBiblioteca = "";
	}

	public Biblioteca(String nomeBiblioteca) {
		this.nomeBiblioteca = nomeBiblioteca;
	}

	public Long getId_biblioteca() {
		return id_biblioteca;
	}

	public void setId_biblioteca(Long id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}

	public String getNomeBiblioteca() {
		return nomeBiblioteca;
	}

	public void setNomeBiblioteca(String nomeBiblioteca) {
		this.nomeBiblioteca = nomeBiblioteca;
	}

	public Set<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(Set<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtente(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}

	public void addLibro(Libro l) {
		this.libri.add(l);
	}

	public void addUtente(Utente u) {
		this.utenti.add(u);
	}

	public void addPrestiti(Prestito p) {
		this.prestiti.add(p);
	}

}
