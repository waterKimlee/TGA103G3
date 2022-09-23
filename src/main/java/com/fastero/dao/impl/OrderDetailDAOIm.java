package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fastero.dao.intf.OrderDetailDAOIn;
import com.fastero.dao.sql.OrderDetailSQL;
import com.fastero.vo.OrderDetailVO;

public class OrderDetailDAOIm implements OrderDetailDAOIn {

	@Override
	public List<OrderDetailVO> getAll() throws Exception {
		
		List<OrderDetailVO> list = new ArrayList<OrderDetailVO>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(OrderDetailSQL.GET_ALL);) {
			System.out.println("連線成功");
			
			OrderDetailVO vo;
			
			try(ResultSet rs = ps.executeQuery()){
				
				while(rs.next()) {
					vo = new OrderDetailVO();
					vo.setOrderId(rs.getInt("order_id"));
					vo.setProductId(rs.getInt("product_id"));
					vo.setPrice(rs.getInt("price"));
					vo.setQuantity(rs.getInt("quantity"));
					
					list.add(vo);
				}
			}

			return list;
		}
	}

	@Override
	public List<OrderDetailVO> getById(Integer id) throws Exception {

		List<OrderDetailVO> list = new ArrayList<OrderDetailVO>();
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(OrderDetailSQL.GET_BY_ID);) {
			System.out.println("連線成功");
			
			OrderDetailVO vo;
			
			ps.setInt(1, id);
			
			try(ResultSet rs = ps.executeQuery()){
				
				while(rs.next()) {
					vo = new OrderDetailVO();
					vo.setOrderId(rs.getInt("order_id"));
					vo.setProductId(rs.getInt("product_id"));
					vo.setPrice(rs.getInt("price"));
					vo.setQuantity(rs.getInt("quantity"));
					
					list.add(vo);
				}
			}
			return list;
				
			}
	}

}
