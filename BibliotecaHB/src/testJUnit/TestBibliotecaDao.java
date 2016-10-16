package testJUnit;

import static org.junit.Assert.*;
import model.Biblioteca;

import org.junit.Test;

import dao.BibliotecaDao;

public class TestBibliotecaDao {

	@Test
	public void test() {
		
		BibliotecaDao bDao = new BibliotecaDao();
		
		// CREATE BIBLIOTECA
		Biblioteca b1 = new Biblioteca("Grazia");
		boolean creata = bDao.createBiblioteca(b1);
		
		assertTrue(creata);
		
		// READ BIBLIOTECA CON ID
//		Biblioteca b1Temp = new Biblioteca();
//		bDao.createBiblioteca(b1Temp);
//		b1Temp = bDao.readBibliotecaConId(b1.getId_biblioteca());
//		
//		assertEquals(b1Temp,b1);
		
		
		// UPDATE BIBLIOTECA
		b1.setNomeBiblioteca("Maria");
		boolean aggiornata = bDao.updateBiblioteca(b1);
		
		assertTrue(aggiornata);
		
		
		// DELETE BIBLIOTECA
		boolean cancellata = bDao.deleteBiblioteca(b1);
		
		assertTrue(cancellata);
	}

}
