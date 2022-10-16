package com.fastero.service.intf;

import java.util.List;

import com.fastero.common.Result;
import com.fastero.vo.HistoryVO;
import com.fastero.vo.OrderMasterVO;

public interface OrderMasterServiceIn {

//	public Result getAll() throws Exception;
	public List<OrderMasterVO> getAll();
	
	public List<HistoryVO> getAllHistory();
}
