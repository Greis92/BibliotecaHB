package dao;

import hibernateUtil.HibernateUtil;
import model.Biblioteca;
import model.Utente;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtenteDao {

	
	public boolean insertUser(Utente u) {
		
		boolean res = false;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			// INIZIO ELABORAZIONE DATI
			
			session.persist(u);
			tx.commit(); //INSERISCE NEL DATABASE
			res = true;
		
		}catch(Exception e){ 
			
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
			
		}finally{
			
			session.close();
			
		}
		
		return res;

	}

	
	public Utente readUserConId(Long id) {
		
		Utente u = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
				
			// INIZIO ELABORAZIONE DATI
				
			session.get(Utente.class,id);
			tx.commit(); //INSERISCE NEL DATABASE
				
			
		}catch(Exception e){ 
				
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
				
		}finally{
				
			session.close();
				
		}
			
			return u;
			
	}

	public Utente readAllUser(Biblioteca b, String n, String c, String cf) {
		
		Utente u = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
			
		try{
			tx = session.getTransaction();
			tx.begin();
				
			// INIZIO ELABORAZIONE DATI
				
			Query query = session.createQuery("from Utente where nome =: nomeInserito "
					+ "and cognome =: cognomeInserito and cf =: codiceFiscaleInserito "
					+ "and id_biblioteca =: idB");
			
			query.setString("nomeInserito", n);
			query.setString("cognomeInserito", c);
			query.setString("codiceFiscaleInserito", cf);
			query.setLong("idB", b.getId_biblioteca());
			
			u = (Utente) query.uniqueResult();
				
			tx.commit(); //INSERISCE NEL DATABASE
				
			
		}catch(Exception e){ 
				
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
				
		}finally{
				
			session.close();
				
		}
			
		return u;
			
	}
	
	
	public boolean updateUser(Utente u) {

		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.update(u);
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
	
	
	
	public boolean deleteUser(Utente u) {

		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.delete(u);
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
