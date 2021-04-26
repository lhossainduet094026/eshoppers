package com.lokman.shoppingcart.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.lokman.shoppingcart.dto.UserDTO;
import com.lokman.shoppingcart.repository.UserRepositoryImpl;
import com.lokman.shoppingcart.service.UserService;
import com.lokman.shoppingcart.service.UserServiceImpl;

import ch.qos.logback.classic.Logger;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl(new UserRepositoryImpl());
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SignupServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Serving signup page");
		request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO userDTO = copyParametersTo(request);

		if (isValid(userDTO)) {
			LOGGER.info("user is valid ,creating a new user with:{}", userDTO);
			userService.saveUser(userDTO);
			response.sendRedirect("/eshoppers/home");
		} else {
			LOGGER.info("user sent invalid data:{}", userDTO);
			request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}

	}

	private boolean isValid(UserDTO userDTO) {
		// will implement it later
		return true;
	}

	private UserDTO copyParametersTo(HttpServletRequest request) {
		var UserDTO = new UserDTO();

		UserDTO.setUsername(request.getParameter("username"));
		UserDTO.setPassword(request.getParameter("password"));
		UserDTO.setPasswordConfirmed(request.getParameter("passwordConfirmed"));
		UserDTO.setEmail(request.getParameter("email"));
		UserDTO.setFirstName(request.getParameter("firstName"));
		UserDTO.setLastName(request.getParameter("lastName"));
		return UserDTO;
	}

}
