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
import javax.persistence.Table;

/**
 *
 * @author pi
 */
@Entity
@Table(name="UTENTI")
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int USER = 1;


	private String username;
	private String password;
	private Boolean attivo;
	private Integer tipoUtente;
	private Date dataRegistrazione;
	private Date dataUltimoAccesso;
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

	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="ATTIVO")
	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	@Column(name="TIPO_UTENTE")
	public Integer getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(Integer tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

	@Column(name="DATA_REGISTRAZIONE")
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	@Column(name="DATA_ULTIMO_ACCESSO")
	public Date getDataUltimoAccesso() {
		return dataUltimoAccesso;
	}

	public void setDataUltimoAccesso(Date dataUltimoAccesso) {
		this.dataUltimoAccesso = dataUltimoAccesso;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
