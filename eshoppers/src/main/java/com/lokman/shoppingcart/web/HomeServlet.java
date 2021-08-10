package com.lokman.shoppingcart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.dto.ProductDTO;
import com.lokman.shoppingcart.repository.CartItemRepositoryImpl;
import com.lokman.shoppingcart.repository.CartRepositoryImpl;
import com.lokman.shoppingcart.repository.DummyProductRepositoryImpl;
import com.lokman.shoppingcart.service.CartService;
import com.lokman.shoppingcart.service.CartServiceImpl;
import com.lokman.shoppingcart.service.ProductService;
import com.lokman.shoppingcart.service.ProductServiceImpl;
import com.lokman.shoppingcart.util.SecurityContext;

import ch.qos.logback.classic.Logger;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private ProductService productService = new ProductServiceImpl(new DummyProductRepositoryImpl());
	private CartService cartService = new CartServiceImpl(new CartRepositoryImpl(), new CartItemRepositoryImpl());
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(HomeServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("Serving home page");
		List<ProductDTO> allProducts = productService.findAllProductSortedByName();
		LOGGER.info("Total product found{}", allProducts.size());
		if (SecurityContext.isAuthenticated(req)) {
			var currentUser = SecurityContext.getCurrentUser(req);
			Cart cart = cartService.getCartByUser(currentUser);
			req.setAttribute("cart", cart);
		}
		req.setAttribute("products", allProducts);
		req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
	}
}
