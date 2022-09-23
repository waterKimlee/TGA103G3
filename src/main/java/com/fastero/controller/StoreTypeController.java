package com.fastero.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.StoreTypeService;
import com.fastero.vo.StoreTypeVO;


public class StoreTypeController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("update".equals(action)) { 
			
			// 1 接受請求參數
			Integer storeTypeId = Integer.valueOf(req.getParameter("storeTypeId").trim());
			Integer storeId = Integer.valueOf(req.getParameter("storeId").trim());
			String storeType = req.getParameter("storeType");
			
			StoreTypeVO storeTypeVO = new StoreTypeVO();
			storeTypeVO.setStoreTypeId(storeTypeId);
			storeTypeVO.setStoreId(storeId);
			storeTypeVO.setStoreType(storeType);
			// 2 開始修改資料
			StoreTypeService storeTypeSvc = new StoreTypeService();
			storeTypeVO = storeTypeSvc.updateStoreType(storeTypeId, storeId, storeType);
			// 3 修改完成，準備轉交，或是留在原頁面
//			req.setAttribute("storeTypeVO", storeTypeVO); // 資料庫update成功後,正確的的VO物件,存入req
//			String url = "#";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交 #
//			successView.forward(req, res);
		}
		if ("insert".equals(action)) { // 來自administrator.jsp的請求  

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer storeId = Integer.valueOf(req.getParameter("storeId").trim());
			String storeType = req.getParameter("storeType");
			
			StoreTypeVO storeTypeVO = new StoreTypeVO();
			storeTypeVO.setStoreId(storeId);
			storeTypeVO.setStoreType(storeType);

			// 2 開始新增資料
			StoreTypeService storeTypeSvc = new StoreTypeService();
			storeTypeVO = storeTypeSvc.insertStoreType(storeId, storeType);
							
			
			//***************************3.新增完成,準備轉交(Send the Success view)***********/
//			req.setAttribute("storeTypeVO", storeTypeVO);
//			String url = "#";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交#
//			successView.forward(req, res);				
		}
				
		if ("delete".equals(action)) { // 
			//一個商家可以有多個type，所以delete也要看商家要刪哪個type

			/*************************** 1.接收請求參數 ***************************************/
//			Integer storeTypeId = Integer.valueOf(req.getParameter("storeTypeId").trim());
			Integer storeId = Integer.valueOf(req.getParameter("storeId").trim());
			String storeType = req.getParameter("storeType");
	
			/*************************** 2.開始刪除資料 ***************************************/
			StoreTypeService storeTypeSvc = new StoreTypeService();
			storeTypeSvc.deleteStoreType(storeId, storeType);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
//			String url = "#";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
		}		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer storeTypeId = Integer.valueOf(req.getParameter("storeTypeId").trim());

			StoreTypeVO storeTypeVO = new StoreTypeVO();
			storeTypeVO.setStoreTypeId(storeTypeId);
			/*************************** 2.開始查詢資料 *****************************************/
			StoreTypeService storeTypeSvc = new StoreTypeService();
			storeTypeVO = storeTypeSvc.getOneStoreType(storeTypeId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("AdministratorVO", AdministratorVO); // 資料庫取出的AdministratorVO物件,存入req
//			String url = "/emp/listOneEmp.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);
		}

//		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//
//			/*************************** 1.接收請求參數 ****************************************/
//			Integer administratorId = Integer.valueOf(req.getParameter("administratorId"));
//
//			/*************************** 2.開始查詢資料 ****************************************/
//			AdministratorService adminSvc = new AdministratorService();
//			AdministratorVO AdministratorVO = adminSvc.getOneEmp(administratorId);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
//			req.setAttribute("AdministratorVO", AdministratorVO); // 資料庫取出的AdministratorVO物件,存入req
//			String url = "/emp/update_emp_input.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//			successView.forward(req, res);
//		}
	if ("getAll".equals(action)) { // 來自select_page.jsp的請求

			
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			
			/*************************** 2.開始查詢資料 *****************************************/
			StoreTypeService storeTypeSvc = new StoreTypeService();
			List list = storeTypeSvc.getAll();

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("list", list); // 資料庫取出的AdministratorVO物件,存入req
//			String url = "#";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);
		}
		
		
	}
}
