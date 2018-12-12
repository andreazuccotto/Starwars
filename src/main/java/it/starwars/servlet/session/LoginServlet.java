/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.starwars.servlet.session;

import it.starwars.bean.Utente;
import it.starwars.service.UtenteService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pi
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for username and password
        String username = request.getParameter(USERNAME) == null ? "" : request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD) == null ? "" : request.getParameter(PASSWORD);
        
        Utente utente = UtenteService.getUtenteById(username);
        

        if (utente != null && password.equals(utente.getPassword())) {
            //get the old session and invalidate
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);

            //setting session to expiry in 5 mins
            newSession.setMaxInactiveInterval(5*60);

            Cookie message = new Cookie("message", "Welcome");
            response.addCookie(message);
            response.sendRedirect("/Starwars/main/index.html");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login/loginPage.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            rd.include(request, response);
        }
    }
} 