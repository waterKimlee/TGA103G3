package com.administrator.model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("administratorId");
		String password = req.getParameter("administratorPassword");
		
		AdministratorVO adminLogin = new AdministratorVO();
		adminLogin.setAdministratorAccount(username);
		adminLogin.setAdministratorPassword(password);
		
		AdministratorDAO dao = new AdministratorDAO();
		AdministratorVO admin = dao.login(adminLogin);
		
		if(admin == null) {
			req.getRequestDispatcher("/login_administrator.html").forward(req, res);
		}else {
			req.setAttribute("admin", admin);
			req.getRequestDispatcher("/administrator.jsp").forward(req, res);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, res);
	}

}
