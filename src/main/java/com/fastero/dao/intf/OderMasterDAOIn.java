package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.HistoryVO;
import com.fastero.vo.OrderMasterVO;



public interface OderMasterDAOIn {

	public List<OrderMasterVO> getAll();
	
	public List<HistoryVO> getAllHistory();
}
