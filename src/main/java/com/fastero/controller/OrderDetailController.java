package com.fastero.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.OrderDetailServiceIm;
import com.google.gson.Gson;


@WebServlet("/details")
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = new Gson();
	private OrderDetailServiceIm service= new OrderDetailServiceIm();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// CROS
		setHeaders(response);
		
		response.getWriter().print(_gson.toJson(service.getAll()));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setHeaders(response);
//		PrintWriter out = response.getWriter();
//		// Read POST
//		BufferedReader read = request.getReader();
//		
//		// 存字串
//		String json = read.readLine();
		
		System.out.println(_gson.toJson(service.getById(Integer.parseInt(request.getParameter("order_id")))));
		
		
	}

	/*
	 * CROS
	 */
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
