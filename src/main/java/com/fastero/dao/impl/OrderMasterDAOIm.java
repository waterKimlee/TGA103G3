package com.fastero.dao.impl;

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

import com.fastero.dao.intf.OderMasterDAOIn;
import com.fastero.dao.sql.OrderMasterSQL;
import com.fastero.vo.HistoryVO;
import com.fastero.vo.OrderMasterVO;

public class OrderMasterDAOIm implements OderMasterDAOIn {

	private static DataSource ds = null;
	private static OrderMasterSQL SQL = null;

	public OrderMasterDAOIm() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");
			SQL = new OrderMasterSQL();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderMasterVO> getAll() {
		List<OrderMasterVO> list = new ArrayList<>();
		OrderMasterVO vo = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(SQL.GET_ALL);) {
			System.out.println("連線成功");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
//							order_id, user_id, store_id, order_status, order_amount, 
//							order_time, update_time, order_remark
					vo = new OrderMasterVO();

					vo.setOrderId(rs.getInt("order_id"));
					vo.setUserId(rs.getInt("user_id"));
					vo.setStoreId(rs.getInt("store_id"));
					vo.setOrderStatus(rs.getInt("order_status"));
					vo.setOrderAmount(rs.getInt("order_amount"));
					vo.setOrderTime(rs.getString("order_time"));
					vo.setUpdateTime(rs.getString("update_time"));
					vo.setOrderRemark(rs.getString("order_remark"));
					list.add(vo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error();
		}

		return list;
	}
	
	public static final String GET_ALL_HISTORY = "SELECT m.order_id, m.user_id, m.store_id,  m.order_amount, m.order_time, m.order_remark, s.store_name, u.user_name \r\n"
			+ "FROM OrderMaster m , Store s, User u \r\n"
			+ "where s.store_id = m.store_id and m.user_id = u.user_id order by order_id desc;"; 
	
	public List<HistoryVO> getAllHistory() {
		List<HistoryVO> list = new ArrayList<>();
		HistoryVO vo = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_HISTORY);) {
			System.out.println("連線成功");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
//							order_id, user_id, store_id, order_status, order_amount, 
//							order_time, update_time, order_remark
					vo = new HistoryVO();
					
					vo.setOrderId(rs.getInt("order_id"));
					vo.setUserId(rs.getInt("user_id"));
					vo.setStoreId(rs.getInt("store_id"));
//					vo.setOrderStatus(rs.getInt("order_status"));
					vo.setOrderAmount(rs.getInt("order_amount"));
					vo.setOrderTime(rs.getString("order_time"));
//					vo.setUpdateTime(rs.getString("update_time"));
//					vo.setOrderRemark(rs.getString("order_remark"));
					vo.setStoreName(rs.getString("store_name"));
					vo.setUserName(rs.getString("user_name"));
					list.add(vo);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error();
		}
		
		return list;
	}

}
