package dao;

import hibernateUtil.HibernateUtil;
import model.Biblioteca;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BibliotecaDao {

	
	public boolean createBiblioteca(Biblioteca b) {
		
		boolean res = false;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			// INIZIO ELABORAZIONE DATI
			
			session.persist(b);
			tx.commit(); //INSERISCE NEL DATABASE
			res = true;
		
		}catch(Exception e){ 
			
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
			
		}finally{
			
			session.close();
			
		}
		
		return res;

	}
	
	
	public Biblioteca readBibliotecaConId(Long id) {

		Biblioteca b = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			// INIZIO ELABORAZIONE DATI
			
			session.get(Biblioteca.class,id);
			tx.commit(); //INSERISCE NEL DATABASE
			
		
		}catch(Exception e){ 
			
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
			
		}finally{
			
			session.close();
			
		}
		
		return b;
		
	}
	
	
	
	public Biblioteca readBibliotecaConNome(String n) {

		Biblioteca b = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			// INIZIO ELABORAZIONE DATI
			
			Query query = session.createQuery("from Biblioteca where nomeBiblioteca =: nomeInserito");
			query.setString("nomeInserito", n);
			
			b = (Biblioteca) query.uniqueResult();
			
			tx.commit(); //INSERISCE NEL DATABASE
			
		
		}catch(Exception e){ 
			
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
			
		}finally{
			
			session.close();
			
		}
		
		return b;
		
	}
	
	
	
	public boolean updateBiblioteca(Biblioteca b){
		
		boolean res = false;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			// INIZIO ELABORAZIONE DATI
			
			session.update(b);
			tx.commit(); //INSERISCE NEL DATABASE
			res = true;
		
		}catch(Exception e){ 
			
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
			
		}finally{
			
			session.close();
			
		}
		
		return res;
	}
	
	
	
	public boolean deleteBiblioteca(Biblioteca b){
		
		boolean res = false;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			
			// INIZIO ELABORAZIONE DATI
			
			session.delete(b);
			tx.commit(); //INSERISCE NEL DATABASE
			res = true;
		
		}catch(Exception e){ 
			
			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
			
		}finally{
			
			session.close();
			
		}
		
		return res;
	}

	
}
