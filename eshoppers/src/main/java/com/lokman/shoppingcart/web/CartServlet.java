package com.lokman.shoppingcart.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CartServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var productId = request.getParameter("productId");
		LOGGER.info("Received request to add product with id:{} to cart", productId);
		var cart = getCart(request);
		addProductToCart(productId, cart);
		response.sendRedirect("/home");
	}

	private void addProductToCart(String productId, Object cart) {
		// TODO Auto-generated method stub

	}

	private Object getCart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
