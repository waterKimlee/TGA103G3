package com.fastero.service.impl;

import java.util.List;

import com.fastero.dao.impl.UserStoreConnDAO;
import com.fastero.vo.UserStoreConnVO;

public class UserStoreConnService {

	private UserStoreConnDAO dao;
	
	public UserStoreConnService() {
		dao = new UserStoreConnDAO();
	}
	
	
	public UserStoreConnVO insertConn(Integer userId, Integer storeId,Integer status ) {
		UserStoreConnVO userStoreConnVO = new UserStoreConnVO();
		userStoreConnVO.setUserId(userId);
		userStoreConnVO.setStoreId(storeId);
		userStoreConnVO.setStatus(status);
		dao.insert(userStoreConnVO);
		
		return userStoreConnVO;
	}
	
	public UserStoreConnVO updateConn(Integer userId, Integer storeId,Integer status ) {
		UserStoreConnVO userStoreConnVO = new UserStoreConnVO();
		userStoreConnVO.setUserId(userId);
		userStoreConnVO.setStoreId(storeId);
		userStoreConnVO.setStatus(status);
		dao.update(userStoreConnVO);
		return userStoreConnVO;
	}
	



	public List<UserStoreConnVO> getOneList(Integer userId) {

		return dao.findByPrimaryKey(userId);

	}
//	public void deleteStoreType(Integer storeId, String storeType) {
//
//		dao.delete(storeId, storeType);
//
//	}
	
//	public List<StoreTypeVO> getAll() {
//		return dao.getAll();
//	}
}
