package it.starwars.servlet.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starwars.service.UtenteService;
import it.starwars.util.MyConstants;

/**
 * Servlet implementation class EnableUserServlet
 */
@WebServlet("/login/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("newPassword");
		boolean result = false;

		if (!password.equals(request.getParameter("confirmPassword"))) {
			request.setAttribute(MyConstants.ERROR, "La password di conferma non è corretta");
			request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
			return;
		}

		try {
			result = UtenteService.updateUserPassword(request.getParameter("newPassword"),
					request.getParameter("oldPassword"));
		} catch (Exception e) {
			getServletContext().log("Impossibile aggiornare la password", e);
			request.setAttribute(MyConstants.ERROR, "Errore in fase di aggiornamento password");
			request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
			return;
		}

		if (result) {
			request.setAttribute(MyConstants.INFO, "Password aggiornata correttamente");
			request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
			return;
		} else {
			request.setAttribute(MyConstants.ERROR, "Errore in fase di aggiornamento password");
			request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
