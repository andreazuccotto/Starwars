package it.starwars.servlet.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.starwars.service.UtenteService;
import it.starwars.util.MyConstants;

/**
 * Servlet implementation class EnableUserServlet
 */
@WebServlet("/login/EnableUserServlet")
public class EnableUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnableUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter(MyConstants.USERNAME);

		if (StringUtils.isNotBlank(username)) {

			try {
				UtenteService.updateAttivaUtente(username);
			} catch (Exception e) {
				getServletContext().log("Impossibile attivare l'utente", e);
			}

		}

		response.sendRedirect(MyConstants.FULL_LOGIN_PATH);
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
