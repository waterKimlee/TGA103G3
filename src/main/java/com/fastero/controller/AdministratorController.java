package com.fastero.controller;

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

import com.fastero.service.impl.AdministratorService;
import com.fastero.vo.AdministratorVO;

@WebServlet("/administrator/admin.do")
public class AdministratorController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		req.setAttribute("errorMsgs", "");

		if ("update".equals(action)) { // 來自administrator.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer administratorId = Integer.valueOf(req.getParameter("administratorId").trim());
				Integer adminId = Integer.valueOf(req.getParameter("adminId").trim());
				
				String administratorAccount = req.getParameter("administratorAccount");
				String AccountReg = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$";
				if (administratorAccount == null || administratorAccount.trim().length() == 0) {
					errorMsgs.add("\"帳號: 請勿空白\"");
				} else if(!administratorAccount.trim().matches(AccountReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("\"帳號: 請符合email格式\"");
	            }
				
				String administratorPassword = req.getParameter("administratorPassword").trim();
				if (administratorPassword == null || administratorPassword.trim().length() == 0) {
					errorMsgs.add("\"請輸入密碼\"");
				}
												
				String administratorName = req.getParameter("administratorName");
				String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (administratorName == null || administratorName.trim().length() == 0) {
					errorMsgs.add("\"名稱: 請勿空白\"");
				} else if(!administratorName.trim().matches(nameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("\"名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間\"");
	            }
				
				String administratorPhone = req.getParameter("administratorPhone");
				
				Integer administratorRight = Integer.parseInt(req.getParameter("administratorRight"));
				
				AdministratorVO administratorVO = new AdministratorVO();
				administratorVO.setAdministratorId(administratorId);
				administratorVO.setAdministratorAccount(administratorAccount);
				administratorVO.setAdministratorPassword(administratorPassword);
				administratorVO.setAdministratorName(administratorName);
				administratorVO.setAdministratorPhone(administratorPhone);
				administratorVO.setAdministratorRight(administratorRight);
		
		
				
//				Integer adminId = Integer.parseInt(req.getParameter("administratorId"));
				AdministratorService adminSvc = new AdministratorService();
				AdministratorVO admin = adminSvc.getOneAdmin(adminId);
				
				HttpSession session = req.getSession();
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					errorMsgs.add("\"請更正\"");
					req.setAttribute("admin", admin); // 含有輸入格式錯誤的AdministratorVO物件,也存入req,記住登入者
					session.setAttribute("nickname", admin.getAdministratorName());
					session.setAttribute("admin", admin);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/administrator/administrator_index.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				
				administratorVO = adminSvc.updateAdministrator(administratorId, administratorAccount,  administratorPassword,  administratorName,  administratorPhone, 
						 administratorRight);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("admin", admin); // 資料庫update成功後,正確的的AdministratorVO物件,存入req
				
				session.setAttribute("nickname", admin.getAdministratorName());
				session.setAttribute("admin", admin);
				String url = "/administrator/administrator_index.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}
//
        if ("insert".equals(action)) { // 來自administrator.jsp的請求  
//			AdministratorVO admin = (AdministratorVO) req.getAttribute("admin"); 
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String administratorAccount = req.getParameter("administratorAccount");
				String AccountReg = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$";
				if (administratorAccount == null || administratorAccount.trim().length() == 0) {
					errorMsgs.add("\"帳號: 請勿空白，請重新輸入\"");
				} else if(!administratorAccount.trim().matches(AccountReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("\"帳號: 請符合email格式，請重新輸入\"");
	            }
				
				String administratorPassword = req.getParameter("administratorPassword").trim();
				if (administratorPassword == null || administratorPassword.trim().length() == 0) {
					errorMsgs.add("\"請輸入密碼\"");
					
				}
												
				String administratorName = req.getParameter("administratorName");
				String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (administratorName == null || administratorName.trim().length() == 0) {
					errorMsgs.add("\"名稱: 請勿空白，請重新輸入\"");
				} else if(!administratorName.trim().matches(nameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("\"名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間，請重新輸入\"");
	            }
				
				String administratorPhone = req.getParameter("administratorPhone");
				
				Integer administratorRight = Integer.parseInt(req.getParameter("administratorRight"));
				
				AdministratorVO administratorVO = new AdministratorVO();
				administratorVO.setAdministratorAccount(administratorAccount);
				administratorVO.setAdministratorPassword(administratorPassword);
				administratorVO.setAdministratorName(administratorName);
				administratorVO.setAdministratorPhone(administratorPhone);
				administratorVO.setAdministratorRight(administratorRight);
				
				//抓登入者id保留住資料，繼續傳到新增後頁面
				Integer adminId = Integer.parseInt(req.getParameter("administratorId"));
				AdministratorService adminSvc = new AdministratorService();
				AdministratorVO admin = adminSvc.getOneAdmin(adminId);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					errorMsgs.add("\"請重新新增資料\"");
					req.setAttribute("admin", admin); // 含有輸入格式錯誤的AdministratorVO物件,也存入req
					req.setAttribute("administratorVO", administratorVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/administrator/administrator_index.jsp");
					failureView.forward(req, res);
//					return;
				}
				if (errorMsgs.isEmpty()) {
					
					/***************************2.開始新增資料***************************************/
					
					administratorVO = adminSvc.addAdministrator(administratorAccount, administratorPassword, administratorName, administratorPhone, administratorRight);
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					req.setAttribute("admin", admin);
					String url = "/administrator/administrator_index.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);				
				}
				
				
		}
//        System.out.println(req.getParameterValues("administratorId"));
//        System.out.println(req.getParameterValues("action"));
        
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			Integer administratorId = Integer.parseInt(req.getParameter("administratorId"));
			Integer adminId = Integer.valueOf(req.getParameter("adminId").trim());
			AdministratorService adminSvc = new AdministratorService();
			/*************************** 1.接收請求參數 ***************************************/
			//抓登入者id保留住資料，繼續傳到新增後頁面
			AdministratorVO admin = adminSvc.getOneAdmin(adminId);
			/*************************** 2.開始刪除資料 ***************************************/
			adminSvc.deleteEmp(administratorId);
			req.setAttribute("admin", admin);
			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/administrator/administrator_index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		
		
//		if ("login".equals(action)) {
////			List<String> errorMsgs = new LinkedList<String>();
////					req.setAttribute("errorMsgs", errorMsgs);
//			// 獲取請求參數
//			String account = req.getParameter("administratorAccount");
//			String password = req.getParameter("administratorPassword");
//			// 封裝admin對象
//			AdministratorVO loginAdmin = new AdministratorVO();
//			loginAdmin.setAdministratorAccount(account);
//			loginAdmin.setAdministratorPassword(password);
//			// 調用dao的login方法
//			AdministratorDAO dao = new AdministratorDAO();
//			AdministratorVO admin = dao.login(loginAdmin);
//			List<String> errorMsgs = new LinkedList<String>();
//
//			// 判斷admin
//			if (admin.getAdministratorId() == null) {
//				// 登錄失敗
//				String url = "/administrator/login_administrator.jsp";
//				req.setAttribute("errorMsgs", errorMsgs);
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				errorMsgs.add("帳號或密碼錯誤，請重新輸入");
//
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher successView = req.getRequestDispatcher(url);
//					successView.forward(req, res);
//					return;// 程式中斷
//				}
//			}else {
//				req.setAttribute("admin", admin);
//				req.setAttribute("errorMsgs", errorMsgs);
////				HttpSession session = req.getSession();
////				session.setAttribute("nickname", admin.getAdministratorName());
////				session.setAttribute("admin", admin);
////				System.out.println(session.getAttribute("nickname"));
//			// 轉發
//			String url = "/administrator/administrator_index.jsp";
//
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
//			}
//		}
	}

}
