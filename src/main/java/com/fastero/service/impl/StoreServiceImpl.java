package com.fastero.service.impl;

import java.util.List;

import javax.naming.NamingException;

import com.fastero.dao.impl.StoreDAOImpl;
import com.fastero.dao.intf.StoreDAO;
import com.fastero.service.intf.StoreService;
import com.fastero.vo.StoreVO;

//
public class StoreServiceImpl implements StoreService {
	private StoreDAO dao;

	public StoreServiceImpl() {
		try {
			dao = new StoreDAOImpl();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StoreVO> findAllStores() {

		try {
			return dao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public StoreVO findById(Integer id) {

		try {
			return dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer updateStatus(StoreVO vo) {
		try {
			return dao.updateStatus(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
