/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.starwars.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pi
 */
@Entity
@Table(name = "UTENTI")
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int USER = 1;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ATTIVO")
	private Boolean attivo;

	@Column(name = "TIPO_UTENTE")
	private Integer tipoUtente;

	@Column(name = "DATA_REGISTRAZIONE")
	private Date dataRegistrazione;

	@Column(name = "DATA_ULTIMO_ACCESSO")
	private Date dataUltimoAccesso;

	@Column(name = "EMAIL")
	private String email;

	public Utente() {
		super();
	}

	public Utente(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.attivo = false;
		this.tipoUtente = USER;
		Date today = new Date();
		this.dataRegistrazione = today;
		this.dataUltimoAccesso = today;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
