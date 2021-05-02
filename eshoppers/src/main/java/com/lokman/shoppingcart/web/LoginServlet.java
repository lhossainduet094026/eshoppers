package com.lokman.shoppingcart.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.lokman.shoppingcart.dto.LoginDTO;

import ch.qos.logback.classic.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoginServlet.class);

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Serving login page");
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDTO loginDTO = new LoginDTO(request.getParameter("username"), request.getParameter("password"));

		LOGGER.info("Receiving login data{}", loginDTO);

		try {
			login(loginDTO);
			LOGGER.info("login successfully ,redirecting to homepage");
			response.sendRedirect("/home");
		}
		catch(Exception e) {
			LOGGER.error("incorrect username and password",e);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	private void login(LoginDTO loginDTO)  {
		//will implement later
		
	}

}
