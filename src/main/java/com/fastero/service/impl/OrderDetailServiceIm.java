package com.fastero.service.impl;

import java.util.List;

import com.fastero.common.Result;
import com.fastero.dao.impl.OrderDetailDAOIm;
import com.fastero.service.intf.OrderDetailServiceIn;
import com.fastero.vo.OrderDetailVO;

public class OrderDetailServiceIm implements OrderDetailServiceIn{

	private OrderDetailDAOIm DAO;
	// RESTFUL
	private Result R;

	public OrderDetailServiceIm() {
		DAO = new OrderDetailDAOIm();
		R = new Result();
	}
	
	@Override
//	public Result getAll() {
//		
//		try {
//			return R.success(DAO.getAll());
//		} catch (Exception e) {
//			e.printStackTrace();
//			return R.fail(e.toString());
//		}
//	}
	public List<OrderDetailVO> getAll() {
		
		try {
			return DAO.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
