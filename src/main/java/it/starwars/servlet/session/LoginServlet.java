/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.starwars.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starwars.bean.Utente;
import it.starwars.service.UtenteService;
import it.starwars.util.MyConstants;
import it.starwars.util.MyUtils;

/**
 *
 * @author pi
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_INACTIVE_INTERVAL = 300;
	private static final String LOGIN_PATH = "/login/loginPage.html";
	private static final String HOMEPAGE_PATH = "/Starwars/main/homepage.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request parameters for username and password
		String username = MyUtils.getSafeString(request.getParameter(MyConstants.USERNAME));
		String password = MyUtils.getSafeString(request.getParameter(MyConstants.PASSWORD));

		Utente utente = null;
		try {
			utente = UtenteService.getUtenteById(username);
		} catch (Exception e) {
			getServletContext().log("Impossibile ricercare l'utente sul db", e);
			return;
		}

		if (utente == null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(LOGIN_PATH);
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Username non corretta.</font>");
			rd.include(request, response);
			return;
		}

		if (!password.equals(utente.getPassword())) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(LOGIN_PATH);
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Password non corretta.</font>");
			rd.include(request, response);
			return;
		}

		if (!utente.getAttivo()) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(LOGIN_PATH);
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Utente non attivo.</font>");
			rd.include(request, response);
			return;
		}

		// get the old session and invalidate
		HttpSession oldSession = request.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate();
		}
		// generate a new session
		HttpSession newSession = request.getSession(true);

		// setting session to expiry in 5 mins
		newSession.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);

		newSession.setAttribute(MyConstants.USER, utente);

		try {
			UtenteService.updateDateLastUpdate(utente);
		} catch (Exception e) {
			getServletContext().log("Impossibile aggiornare la data ultimo accesso", e);
		}

		response.sendRedirect(HOMEPAGE_PATH);

	}
}