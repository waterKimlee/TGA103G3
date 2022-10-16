package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.AdministratorVO;
import com.fastero.vo.ReportVO;

public interface ReportDAOIntf {

	public List<ReportVO> getAll() throws Exception;
	
	public void insert(ReportVO reportVO) throws Exception;
	
    public void update(ReportVO reportVO) throws Exception;
	
    public ReportVO getById(Integer id) throws Exception;
    
    public Integer updateStatus(ReportVO vo) throws Exception;
}
