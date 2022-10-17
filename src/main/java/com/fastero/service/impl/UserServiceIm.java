package com.fastero.service.impl;

import java.util.List;

import com.fastero.common.Result;
import com.fastero.dao.impl.UserDAOIm;
import com.fastero.service.intf.UserServiceIn;
import com.fastero.vo.UserVO;

public class UserServiceIm implements UserServiceIn {

	private UserDAOIm DAO;
	// RESTFUL
	private Result R;

	public UserServiceIm() {
		DAO = new UserDAOIm();
		R = new Result();
	}

//	@Override
//	public Result getAll() {
//		try {
//			return R.success(DAO.getAll());
//		} catch (Exception e) {
//			e.printStackTrace();
//			return R.fail(e.toString());
//		}
//	}

	public List<UserVO> getAll() {

		try {
			return DAO.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
//	public Result getById(Integer id) {
//		try {
//			return R.success(DAO.getById(id));
//		} catch (Exception e) {
//			e.printStackTrace();
//			return R.fail(e.toString());
//		}
//	}
	@Override
	public UserVO getById(Integer id) {
		try {
			return DAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateStatus(UserVO vo) {
		try {
			DAO.updateStatus(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
