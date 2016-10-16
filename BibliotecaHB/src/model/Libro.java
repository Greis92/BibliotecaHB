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
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_libro;

	private String titolo;
	private String autore;

	private int copieTotali;
	private int copieDisponibili;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "libri", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Prestito> prestiti = new HashSet<>();

	@ManyToMany
	private Set<Biblioteca> biblioL = new HashSet<>();

	public Libro() {
		this.titolo = "";
		this.autore = "";
		this.copieTotali = 0;
		this.copieDisponibili = 0;
	}

	public Libro(String titolo, String autore, int copieTotali,
			int copieDisponibili) {
		this.titolo = titolo;
		this.autore = autore;
		this.copieTotali = copieTotali;
		this.copieDisponibili = copieDisponibili;
	}

	public Long getId_libro() {
		return id_libro;
	}

	public void setId_libro(Long id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getCopieTotali() {
		return copieTotali;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}

	public Set<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestito(Set<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	public Set<Biblioteca> getBiblioL() {
		return biblioL;
	}

	public void setBiblioL(Set<Biblioteca> biblioL) {
		this.biblioL = biblioL;
	}

}
