package com.lokman.shoppingcart.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.domain.User;
import com.lokman.shoppingcart.repository.CartItemRepositoryImpl;
import com.lokman.shoppingcart.repository.CartRepositoryImpl;
import com.lokman.shoppingcart.repository.DummyProductRepositoryImpl;
import com.lokman.shoppingcart.service.CartService;
import com.lokman.shoppingcart.service.CartServiceImpl;
import com.lokman.shoppingcart.util.SecurityContext;

import ch.qos.logback.classic.Logger;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/add-to-cart")
public class CartServlet extends HttpServlet {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CartServlet.class);

	private CartService cartService = new CartServiceImpl(new CartRepositoryImpl(), new CartItemRepositoryImpl(),
			new DummyProductRepositoryImpl());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var productId = request.getParameter("productId");
		LOGGER.info("Received request to add product with id:{} to cart", productId);
		var cart = getCart(request);
		cartService.addProductToCart(productId, cart);
		response.sendRedirect("/eshoppers/home");
	}

	private Cart getCart(HttpServletRequest request) {
		final User currentUser = SecurityContext.getCurrentUser(request);
		return cartService.getCartByUser(currentUser);
	}

}
