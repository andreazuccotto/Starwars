/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.starwars.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author pi
 */
@Entity
@Table(name="UTENTI")
public class Utente implements Serializable {
    
    public String username;
    public String password;
    public Boolean attivo;
    public Integer tipoUtente;
    public Date dataRegistrazione;
    public Date dataUltimoAccesso;

    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    public Integer getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(Integer tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public Date getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(Date dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public Date getDataUltimoAccesso() {
        return dataUltimoAccesso;
    }

    public void setDataUltimoAccesso(Date dataUltimoAccesso) {
        this.dataUltimoAccesso = dataUltimoAccesso;
    }
    
    
}
