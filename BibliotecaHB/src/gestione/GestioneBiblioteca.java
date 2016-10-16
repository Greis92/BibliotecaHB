package gestione;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import DateUtility.DateUtility;
import dao.LibroDao;
import dao.PrestitoDao;
import dao.UtenteDao;
import model.Biblioteca;
import model.Libro;
import model.Prestito;
import model.Utente;

public class GestioneBiblioteca {

	LibroDao lDao = new LibroDao();
	UtenteDao uDao = new UtenteDao();
	PrestitoDao pDao = new PrestitoDao();

	// 1-REGISTRA LIBRO
	public Libro registraLibro(Biblioteca b, String titolo, String autore,
			int copie) {

		Libro l = lDao.readBookTitoloAutore(titolo, autore);

		if (l == null) {
			l = new Libro(titolo, autore, copie, copie);
			lDao.insertBook(l);
			b.addLibro(l);
		}
		l.setCopieDisponibili(l.getCopieDisponibili() + copie);
		l.setCopieDisponibili(l.getCopieTotali() + copie);

		return l;

	}

	// 2-REGISTRA UTENTE
	public Utente registraUtente(Biblioteca b, String nome, String cognome,
			String codF) {

		Utente u = uDao.readAllUser(nome, cognome, codF);

		if (u == null) {
			u = new Utente(nome, cognome, codF);
			uDao.insertUser(u);
			b.addUtente(u);
		}

		return u;

	}

	// 3-PRESTA LIBRO
	public boolean prestaLibro(Biblioteca b, Long id_libro, Long id_utente) {

		boolean prestato = false;
		Prestito p = null;

		Libro lTemp = lDao.readBookConId(id_libro);
		Utente uTemp = uDao.readUserConId(id_utente);

		if (lTemp != null && uTemp != null && lTemp.getCopieDisponibili() > 0
				&& uTemp.getLibri().size() < 3) {
			p = creaPrestito();
			pDao.createPrestito(p); // AGGIUNGE IL PRESTITO NEL DB
			uTemp.getLibri().add(lTemp); // AGGIORNA LA LISTA LIBRI IN PRESTITO
											// DELL'UTENTE
			b.addPrestiti(p); // AGGIORNA LA LISTA PRESTITI DI BIBLIOTECA
			lTemp.setCopieDisponibili(lTemp.getCopieDisponibili() - 1); // AGGIORNA
																		// COPIE
																		// DISPONIBILI
																		// DEL
																		// LIBRO
			prestato = true;
		}

		return prestato;

	}

	// 3-CREA PRESTITO PRIVATE
	private Prestito creaPrestito() {

		Prestito pTemp = null;
		DateUtility dt = new DateUtility();

		Date data = new Date(); // ASSEGNA LA DATA DI OGGI

		Calendar calendarCorrente = new GregorianCalendar();
		calendarCorrente.setTime(data); // DATA DI OGGI
		Date dataCorrente = dt.convertCalendarToJavaDate(calendarCorrente); // CONVERTE
																			// DATA
																			// DA
																			// CALENDAR
																			// A
																			// DATE

		Calendar calendarScadenza = calendarCorrente;
		calendarScadenza.add(Calendar.MONTH, 1); // SET DATA DI OGGI AL MESE
													// SUCCESSIVO
		Date dataScadenza = dt.convertCalendarToJavaDate(calendarScadenza); // CONVERTE
																			// DA
																			// DA
																			// CALENDAR
																			// A
																			// DATE

		pTemp = new Prestito(dataCorrente, dataScadenza);

		return pTemp;

	}

	// 4-RESTITUZIONE LIBRO
	public boolean restituzioneLibro(Biblioteca b, Long id_libro, Long id_utente) {

		boolean restituzione = false;
		DateUtility dt = new DateUtility();

		Libro lTemp = lDao.readBookConId(id_libro);
		Utente uTemp = uDao.readUserConId(id_utente);
		Prestito pTemp = pDao.readPrestitoConId(id_libro, id_utente);

		Date dataOggi = new Date(); // DATA DI OGGI
		Date dataRestituzione = pTemp.getDataRestituzionePrestito();// DATA
																	// RESTITUZIONE
																	// DI L
		long dayDiff = dt.getDayDifference(dataOggi, dataRestituzione); // CALCOLO
																		// DIFFERENZA
																		// DATE

		if (lTemp != null && uTemp != null && dayDiff > 0) {
			restituzione = true;
		} else {
			restituzione = false;
		}

		uTemp.getLibri().remove(lTemp); // RIMUOVE IL LIBRO DALLA LISYA LIBRI
										// DELL'UTENTE
		lTemp.setCopieDisponibili(lTemp.getCopieDisponibili() + 1); // AGGIORNA
																	// COPIE
																	// DISPONIBILI
																	// LIBRO
		b.getPrestiti().remove(lTemp); // RIMUOVE PRESTITO DALLA LISTA PRESTITI
										// DI BIBLIOTECA
		pDao.deletePrestito(pTemp);

		return restituzione;

	}

}
