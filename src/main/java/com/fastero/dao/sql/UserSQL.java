package com.fastero.dao.sql;

public class UserSQL {

	public static final String GET_ALL = "SELECT * FROM FASTERO.User";
	public static final String GET_BY_ID = "SELECT * FROM FASTERO.User where user_id = ?";
}
