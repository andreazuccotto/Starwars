package it.starwars.servlet.session;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starwars.bean.Utente;
import it.starwars.service.UtenteService;
import it.starwars.util.MyConstants;
import it.starwars.util.MyUtils;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USERNAME = "gmail";
	private static final String PASSWORD = "";
	private static final String MAIL_SUBJECT = "Registrazione it.starwars";
	private static final String MAIL_FROM = "noreply@starwars.it";

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

		String username = request.getParameter(MyConstants.USERNAME);

		try {
			UtenteService.save(new Utente(username, request.getParameter(MyConstants.PASSWORD)));
		} catch (Exception e) {
			getServletContext().log("Impossibile creare un nuovo utente sul db", e);
		}

		sendEmail(request.getParameter(MyConstants.EMAIL), username);

	}

	private void sendEmail(String email, String username) {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MAIL_FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(MAIL_SUBJECT);

			StringBuilder sb = new StringBuilder();
			sb.append("Benvenuto ");
			sb.append(username);
			sb.append("!\n\nGrazie per esserti registrato, clicca il seguente link per attivare il tuo account:\n\n");
			sb.append(MyUtils.getProperties("ENABLE_USER_SERVLET_PATH"));
			sb.append("?username=");
			sb.append(username);

			message.setText(sb.toString());

			Transport.send(message);

		} catch (MessagingException e) {
			getServletContext().log("Errore in EnrollServlet.sendEmail", e);
		}
	}
}
