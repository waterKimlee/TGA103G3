package com.fastero.service.impl;

import com.fastero.common.Result;
import com.fastero.dao.impl.OrderMasterDAOIm;
import com.fastero.service.intf.OrderMasterServiceIn;

public class OrderMasterServiceIm implements OrderMasterServiceIn {

	OrderMasterDAOIm DAO;
	Result R;

	public OrderMasterServiceIm() {
		DAO = new OrderMasterDAOIm();
		R = new Result();
	}

	@Override
	public Result getAll() {
		try {
			return R.success(DAO.getAll());
		} catch (Exception e) {
			return R.fail(e.toString());
		}
	}

}
