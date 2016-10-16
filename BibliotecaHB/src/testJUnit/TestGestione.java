package testJUnit;

import static org.junit.Assert.*;
import gestione.GestioneBiblioteca;
import model.Biblioteca;
import model.Libro;
import model.Utente;

import org.junit.Test;

import dao.BibliotecaDao;

public class TestGestione {

	@Test
	public void test() {
		
		GestioneBiblioteca gB = new GestioneBiblioteca();
		
		Biblioteca b = new Biblioteca("Armenia");
		BibliotecaDao bDao = new BibliotecaDao();
		bDao.createBiblioteca(b);
		
		// REGISTRA LIBRO
		Libro l1 = gB.registraLibro(b,"Amare","Germonio",10);
		
		assertNotNull(l1);
		
		// REGISTRA UTENTE
		Utente u1 = gB.registraUtente(b,"Barbara","Ponti","bpt");
		
		assertNotNull(u1);
		
		// PRESTA LIBRO
		boolean prestitoEffettuato = gB.prestaLibro(b,l1.getId_libro(),u1.getId_utente());
		
		assertTrue(prestitoEffettuato);
	}

}
