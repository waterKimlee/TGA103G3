package com.fastero.service.intf;

import java.util.List;

import com.fastero.common.Result;
import com.fastero.vo.OrderDetailVO;

public interface OrderDetailServiceIn {
	
//	public Result getAll() throws Exception;
	public List<OrderDetailVO> getAll() throws Exception;

	public Result getById(Integer id);

}
