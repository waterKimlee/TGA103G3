package com.userstoreconn.model;

import java.util.List;


public interface UserStoreConnDAOintf {
	
	public void insert(UserStoreConnVO userStoreConnVO);
	//移除最愛及黑名單都改update裡面的status
	public void update(UserStoreConnVO userStoreConnVO);

//	public void delete(Integer userId,Integer storeId);

	//回傳使用者最愛list
	public List<UserStoreConnVO> findByPrimaryKey(Integer userId);

//	public List<UserStoreConnVO> getAll();


	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
	// public List<EmpVO> getAll(Map<String, String[]> map);
}