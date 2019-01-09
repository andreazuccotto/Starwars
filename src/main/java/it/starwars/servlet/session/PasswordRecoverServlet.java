package it.starwars.servlet.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starwars.util.MyConstants;
import it.starwars.util.MyUtils;

/**
 * Servlet implementation class PasswordRecoverServlet
 */
@WebServlet("/PasswordRecoverServlet")
public class PasswordRecoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordRecoverServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request parameters for username and password
		String username = MyUtils.getSafeString(request.getParameter(MyConstants.USERNAME));
		String email = MyUtils.getSafeString(request.getParameter(MyConstants.EMAIL));

	}

}
