package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.vo.ProductVO;

public class ProductDAOim {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	// product_id,store_id,product_name,product_introduction,product_price,
	// product_satus,product_wait_time,product_build_time,product_update_time
	private static final String INSERT_STMT = "INSERT INTO Product (store_id, product_name, product_introduction, product_price, product_satus, product_wait_time) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM Product";
	private static final String GET_ONE_STMT = "SELECT product_id,store_id,product_name,product_introduction,product_price,product_satus,product_wait_time,product_build_time,product_update_time FROM Product where product_id = ?";
	private static final String DELETE = "DELETE FROM Product where product_id = ?";
	private static final String UPDATE = "UPDATE Product set product_name=?, product_introduction=?, product_price=?, product_satus=?,product_wait_time=? where product_id = ?";

	public void insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productVO.getStoreId());
			pstmt.setString(2, productVO.getProductName());
			pstmt.setString(3, productVO.getProductIntroduction());
			pstmt.setInt(4, productVO.getProductPrice());
			pstmt.setInt(5, productVO.getProductStatus());
			pstmt.setInt(6, productVO.getProductWaitTime());

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

	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, productVO.getProductName());
			pstmt.setString(2, productVO.getProductIntroduction());
			pstmt.setInt(3, productVO.getProductStatus());
			pstmt.setInt(4, productVO.getProductPrice());
			pstmt.setInt(5, productVO.getProductWaitTime());
			pstmt.setInt(6, productVO.getProductId());
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

	public void delete(Integer product_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, product_id);

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

	public ProductVO findByPrimaryKey(Integer product_id) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				productVO = new ProductVO();
				pstmt.setInt(1, productVO.getProductId());
				pstmt.setInt(2, productVO.getStoreId());
				pstmt.setString(3, productVO.getProductName());
				pstmt.setString(4, productVO.getProductIntroduction());
				pstmt.setInt(5, productVO.getProductStatus());
				pstmt.setInt(6, productVO.getProductPrice());
				pstmt.setInt(7, productVO.getProductWaitTime());
				pstmt.setDate(8, productVO.getProductUpdateTime());
				list.add(productVO);
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

		return productVO;
	}

	public List<ProductVO> getAll() throws SQLException {
		List<ProductVO> list = new ArrayList<ProductVO>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FASTERO", "root", "password");
				PreparedStatement ps = con.prepareStatement(GET_ALL_STMT);) {
			System.out.println("連線成功");
			ProductVO vo;

			try (ResultSet rs = ps.executeQuery()) {
				// product_id, store_id, product_name, product_introduction, product_price,
				// product_satus, product_image, product_wait_time, product_build_time,
				// product_update_time
				while (rs.next()) {
					vo = new ProductVO();
					vo.setProductId(rs.getInt("product_id"));
					vo.setStoreId(rs.getInt("store_id"));
					vo.setProductName(rs.getString("product_name"));
					vo.setProductIntroduction(rs.getString("product_introduction"));
					vo.setProductPrice(rs.getInt("product_price"));
					vo.setProductStatus(rs.getInt("product_satus"));
					vo.setProductImage(rs.getBytes("product_image"));
					vo.setProductWaitTime(rs.getInt("product_wait_time"));
					vo.setProductBuildTime(rs.getDate("product_build_time"));
					vo.setProductUpdateTime(rs.getDate("product_update_time"));

					list.add(vo); // Store the row in the list
				}

				// Handle any driver errors

				return list;

			}
		}
	}

}
