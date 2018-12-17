/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.starwars.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.starwars.bean.Utente;
import it.starwars.util.HibernateUtils;

/**
 *
 * @author pi
 */
public class UtenteService {

	private UtenteService() {
	}

	public static Utente getUtenteById(String username) {

		Utente utente = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			utente = session.get(Utente.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return utente;
	}

	public static List<Utente> getUtenti() {

		List<Utente> utenti = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			utenti = session.createQuery("from UTENTI").list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return utenti;
	}

	public static void save(Utente utente) {

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.beginTransaction();

			session.save(utente);

			session.getTransaction().commit();
		}
	}

	public static void updateDateLastUpdate(Utente utente) {

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.beginTransaction();

			Query query = session
					.createQuery("update UTENTI set DATA_ULTIMO_ACCESSO = :date where username = :username");
			query.setParameter("date", new Date());
			query.setParameter("username", utente.getUsername());
			query.executeUpdate();

			session.getTransaction().commit();
		}
	}

}