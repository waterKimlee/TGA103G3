package com.fastero.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/administrator/*"},
dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ERROR})
public class AdminFilter extends HttpFilter{
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		if(req.getSession().getAttribute("admin") != null) {
			System.out.println("pass");
			chain.doFilter(req, res);
		}else {
//			chain.doFilter(req, res);
			System.out.println("NO");
			res.sendRedirect("http://localhost:8081/TGA103G3/login_administrator.jsp");
//			res.sendRedirect(req.getContextPath()+"/administrator/administrator_index.jsp");
			
		}
	}

}
