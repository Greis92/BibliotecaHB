package dao;

import hibernateUtil.HibernateUtil;
import model.Prestito;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PrestitoDao {

	// 1-CREATE PRESTITO
	public boolean createPrestito(Prestito p) {

		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.persist(p);
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

	// 2-READ PRESTITO CON ID
	public Prestito readPrestitoConId(Long id) {

		Prestito p = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.get(Prestito.class, id);
			tx.commit(); // INSERISCE NEL DATABASE

		} catch (Exception e) {

			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE
							// FATTA SOPRA

		} finally {

			session.close();

		}

		return p;

	}

	// 2-READ PRESTITO CON IDLIBRO E IDUTENTE
	public Prestito readPrestitoConId(Long id_libro, Long id_utente) {

		Prestito p = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			Query query = session
					.createQuery("from Prestito where id_libro =: idL and id_utente =: idU");

			query.setLong("idL", id_libro);
			query.setLong("idU", id_utente);

			p = (Prestito) query.uniqueResult();

			tx.commit(); // INSERISCE NEL DATABASE

		} catch (Exception e) {

			tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE
							// FATTA SOPRA

		} finally {

			session.close();

		}

		return p;

	}

	// 3- UPDATE PRESTITO
	public boolean updatePrestito(Prestito p) {

		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.update(p);
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

	// 4- DELETE PRESTITO
	public boolean deletePrestito(Prestito p) {

		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			// INIZIO ELABORAZIONE DATI

			session.delete(p);
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
