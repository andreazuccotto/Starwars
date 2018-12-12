/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.starwars.service;

import it.starwars.bean.Utente;
import it.starwars.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author pi
 */
public class UtenteService {
    
    private UtenteService() {}
    
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
        
        List<Utente> utente = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            utente = session.createQuery("from Utenti").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return utente;
    }
    
    public static void save(Utente utente) {
        
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            session.save(utente);
            
            session.getTransaction().commit();
        }
    }
    
    
}
