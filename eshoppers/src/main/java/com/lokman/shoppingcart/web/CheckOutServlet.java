package com.lokman.shoppingcart.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.repository.CartItemRepositoryImpl;
import com.lokman.shoppingcart.repository.CartRepositoryImpl;
import com.lokman.shoppingcart.repository.DummyProductRepositoryImpl;
import com.lokman.shoppingcart.service.CartService;
import com.lokman.shoppingcart.service.CartServiceImpl;
import com.lokman.shoppingcart.util.SecurityContext;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckOutServlet() {
		super();
	}

	private CartService cartService = new CartServiceImpl(new CartRepositoryImpl(), new CartItemRepositoryImpl(),
			new DummyProductRepositoryImpl());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var currentUser = SecurityContext.getCurrentUser(request);
		Cart cart = cartService.getCartByUser(currentUser);
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
