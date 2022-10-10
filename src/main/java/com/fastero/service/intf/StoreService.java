package com.fastero.service.intf;

import java.util.List;

import com.fastero.vo.StoreVO;

//
public interface StoreService {
	List<StoreVO> findAllStores();
	
	public StoreVO findById(Integer id);
	
	public Integer updateStatus(StoreVO vo);
	

}
