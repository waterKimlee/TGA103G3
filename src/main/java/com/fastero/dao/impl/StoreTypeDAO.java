package com.fastero.dao.impl;

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

import com.fastero.dao.intf.StoreTypeDAOintf;
import com.fastero.vo.StoreTypeVO;

public class StoreTypeDAO implements StoreTypeDAOintf {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TGA103G3");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO StoreType (store_id,store_type) VALUES (?, ?)";// Administrator_account_build_time,
	private static final String GET_ALL_STMT = "SELECT store_type_Id,store_id,store_type,store_Type_Update_Time FROM StoreType order by store_type_Id";
	private static final String GET_ONE_STMT = "SELECT store_type_Id,store_id,store_type,store_Type_Update_Time FROM StoreType where store_type_Id = ?";
	private static final String DELETE = "DELETE FROM storeType where store_id = ? and store_type = ?";
	private static final String UPDATE = "UPDATE StoreType set  store_Id=?, store_type=?  where store_type_Id = ?";

	@Override
	public void insert(StoreTypeVO storeTypeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, storeTypeVO.getStoreId());
			pstmt.setString(2, storeTypeVO.getStoreType());

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
	public void update(StoreTypeVO storeTypeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, storeTypeVO.getStoreId());
			pstmt.setString(2, storeTypeVO.getStoreType());
			pstmt.setInt(3, storeTypeVO.getStoreTypeId());

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
	public StoreTypeVO findByPrimaryKey(Integer storeTypeId) {
		StoreTypeVO storeTypeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, storeTypeId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				storeTypeVO = new StoreTypeVO();
				storeTypeVO.setStoreTypeId(rs.getInt("store_type_Id"));
				storeTypeVO.setStoreId(rs.getInt("store_Id"));
				storeTypeVO.setStoreType(rs.getString("store_type"));
				storeTypeVO.setStoreTypeUpdateTime(rs.getDate("store_Type_Update_Time"));
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
		return storeTypeVO;
	}

	@Override
	public void delete(Integer storeId, String storeType) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, storeId);
			pstmt.setString(2, storeType);

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
	public List<StoreTypeVO> getAll() {
		List<StoreTypeVO> list = new ArrayList<>();
		StoreTypeVO storeTypeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				storeTypeVO = new StoreTypeVO();
				storeTypeVO.setStoreTypeId(rs.getInt("store_type_Id"));
				storeTypeVO.setStoreId(rs.getInt("store_Id"));
				storeTypeVO.setStoreType(rs.getString("store_type"));
				storeTypeVO.setStoreTypeUpdateTime(rs.getDate("store_Type_Update_Time"));

				list.add(storeTypeVO); // Store the row in the list
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

	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
