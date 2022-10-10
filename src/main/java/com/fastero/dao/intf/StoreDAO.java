package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.StoreVO;

//
public interface StoreDAO {

	public List<StoreVO> selectAll();

	public Integer insert(StoreVO vo);

	public StoreVO getByAccount(String account);
	
	public Boolean getByAdminId(String id);

	public StoreVO getById(Integer id);

	public Integer updateStatus(StoreVO vo);
}