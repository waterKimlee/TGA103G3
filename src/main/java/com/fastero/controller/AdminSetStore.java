package com.fastero.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.StoreServiceImpl;
import com.fastero.service.intf.StoreService;
import com.fastero.vo.StoreVO;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdminSetStore
 */
@WebServlet("/AdminSetStore")
public class AdminSetStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Gson _gson = new Gson(); 

	private StoreService service = new StoreServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		setHeaders(response);
		
		StoreVO vo = _gson.fromJson(request.getReader().readLine(), StoreVO.class);
		
		int id = vo.getStoreId();
		
//		System.out.println(id);
		
		vo = service.findById(id);
//		System.out.println(vo);
		service.updateStatus(vo);
		
		
//		response.getWriter().print(_gson.toJson(service.findAllReport()));
		response.getWriter().print("OK");
	
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
