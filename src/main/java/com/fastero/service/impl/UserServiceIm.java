package com.fastero.service.impl;

import com.fastero.common.Result;
import com.fastero.dao.impl.UserDAOIm;
import com.fastero.service.intf.UserServiceIn;

public class UserServiceIm implements UserServiceIn{

	private UserDAOIm DAO;
	// RESTFUL
	private Result R;

	public UserServiceIm() {
		DAO = new UserDAOIm();
		R = new Result();
	}

	@Override
	public Result getAll() {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}

	@Override
	public Result getById(Integer id) {
		try {
			return R.success(DAO.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.toString());
		}
	}
}
