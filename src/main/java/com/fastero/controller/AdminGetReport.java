package com.fastero.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.ReportServiceImpl;
import com.fastero.service.impl.StoreServiceImpl;
import com.fastero.service.intf.ReportServiceIntf;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdminGetReport
 */
@WebServlet("/AdminGetReport")
public class AdminGetReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = new Gson();

	private ReportServiceIntf service = new ReportServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		System.out.println(service.findAllReport());
		resp.getWriter().print(_gson.toJson(service.findAllReport()));

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
