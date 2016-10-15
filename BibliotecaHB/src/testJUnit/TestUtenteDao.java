package testJUnit;

import static org.junit.Assert.*;
import model.Utente;

import org.junit.Test;

import dao.UtenteDao;

public class TestUtenteDao {

	@Test
	public void test() {
		
		 // INSERTUSER
		UtenteDao uDao = new UtenteDao();
		Utente u = new Utente("aaa","aaa","aaa");
		boolean inserito = uDao.insertUser(u);
		
		assertTrue(inserito);
	}

}
