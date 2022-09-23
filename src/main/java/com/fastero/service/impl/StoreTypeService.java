package com.fastero.service.impl;

import java.util.List;

import com.fastero.dao.impl.StoreTypeDAO;
import com.fastero.vo.StoreTypeVO;

public class StoreTypeService {

	private StoreTypeDAO dao;

	public StoreTypeService() {
		dao = new StoreTypeDAO();
	}

	public StoreTypeVO insertStoreType(Integer storeId, String storeType) {
		// , java.sql.Date administratorAccountBuildTime,Integer administratorRight
		StoreTypeVO storeTypeVO = new StoreTypeVO();

		storeTypeVO.setStoreId(storeId);
		storeTypeVO.setStoreType(storeType);
		dao.insert(storeTypeVO);

		return storeTypeVO;

	}

	public StoreTypeVO updateStoreType(Integer storeTypeId, Integer storeId, String storeType) {
		// , java.sql.Date administratorAccountBuildTime,Integer administratorRight
		StoreTypeVO storeTypeVO = new StoreTypeVO();
		storeTypeVO.setStoreTypeId(storeTypeId);
		storeTypeVO.setStoreId(storeId);
		storeTypeVO.setStoreType(storeType);
		dao.update(storeTypeVO);

		return storeTypeVO;

	}

	public void deleteStoreType(Integer storeId, String storeType) {

		dao.delete(storeId, storeType);

	}

	public StoreTypeVO getOneStoreType(Integer storeTypeId) {

		return dao.findByPrimaryKey(storeTypeId);

	}
	
	public List<StoreTypeVO> getAll() {
		return dao.getAll();
	}

}
