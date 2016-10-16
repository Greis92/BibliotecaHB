package testJUnit;

import static org.junit.Assert.*;
import model.Libro;

import org.junit.Test;

import dao.LibroDao;

public class TestLibroDao {

	@Test
	public void test() {
		
		LibroDao lDao = new LibroDao();
		
		// INSERT BOOK
		Libro l1 = new Libro();
		boolean inserito = lDao.insertBook(l1);
		
		assertTrue(inserito);
		
		// READ BOOK CON ID
		Libro l2 = lDao.readBookConId((long) 70);
		Libro lTemp = l2;
		
		assertEquals(l2,lTemp);
		
		// UPDATE BOOK
		l1.setAutore("abc");
		l1.setTitolo("def");
		l1.setCopieDisponibili(10);
		l1.setCopieTotali(10);
		
		boolean aggiornato = lDao.updateBook(l1);
		
		assertTrue(aggiornato);
		
		// DELETE BOOK
		boolean cancellato = lDao.deleteBook(l1);
		
		assertTrue(cancellato);
	}

}
