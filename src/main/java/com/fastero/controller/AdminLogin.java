package com.fastero.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fastero.dao.impl.AdministratorDAO;
import com.fastero.service.impl.AdministratorService;
import com.fastero.vo.AdministratorVO;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/administrator/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private Gson _gson = new Gson();
//	private AdministratorService service = new AdministratorService();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setHeaders(res);

		String account = req.getParameter("administratorAccount");
		String password = req.getParameter("administratorPassword");

//		System.out.println(account);
//		System.out.println(password);

		AdministratorDAO dao = new AdministratorDAO();

//		if (password == null) {
//			// Read POST
//			BufferedReader read = req.getReader();
//			// 存字串
//			String json = read.readLine();
//
//			AdministratorVO adminVo = _gson.fromJson(json, AdministratorVO.class);
//
//			account = adminVo.getAdministratorAccount();
//			password = adminVo.getAdministratorPassword();
//			AdministratorVO admin = dao.login(adminVo);
//			
//			res.getWriter().print(_gson.toJson(admin));
//			
//		}

		// 封裝admin對象
		AdministratorVO loginAdmin = new AdministratorVO();
		loginAdmin.setAdministratorAccount(account);
		loginAdmin.setAdministratorPassword(password);
		// 調用dao的login方法
		AdministratorVO admin = dao.login(loginAdmin);
		List<String> errorMsgs = new LinkedList<String>();

		// 判斷admin
		if (admin.getAdministratorId() == null) {
			// 登錄失敗
			String url = "/administrator/login_administrator.jsp";
			req.setAttribute("errorMsgs", errorMsgs);
			errorMsgs.add("帳號或密碼錯誤，請重新輸入");

//			if (!errorMsgs.isEmpty()) {
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;// 程式中斷
//			}
		} else {
//			req.setAttribute("admin", admin);
			req.setAttribute("errorMsgs", errorMsgs);
			HttpSession session = req.getSession();
//			session.setAttribute("nickname", admin.getAdministratorName());
			session.setAttribute("admin", admin);

			System.out.println(session.getAttribute("nickname"));

			// 轉發
			String url = "/administrator/administrator_index.jsp";

			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

	}

	private void setHeaders(HttpServletResponse response) {

		response.setContentType("application/json;charset=UTF-8"); // 重要
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}

}
