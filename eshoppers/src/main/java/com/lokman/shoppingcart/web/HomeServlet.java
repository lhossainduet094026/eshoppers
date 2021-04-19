package com.lokman.shoppingcart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.lokman.shoppingcart.dto.ProductDTO;
import com.lokman.shoppingcart.repository.DummyProductRepositoryImpl;
import com.lokman.shoppingcart.service.ProductService;
import com.lokman.shoppingcart.service.ProductServiceImpl;

import ch.qos.logback.classic.Logger;




@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private ProductService productService =new ProductServiceImpl(new DummyProductRepositoryImpl());
    private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(HomeServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("do get method calls");
		List<ProductDTO> allProducts = productService.findAllProductSortedByName();
		req.setAttribute("products", allProducts);
		
		req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
	}
}
