package com.fastero.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.common.LocalDateTimeAdapter;
import com.fastero.service.impl.UserServiceIm;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/users")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = new GsonBuilder()
						    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
						    .enableComplexMapKeySerialization()
						    .serializeNulls()
						    .setDateFormat(DateFormat.LONG)
						    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
						    .setPrettyPrinting()
						    .setVersion(1.0)
						    .create();
	private UserServiceIm service = new UserServiceIm();
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// CROS
//		request.setCharacterEncoding("UTF-8");
		setHeaders(response);
		
		response.getWriter().print(_gson.toJson(service.getAll()));

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		setHeaders(response);
		PrintWriter out = response.getWriter();
		// Read POST
		BufferedReader read = request.getReader();
		// 存字串
		String json = read.readLine();
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
