package com.fastero.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fastero.service.impl.UserServiceIm;
import com.fastero.service.intf.UserServiceIn;
import com.fastero.vo.UserVO;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdminSetUser
 */
@WebServlet("/AdminSetUser")
public class AdminSetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Gson _gson = new Gson();

	private UserServiceIn service = new UserServiceIm();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		setHeaders(response);

		UserVO vo = _gson.fromJson(request.getReader().readLine(), UserVO.class);

		// int id = vo.getUserId();
		// int status = vo.getUserStatus();

		// vo = service.getById(id);
		System.out.println(vo.getUserId());
		System.out.println(vo.getUserStatus());
		service.updateStatus(vo);
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

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(resp);

	}
}
