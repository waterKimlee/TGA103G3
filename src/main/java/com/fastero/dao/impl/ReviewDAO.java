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

import com.fastero.dao.intf.ReviewDAOIntf;
import com.fastero.vo.ReviewVO;



//
public class ReviewDAO implements ReviewDAOIntf{

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/javaFramework");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		
	//review_id,user_id,store_id,review_point,review_text,review_store_response,review_time
		private static final String INSERT_STMT = 
				"INSERT INTO Review (user_id,store_id,review_point,review_text,review_store_response,review_time) VALUES (?, ?, ?, ?, ?, ?)";
			private static final String GET_ALL_STMT = 
				"SELECT review_id,user_id,store_id,review_point,review_text,review_store_response,review_time FROM Review order by review_id";
			private static final String GET_ONE_STMT = 
				"SELECT review_id,user_id,store_id,review_point,sal,review_text,review_store_response,review_time FROM Review where review_id = ?";
			private static final String DELETE = 
				"DELETE FROM Review where review_id = ?";
			private static final String UPDATE = 
				"UPDATE Review set user_id=?, store_id=?, review_point=?, review_text=?, review_store_response=?, review_time=? where review_id = ?";
			
			
			
			@Override
			public void insert(ReviewVO reviewVO) {
				
				Connection con = null;
				PreparedStatement pstmt = null;
				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(INSERT_STMT);

					pstmt.setInt(1, reviewVO.getReview_id());
					pstmt.setInt(2, reviewVO.getUser_id());
					pstmt.setInt(3, reviewVO.getStore_id());
					pstmt.setInt(4, reviewVO.getReview_point());
					pstmt.setString(5, reviewVO.getReview_text());
					pstmt.setString(6, reviewVO.getReview_store_response());
					pstmt.setDate(7, reviewVO.getReview_time());

					pstmt.executeUpdate();

					// Handle any SQL errors
				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
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
			public void update(ReviewVO reviewVO) {

				Connection con = null;
				PreparedStatement pstmt = null;
				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(UPDATE);

					pstmt.setInt(1, reviewVO.getReview_id());
					pstmt.setInt(2, reviewVO.getUser_id());
					pstmt.setInt(3, reviewVO.getStore_id());
					pstmt.setInt(4, reviewVO.getReview_point());
					pstmt.setString(5, reviewVO.getReview_text());
					pstmt.setString(6, reviewVO.getReview_store_response());
					pstmt.setDate(7, reviewVO.getReview_time());
//=============================================      順序有錯 1 要在最後
					pstmt.executeUpdate();

					// Handle any SQL errors
				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
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
			public void delete(Integer review_id) {
				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(DELETE);

					pstmt.setInt(1, review_id);

					pstmt.executeUpdate();

					// Handle any driver errors
				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
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
			public ReviewVO findByPrimaryKey(Integer review_id) {
				ReviewVO reviewVO = null;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ONE_STMT);

					pstmt.setInt(1, review_id);

					rs = pstmt.executeQuery();

					while (rs.next()) {
						// empVo 也稱為 Domain objects
						reviewVO = new ReviewVO();
						reviewVO.setReview_id(rs.getInt("review_id"));
						reviewVO.setUser_id(rs.getInt("user_id"));
						reviewVO.setStore_id(rs.getInt("store_id"));
						reviewVO.setReview_point(rs.getInt("review_point"));
						reviewVO.setReview_text(rs.getString("review_text"));
						reviewVO.setReview_store_response(rs.getString("review_store_response"));
						reviewVO.setReview_time(rs.getDate("review_time"));
					}

					// Handle any driver errors
				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
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
			
				return reviewVO;
			}
			@Override
			public List<ReviewVO> getAll() {
				List<ReviewVO> list = new ArrayList<ReviewVO>();
				ReviewVO reviewVO = null;

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(GET_ALL_STMT);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						
						reviewVO = new ReviewVO();
						reviewVO.setReview_id(rs.getInt("review_id"));
						reviewVO.setUser_id(rs.getInt("user_id"));
						reviewVO.setStore_id(rs.getInt("store_id"));
						reviewVO.setReview_point(rs.getInt("review_point"));
						reviewVO.setReview_text(rs.getString("review_text"));
						reviewVO.setReview_store_response(rs.getString("review_store_response"));
						reviewVO.setReview_time(rs.getDate("review_time"));
						list.add(reviewVO); // Store the row in the list
					}

					// Handle any driver errors
				} catch (SQLException se) {
					throw new RuntimeException("A database error occured. "
							+ se.getMessage());
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

					
		
}

