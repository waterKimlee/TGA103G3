package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fastero.dao.intf.ReportDAOIntf;
import com.fastero.dao.sql.UserSQL;
import com.fastero.vo.ReportVO;
import com.fastero.vo.UserVO;

public class ReportDAOImpl implements ReportDAOIntf {

	private static final String GET_ALL_STMT = "SELECT report_id, user_id, store_id, report_time, report_text, report_status FROM Report order by report_id";

	@Override
	public List<ReportVO> getAll() throws Exception {
		List<ReportVO> list = new ArrayList<ReportVO>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(UserSQL.GET_ALL);) {
			System.out.println("連線成功");
			try (ResultSet rs = ps.executeQuery()) {
				ReportVO vo;
				while (rs.next()) {

					// report_id, user_id, store_id, report_time, report_text, report_status

					vo = new ReportVO();
					vo.setReportId(rs.getInt("report_id"));
					vo.setUserId(rs.getInt("user_id"));
					vo.setStoreId(rs.getInt("store_id"));
					vo.setReportTime(rs.getObject("report_time", LocalDateTime.class));
					vo.setReportText(rs.getString("report_text"));
					vo.setReportStatus(rs.getInt("report_status"));

					list.add(vo);
				}
			}
			return list;
		}
	}

	private static final String INSERT_STMT = "INSERT INTO report (user_id,store_id,report_text) VALUES ( ?, ?, ?)";// build_time,
	
	@Override
	public void insert(ReportVO reportVO) throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(INSERT_STMT);) {
			System.out.println("連線成功");
			

//report_id, user_id, store_id, report_time, report_text, report_status

					ps.setInt(1, reportVO.getUserId());
					ps.setInt(2, reportVO.getStoreId());
					ps.setString(3, reportVO.getReportText());

					ps.executeUpdate();
		}
	}

	private static final String UPDATE = "UPDATE report set  user_id=?, store_id=?, report_text=? where report_id = ?";
	
	@Override
	public void update(ReportVO reportVO) throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(UPDATE);) {
			System.out.println("連線成功");
			

//report_id, user_id, store_id, report_time, report_text, report_status

					ps.setInt(1, reportVO.getStoreId());
					ps.setInt(2, reportVO.getReportId());
					ps.setString(3, reportVO.getReportText());
					ps.setInt(4, reportVO.getUserId());

					ps.executeUpdate();
		}
	
	}

}
