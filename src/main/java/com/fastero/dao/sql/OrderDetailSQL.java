package com.fastero.dao.sql;

public class OrderDetailSQL {
	
	public static final String GET_ALL = "SELECT * FROM FASTERO.OrderDetail";
	public static final String GET_BY_ID = "SELECT * FROM FASTERO.OrderDetail where order_id = ?";

}
