package com.lokman.shoppingcart.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.lokman.shoppingcart.util.SecurityContext;

import ch.qos.logback.classic.Logger;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LogoutServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Logging out");
		SecurityContext.logOut(request);
		response.sendRedirect("/login?logout=true");
	}

}
