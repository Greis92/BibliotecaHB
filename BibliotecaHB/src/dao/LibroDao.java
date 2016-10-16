package dao;

import hibernateUtil.HibernateUtil;
import model.Biblioteca;
import model.Libro;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LibroDao {
	
	
	public boolean insertBook(Libro l) {
		
		boolean res = false;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			// INIZIO ELABORAZIONE DATI
			
			session.persist(l);
			tx.commit(); //INSERISCE NEL DATABASE
			res = true;
		
		}catch(Exception e){ 
			
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
			
		}finally{
			
			session.close();
			
		}
		
		return res;

	}
	
	
	
	public Libro readBookConId(Long id) {
		
		Libro l = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
				
			// INIZIO ELABORAZIONE DATI
				
			session.get(Libro.class,id);
			tx.commit(); //INSERISCE NEL DATABASE
				
			
		}catch(Exception e){ 
				
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
				
		}finally{
				
			session.close();
				
		}
			
			return l;
			
	}
	
	
	
	public Libro readBookTitoloAutore(Biblioteca b,String tit,String aut) {

		Libro l = null;
			
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
				
			// INIZIO ELABORAZIONE DATI
				
			Query query = session.createQuery("from Libro where titolo =: titoloInserito"
					+ "and autore =: autoreInserito where id_biblioteca =: idB");
			
			query.setString("titoloInserito", tit);
			query.setString("autoreInserito", aut);
			query.setLong("idB", b.getId_biblioteca());
			
			l = (Libro) query.uniqueResult();
				
			tx.commit(); //INSERISCE NEL DATABASE
				
			
		}catch(Exception e){ 
				
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
				
		}finally{
				
			session.close();
				
		}
			
		return l;
			
	}

	public boolean updateBook(Libro l) {
		
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.update(l);
			tx.commit(); // INSERISCE NEL DATABASE
			res = true;

		} catch (Exception e) {

			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE
							// FATTA SOPRA

		} finally {

			session.close();

		}

		return res;
	}
	
	
	
	
	public boolean deleteBook(Libro l) {

		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.delete(l);
			tx.commit(); // INSERISCE NEL DATABASE
			res = true;

		} catch (Exception e) {

			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE
							// FATTA SOPRA

		} finally {

			session.close();

		}

		return res;
	}



	

}
