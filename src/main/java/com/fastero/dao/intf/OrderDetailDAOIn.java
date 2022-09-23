package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.OrderDetailVO;


public interface OrderDetailDAOIn {
	
	List<OrderDetailVO> getAll() throws Exception;
	List<OrderDetailVO> getById(Integer id) throws Exception;

}
