package com.administrator.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.administrator.model.AdministratorDAO;
import com.administrator.model.AdministratorService;
import com.administrator.model.AdministratorVO;

public class DaoTest  {
	

	public static void main(String[] args) {

		
		
		//獲取請求參數
//		String username = req.getParameter("administratorAccount").trim();
//		String password = req.getParameter("administratorPassword").trim();
		//封裝admin對象
		AdministratorVO loginAdmin = new  AdministratorVO();
		loginAdmin.setAdministratorAccount("adminfirst@gmail.com");
		loginAdmin.setAdministratorPassword("12345678");
		//調用dao的login方法
//		AdministratorDAO dao = new AdministratorDAO();
//		AdministratorVO admin = dao.login(loginAdmin);
//		
		System.out.println(loginAdmin.toString());
	}
//
//	@Override
//	public void insert(AdministratorVO administratorVO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(AdministratorVO AdministratorVO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(Integer AdministratorId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public AdministratorVO findByPrimaryKey(Integer AdministratorId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<AdministratorVO> getAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public AdministratorVO login(AdministratorVO loginAdmin) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
