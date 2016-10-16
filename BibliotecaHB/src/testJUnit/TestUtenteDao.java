package testJUnit;

import static org.junit.Assert.*;
//import model.Biblioteca;
import model.Utente;

import org.junit.Test;

//import dao.BibliotecaDao;
import dao.UtenteDao;

public class TestUtenteDao {

	@Test
	public void test() {
		
		UtenteDao uDao = new UtenteDao();
		//BibliotecaDao bDao = new BibliotecaDao();
		
		// INSERT USER
		Utente u = new Utente("aaa","aaa","aaa");
		boolean inserito = uDao.insertUser(u);
		
		assertTrue(inserito);
		
		// READ USER CON ID
		Utente u1 = uDao.readUserConId((long) 22);
		Utente uTemp = u1;
		
		assertEquals(u1,uTemp);
		
		// READ USER CON NOME,COGNOME,CODICE FISCALE
//		Biblioteca b1 = new Biblioteca("Pedro");
//		bDao.createBiblioteca(b1);
//		
//		Utente u3 = new Utente("bbb","bbb","bbb");
//		uDao.insertUser(u3);
//		
//		Utente u2 = uDao.readAllUser(b1,"bbb","bbb","bbb");
//		Utente uTemp1 = u2;
//		
//		assertEquals(u2,uTemp1);
		
		// UPDATE USER
		u.setNome("ccc");
		u.setCognome("ccc");
		u.setCf("ccc");
	
		boolean aggiornato = uDao.updateUser(u);
		
		assertTrue(aggiornato);
		
		// DELETE USER
		boolean cancellato = uDao.deleteUser(u);
		
		assertTrue(cancellato);
	}

}
