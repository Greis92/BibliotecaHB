package testJUnit;

import static org.junit.Assert.*;
import gestione.GestioneBiblioteca;
import model.Biblioteca;
import model.Libro;

import org.junit.Test;

import dao.BibliotecaDao;

public class TestGestione {

	@Test
	public void test() {
		
		GestioneBiblioteca gB = new GestioneBiblioteca();
		Biblioteca b = new Biblioteca("Armenia");
		BibliotecaDao bDao = new BibliotecaDao();
		
		// REGISTRA LIBRO
		bDao.createBiblioteca(b);
		Libro l1 = gB.registraLibro(b,"Amare","Germonio",10);
		
		assertNotNull(l1);
	}

}
