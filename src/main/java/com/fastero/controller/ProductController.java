package com.fastero.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.ProductService;
import com.fastero.vo.ProductVO;



@WebServlet("/controller/product")
public class ProductController {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { 

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer storeId = Integer.parseInt(req.getParameter("storeId"));
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
								
				/***************************2.開始查詢資料*****************************************/
				ProductService productSev = new ProductService();
				ProductVO productVO = productSev.getOneProduct(storeId);
				if (productVO == null) {
					errorMsgs.put("product_id","查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/product/productselect.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("productVO", productVO); // 資料庫取出的empVO物件,存入req

				String url = "/review/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
//		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//				/***************************1.接收請求參數****************************************/
//			Integer storeId = Integer.parseInt(req.getParameter("storeId"));
//				
//				/***************************2.開始查詢資料****************************************/
//			ProductService productSev = new ProductService();
//			ProductVO productVO = productSev.getOneProduct(storeId);
//												
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				String param = "?product_id="  +productVO.getProduct_id()+
//						       "&store_id="  +productVO.getStore_id()+
//						       "&product_name="    +productVO.getProduct_name()+
//						       "&product_introduction="+productVO.getProduct_introduction()+
//						       "&product_price="    +productVO.getProduct_price()+
//						       "&product_satus="   +productVO.getProduct_satus()+
//						       "&product_wait_time=" +productVO.getProduct_wait_time()+
//							"&product_build_time=" +productVO.getProduct_build_time()+
//							"&product_update_time=" +productVO.getProduct_update_time();
//				String url = "/emp/update_emp_input.jsp"+param;
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//				successView.forward(req, res);
//		}
////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//			
//			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				Integer productId = Integer.parseInt(req.getParameter("productId"));
//				Integer storeId = Integer.parseInt(req.getParameter("storeId"));
//				Integer productPrice = Integer.parseInt(req.getParameter("productPrice"));
//				Integer productSatus = Integer.parseInt(req.getParameter("productSatus"));
//				
//				String productName = req.getParameter("productName"); 
//				String productIntroduction = req.getParameter("productIntroduction"); 
//					
//				Date  productWaitTime = Date.valueOf(req.getParameter("productWaitTime").trim());
//				
//				ProductVO productVO = new ProductVO();
//				productVO.setProduct_id(productId);
//				productVO.setStore_id(storeId);
//				productVO.setProduct_name(productName);
//				productVO.setProduct_introduction(productIntroduction);
//				productVO.setProduct_price(productPrice);
//				productVO.setProduct_satus(productSatus);
//				productVO.setProduct_wait_time(productWaitTime);
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
//				
//				/***************************2.開始修改資料*****************************************/
//				ProductService productSev = new ProductService();
//				productVO  = productSev.updateProduct(productId, productName, productIntroduction, productPrice, productSatus, productWaitTime);
//				
//				/***************************3.修改完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("productVO", productVO); // 資料庫update成功後,正確的的empVO物件,存入req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//				successView.forward(req, res);
//		}

//        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
//			
//			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//			Integer storeId = Integer.parseInt(req.getParameter("storeId"));
//			Integer productPrice = Integer.parseInt(req.getParameter("productPrice"));
//			Integer productSatus = Integer.parseInt(req.getParameter("productSatus"));
//			
//			String productName = req.getParameter("productName"); 
//			String productIntroduction = req.getParameter("productIntroduction"); 
//				
//			Date  productWaitTime = Date.valueOf(req.getParameter("productWaitTime").trim());
//			
//			ProductVO productVO = new ProductVO();
//			productVO.setStore_id(storeId);
//			productVO.setProduct_name(productName);
//			productVO.setProduct_introduction(productIntroduction);
//			productVO.setProduct_price(productPrice);
//			productVO.setProduct_satus(productSatus);
//			productVO.setProduct_wait_time(productWaitTime);
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/update_emp_input.jsp");
//				failureView.forward(req, res);
//				return; //程式中斷
//			}
//				/***************************2.開始新增資料***************************************/
//			ProductService productSev = new ProductService();
//			productVO  = productSev.addProduct(storeId, productName, productIntroduction, productPrice, productSatus, productWaitTime);
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "#";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
//		}
//		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
			Integer productId = Integer.parseInt(req.getParameter("productId"));
			
				
				/***************************2.開始刪除資料***************************************/
				ProductService productSev = new ProductService();
				productSev.deleteProduct(productId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/emp/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}

}