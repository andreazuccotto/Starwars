package it.starwars.servlet.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starwars.bean.Utente;
import it.starwars.service.UtenteService;
import it.starwars.util.MyConstants;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String HOSTNAME = "smtp.gmail.com";
	private static final int PORT = 465;
	private static final String USERNAME = "gmail";
	private static final String PASSWORD = "";
	private static final String MAIL_SUBJECT = "Registrazione it.starwars";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			UtenteService.save(
					new Utente(request.getParameter(MyConstants.USERNAME), request.getParameter(MyConstants.PASSWORD)));

			sendEmail(request.getParameter(MyConstants.EMAIL));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void sendEmail(String email) {

		Mailer mailer = new Mailer(HOSTNAME, PORT, USERNAME, PASSWORD);

		String message = "";

		mailer.send(MyConstants.MAIL_FROM, email, MAIL_SUBJECT, message);
	}

}
