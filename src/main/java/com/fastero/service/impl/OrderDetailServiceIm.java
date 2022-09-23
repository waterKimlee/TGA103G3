package com.fastero.service.impl;

import com.fastero.common.Result;
import com.fastero.dao.impl.OrderDetailDAOIm;
import com.fastero.service.intf.OrderDetailServiceIn;

public class OrderDetailServiceIm implements OrderDetailServiceIn{

	private OrderDetailDAOIm DAO;
	// RESTFUL
	private Result R;

	public OrderDetailServiceIm() {
		DAO = new OrderDetailDAOIm();
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
