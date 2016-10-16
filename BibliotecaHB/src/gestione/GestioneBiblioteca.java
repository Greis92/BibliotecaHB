package gestione;

import dao.LibroDao;
import model.Biblioteca;
import model.Libro;

public class GestioneBiblioteca {
	
	LibroDao lDao = new LibroDao();

	public Libro registraLibro(Biblioteca b, String titolo, String autore, int copie) {
		
		Libro l = lDao.readBookTitoloAutore(b,"titolo","autore");
		
		if(l == null){
			l = new Libro(titolo,autore,copie,copie);
			lDao.insertBook(l);
			b.addLibro(l);
		}
		l.setCopieDisponibili(l.getCopieDisponibili()+copie);  
		l.setCopieDisponibili(l.getCopieTotali()+copie);
		
		return l;
	}

}
