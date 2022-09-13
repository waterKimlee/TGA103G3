package com.userstoreconn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.storetype.model.StoreTypeService;
import com.storetype.model.StoreTypeVO;
import com.userstoreconn.model.UserStoreConnService;
import com.userstoreconn.model.UserStoreConnVO;

public class UserStoreConnController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("insert".equals(action)) { // 來自administrator.jsp的請求  

			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer userId = Integer.valueOf(req.getParameter("userId").trim());
			Integer storeId = Integer.valueOf(req.getParameter("storeId").trim());
			Integer status = Integer.valueOf(req.getParameter("status").trim());
			
			UserStoreConnVO userStoreConnVO = new UserStoreConnVO();
			userStoreConnVO.setUserId(userId);
			userStoreConnVO.setStoreId(storeId);
			userStoreConnVO.setStatus(status);
	
			// ******************   2 開始新增資料
			UserStoreConnService userStoreConnSvc = new UserStoreConnService();
			userStoreConnVO = userStoreConnSvc.insertConn(userId, storeId, status);
							
			
			//***************************3.新增完成,準備轉交(Send the Success view)***********/
	//		req.setAttribute("userStoreConnVO", userStoreConnVO);
	//		String url = "#";
	//		RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交#
	//		successView.forward(req, res);	
		}
		if ("update".equals(action)) { 
			
			// 1 接受請求參數
			Integer userId = Integer.valueOf(req.getParameter("userId").trim());
			Integer storeId = Integer.valueOf(req.getParameter("storeId").trim());
			Integer status = Integer.valueOf(req.getParameter("status").trim());
			
			UserStoreConnVO userStoreConnVO = new UserStoreConnVO();
			userStoreConnVO.setUserId(userId);
			userStoreConnVO.setStoreId(storeId);
			userStoreConnVO.setStatus(status);
			// 2 開始修改資料
			UserStoreConnService userStoreConnSvc = new UserStoreConnService();
			userStoreConnVO = userStoreConnSvc.updateConn(userId, storeId, status);
				
			// 3 修改完成，準備轉交，或是留在原頁面
//			req.setAttribute("storeTypeVO", storeTypeVO); // 資料庫update成功後,正確的的VO物件,存入req
//			String url = "#";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交 #
//			successView.forward(req, res);
		}
		
			//這是取得某會員的最愛清單
		if ("getOneList".equals(action)) {
			// 1 接受請求參數
			Integer userId = Integer.valueOf(req.getParameter("userId").trim());
			
			UserStoreConnVO userStoreConnVO = new UserStoreConnVO();
			userStoreConnVO.setUserId(userId);
			// 2 開始查詢資料
			UserStoreConnService userStoreConnSvc = new UserStoreConnService();
			List<UserStoreConnVO> list = userStoreConnSvc.getOneList(userId);
						
			// 3 修改完成，準備轉交，或是留在原頁面
			req.setAttribute("list", list); // 資料庫查到最愛清單成功後,正確的的list,存入req
//			String url = "#";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交 #
//			successView.forward(req, res);
			
			
		}
			
			
	}
				
}
