
package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.StoreTypeVO;

public interface StoreTypeDAOintf {

	public void insert(StoreTypeVO storeTypeVO);

	public void update(StoreTypeVO storeTypeVO);

	public void delete(Integer storeId, String storeType);

	public StoreTypeVO findByPrimaryKey(Integer storeTypeId);

	public List<StoreTypeVO> getAll();


	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
	// public List<EmpVO> getAll(Map<String, String[]> map);
}