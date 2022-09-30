package com.fastero.service.impl;

import java.util.List;

import com.fastero.dao.impl.ReportDAOImpl;
import com.fastero.dao.intf.ReportDAOIntf;
import com.fastero.service.intf.ReportServiceIntf;
import com.fastero.vo.ReportVO;

public class ReportServiceImpl implements ReportServiceIntf{

	private ReportDAOIntf dao;

	public ReportServiceImpl() {
		dao = new ReportDAOImpl();
	}
	
	@Override
	public List<ReportVO> findAllReport() {
		
		try {
			return dao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addReport(int userId, int storeId, String reportText) {
		ReportVO vo = new ReportVO();
		vo.setUserId(userId);
		vo.setStoreId(storeId);
		vo.setReportText(reportText);
		
		
		try {
			dao.insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReport(int reportId, int userId, int storeId, String reportText, Integer reportStatus) {
		ReportVO vo = new ReportVO();
		vo.setReportId(reportId);
		vo.setUserId(userId);
		vo.setStoreId(storeId);
		vo.setReportText(reportText);
		vo.setReportStatus(reportStatus);
		
		try {
			dao.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
