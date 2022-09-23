package com.fastero.service.impl;

import java.util.List;

import javax.naming.NamingException;

import com.fastero.dao.impl.StoreDAOImpl;
import com.fastero.dao.intf.StoreDAO;
import com.fastero.service.intf.StoreService;
import com.fastero.vo.StoreVO;
//
public class StoreServiceImpl implements StoreService{
	private StoreDAO dao;
	
	public StoreServiceImpl() throws NamingException {
		dao = new StoreDAOImpl();
	}
	
	@Override
	public List<StoreVO> findAllStores() {
		
		return dao.selectAll();
	}

}
