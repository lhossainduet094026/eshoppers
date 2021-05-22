package com.lokman.shoppingcart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lokman.shoppingcart.util.SecurityContext;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

	private static final String[] ALLOWED_CONTENTS = { ".js", ".css", ".jpg", "home", "login", "signup" };

	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest HttpServletRequest = (HttpServletRequest) request;
		String requestedURI = HttpServletRequest.getRequestURI();
		boolean allowed = false;
		for (String str : ALLOWED_CONTENTS) {
			if (requestedURI.contains(str)) {
				allowed = true;
				break;
			}
		}
		if (requestedURI.equals("/eshoppers/") || allowed || SecurityContext.isAuthenticated(HttpServletRequest)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect("/eshoppers/login");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
