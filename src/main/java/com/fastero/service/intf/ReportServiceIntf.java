package com.fastero.service.intf;

import java.util.List;

import com.fastero.vo.ReportVO;

public interface ReportServiceIntf {
	
	List<ReportVO> findAllReport();

	public void updateReport(int reportId);

	public void addReport(int userId, int storeId, String reportText);
}
