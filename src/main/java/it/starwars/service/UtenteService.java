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

	public static Utente getUtenteByUserAndPwd(String username, String password) {
		Utente utente = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		utente = (Utente) session.createQuery("from Utente where username = :username and password = crypt(:password, password)").setParameter("username", username).setParameter("password", password).uniqueResult();
		return utente;
	}

	public static List<Utente> getUtenti() {
		List<Utente> utenti = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		utenti = session.createQuery("from Utente").list();
		return utenti;
	}

	public static void insertNewUtente(Utente utente) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("insert into Utente (username, password, attivo, email) VALUES :username, crypt(:password, gen_salt('bf')), 0, :email");
		query.setParameter("username", utente.getUsername());
		query.setParameter("password", utente.getPassword());
		query.setParameter("email", utente.getEmail());
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public static void save(Utente utente) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(utente);
		session.getTransaction().commit();
	}

	public static void updateDateLastUpdate(Utente utente) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Utente set dataUltimoAccesso = :date where username = :username");
		query.setParameter("date", new Date());
		query.setParameter("username", utente.getUsername());
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public static void updateAttivaUtente(String username) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Utente set attivo = true where username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		session.getTransaction().commit();
	}

}
