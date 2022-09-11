package com.administrator.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class AdministratorDAO implements AdministratorDAOintf {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TGA103G3");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	// Administrator_id, Administrator_account, Administrator_password,
	// Administrator_name, Administrator_phone, Administrator_account_build_time,
	// Administrator_right
	private static final String INSERT_STMT = "INSERT INTO administrator (Administrator_account,Administrator_password,Administrator_name,Administrator_phone,Administrator_right) VALUES (?, ?, ?, ?, ?)";//Administrator_account_build_time,
	private static final String GET_ALL_STMT = "SELECT Administrator_id,Administrator_account,Administrator_password,Administrator_name,Administrator_phone,Administrator_account_build_time,Administrator_right FROM administrator order by Administrator_id";
	private static final String GET_ONE_STMT = "SELECT Administrator_id,Administrator_account,Administrator_password,Administrator_name,Administrator_phone,Administrator_account_build_time,Administrator_right FROM administrator where Administrator_id = ?";
	private static final String DELETE = "DELETE FROM administrator where Administrator_id = ?";
	private static final String UPDATE = "UPDATE administrator set  Administrator_password=?, Administrator_name=?, Administrator_phone=?,  Administrator_right=? where Administrator_id = ?";

	@Override
	public void insert(AdministratorVO administratorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, administratorVO.getAdministratorAccount());
			pstmt.setString(2, administratorVO.getAdministratorPassword());
			pstmt.setString(3, administratorVO.getAdministratorName());
			pstmt.setString(4, administratorVO.getAdministratorPhone());
//			pstmt.setDate(5, administratorVO.getAdministratorAccountBuildTime());
			pstmt.setInt(5, administratorVO.getAdministratorRight());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(AdministratorVO administratorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

//			pstmt.setString(1, administratorVO.getAdministratorAccount());
			pstmt.setString(1, administratorVO.getAdministratorPassword());
			pstmt.setString(2, administratorVO.getAdministratorName());
			pstmt.setString(3, administratorVO.getAdministratorPhone());
//			pstmt.setDate(5, administratorVO.getAdministratorAccountBuildTime());
			pstmt.setInt(4, administratorVO.getAdministratorRight());
			pstmt.setInt(5, administratorVO.getAdministratorId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer administratorId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, administratorId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public AdministratorVO findByPrimaryKey(Integer administratorId) {
		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, administratorId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				administratorVO = new AdministratorVO();
				administratorVO.setAdministratorId(rs.getInt("Administrator_id"));
				administratorVO.setAdministratorAccount(rs.getString("Administrator_account"));
				administratorVO.setAdministratorPassword(rs.getString("Administrator_password"));
				administratorVO.setAdministratorName(rs.getString("Administrator_name"));
				administratorVO.setAdministratorPhone(rs.getString("Administrator_phone"));
				administratorVO.setAdministratorAccountBuildTime(rs.getDate("Administrator_account_build_time"));
				administratorVO.setAdministratorRight(rs.getInt("Administrator_right"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return administratorVO;
	}

	@Override
	public List<AdministratorVO> getAll() {
		List<AdministratorVO> list = new ArrayList<>();
		AdministratorVO administratorVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				administratorVO = new AdministratorVO();
				administratorVO.setAdministratorId(rs.getInt("Administrator_id"));
				administratorVO.setAdministratorAccount(rs.getString("Administrator_account"));
				administratorVO.setAdministratorPassword(rs.getString("Administrator_password"));
				administratorVO.setAdministratorName(rs.getString("Administrator_name"));
				administratorVO.setAdministratorPhone(rs.getString("Administrator_phone"));
				administratorVO.setAdministratorAccountBuildTime(rs.getDate("Administrator_account_build_time"));
				administratorVO.setAdministratorRight(rs.getInt("Administrator_right"));
				list.add(administratorVO); // Store the row in the list
			}

			// Administrator_id, Administrator_account, Administrator_password,
			// Administrator_name, Administrator_phone, Administrator_account_build_time,
			// Administrator_right
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public AdministratorVO login(AdministratorVO loginAdmin) {

		String sql = " select * from Administrator where administrator_account = ? and administrator_password = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, loginAdmin.getAdministratorAccount());
			pstmt.setString(2, loginAdmin.getAdministratorPassword());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				loginAdmin.setAdministratorId(rs.getInt("Administrator_id"));
				loginAdmin.setAdministratorAccount(rs.getString("Administrator_account"));
				loginAdmin.setAdministratorPassword(rs.getString("Administrator_password"));
				loginAdmin.setAdministratorName(rs.getString("Administrator_name"));
				loginAdmin.setAdministratorPhone(rs.getString("Administrator_phone"));
				loginAdmin.setAdministratorAccountBuildTime(rs.getDate("Administrator_account_build_time"));
				loginAdmin.setAdministratorRight(rs.getInt("Administrator_right"));
			}
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		
		return loginAdmin;

	}

}
