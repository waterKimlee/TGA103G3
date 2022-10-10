package com.fastero.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.OrderDetailServiceIm;
import com.fastero.service.impl.OrderMasterServiceIm;
import com.fastero.service.impl.ProductService;
import com.google.gson.Gson;

@WebServlet("/AdminGetHistory")
public class AdminGetHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setHeaders(response);
		
		Gson _gson = new Gson();
		OrderMasterServiceIm orderMSvc = new OrderMasterServiceIm();
		OrderDetailServiceIm orderDSvc= new OrderDetailServiceIm();
		ProductService productSvc = new ProductService();

		List<Object> list = new ArrayList<>() ;
		
		list.add(orderMSvc.getAll());
		list.add(orderDSvc.getAll());
		list.add(productSvc.getAllProduct());
		
		response.getWriter().print(_gson.toJson(list));
		
//		response.getWriter().print(_gson.toJson(orderMSvc.getAll()));
//		response.getWriter().print(_gson.toJson(orderDSvc.getAll()));
//		response.getWriter().print(_gson.toJson(productSvc.getAllProduct()));
	}

	
	/*
	 * 跨域
	 */
	private void setHeaders(HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8"); // 重要
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		response.addHeader("Access-Control-Allow-Origin", "*"); // 重要 允許不同連線
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}
}
