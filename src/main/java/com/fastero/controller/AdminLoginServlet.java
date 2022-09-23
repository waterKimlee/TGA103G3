package com.fastero.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fastero.dao.impl.AdministratorDAO;
import com.fastero.vo.AdministratorVO;
@WebServlet("/loginServlet")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String account = req.getParameter("administratorAccount");
		String password = req.getParameter("administratorPassword");

		
		AdministratorVO loginAdmin = new AdministratorVO();
		loginAdmin.setAdministratorAccount(account);
		loginAdmin.setAdministratorPassword(password);
		// 調用dao的login方法
		AdministratorDAO dao = new AdministratorDAO();
		AdministratorVO admin = dao.login(loginAdmin);
		List<String> errorMsgs = new LinkedList<String>();

		// 判斷admin
		if (admin.getAdministratorId() == null) {
			// 登錄失敗
			String url = "/administrator/login_administrator.jsp";
			req.setAttribute("errorMsgs", errorMsgs);
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			errorMsgs.add("帳號或密碼錯誤，請重新輸入");

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
				return;// 程式中斷
			}
		}else {
			req.setAttribute("admin", admin);
			req.setAttribute("errorMsgs", errorMsgs);
			HttpSession session = req.getSession();
			session.setAttribute("nickname", admin.getAdministratorName());
			System.out.println(session.getAttribute("nickname"));
		// 轉發
		String url = "/administrator/administrator_index.jsp";

		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		}
		
//		AdministratorVO adminLogin = new AdministratorVO();
//		adminLogin.setAdministratorAccount(username);
//		adminLogin.setAdministratorPassword(password);
//		
//		AdministratorDAO dao = new AdministratorDAO();
//		AdministratorVO admin = dao.login(adminLogin);
//		
//		if(admin == null) {
//			req.getRequestDispatcher("/login_administrator.html").forward(req, res);
//		}else {
//			req.setAttribute("admin", admin);
//			req.getRequestDispatcher("/administrator.jsp").forward(req, res);
//			
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, res);
	}

}
