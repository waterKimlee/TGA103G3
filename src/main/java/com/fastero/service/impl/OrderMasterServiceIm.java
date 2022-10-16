package com.fastero.service.impl;

import java.util.List;

import com.fastero.common.Result;
import com.fastero.dao.impl.OrderMasterDAOIm;
import com.fastero.service.intf.OrderMasterServiceIn;
import com.fastero.vo.HistoryVO;
import com.fastero.vo.OrderMasterVO;

public class OrderMasterServiceIm implements OrderMasterServiceIn {

	OrderMasterDAOIm DAO;
	Result R;

	public OrderMasterServiceIm() {
		DAO = new OrderMasterDAOIm();
		R = new Result();
	}

//	@Override
//	public Result getAll() {
//		try {
//			return R.success(DAO.getAll());
//		} catch (Exception e) {
//			return R.fail(e.toString());
//		}
//	}
	@Override
	public List<OrderMasterVO> getAll() {
		try {
			return DAO.getAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<HistoryVO> getAllHistory() {
		try {
			return DAO.getAllHistory();
		} catch (Exception e) {
			return null;
		}
	}

}
