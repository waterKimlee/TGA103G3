package com.userstoreconn.model;

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

import com.storetype.model.StoreTypeVO;

public class UserStoreConnDAO implements UserStoreConnDAOintf {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TGA103G3");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "INSERT INTO UserStoreConn (user_id,store_id, status) VALUES (?, ?, ?)";
//	private static final String GET_ALL_STMT = "SELECT store_type_Id,store_id,store_type,store_Type_Update_Time FROM StoreType order by store_type_Id";
	private static final String GET_ONE_LIST = "SELECT store_Id FROM UserStoreConn where user_Id = ?";
//	private static final String DELETE = "DELETE FROM UserStoreConn where store_id = ? and store_type = ?";
	private static final String UPDATE = "UPDATE UserStoreConn set  status =?  where user_id =? and store_id= ?";

	
	
	@Override
	public void insert(UserStoreConnVO userStoreConnVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, userStoreConnVO.getUserId());
			pstmt.setInt(2, userStoreConnVO.getStoreId());
			pstmt.setInt(3, userStoreConnVO.getStatus());

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

	
	//頁面上在我的最愛名單裡取消最愛，或是改黑名單，都用update改status狀態，應該用不到delete
	@Override
	public void update(UserStoreConnVO userStoreConnVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, userStoreConnVO.getStatus());
			pstmt.setInt(2, userStoreConnVO.getUserId());
			pstmt.setInt(3, userStoreConnVO.getStoreId());

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

//	@Override
//	public void delete(Integer userId, Integer storeId) {
//		// TODO Auto-generated method stub
//		
//	}

	//查會員的最愛
	@Override
	public List<UserStoreConnVO> findByPrimaryKey(Integer userId) {
		List<UserStoreConnVO> list = new ArrayList<>();
		UserStoreConnVO userStoreConnVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_LIST);

			pstmt.setInt(1, userId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				userStoreConnVO = new UserStoreConnVO();
				userStoreConnVO.setStoreId(rs.getInt("store_id"));
				
				list.add(userStoreConnVO);
			
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
		
		return list;
	}

//	@Override
//	public List<UserStoreConnVO> getAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
