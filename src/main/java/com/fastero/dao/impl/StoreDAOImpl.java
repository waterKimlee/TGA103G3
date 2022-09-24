package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.dao.intf.StoreDAO;
import com.fastero.vo.StoreVO;
//
public class StoreDAOImpl implements StoreDAO {
	private DataSource dataSource;
	public StoreDAOImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FASTERO");
	}
	@Override
	public List<StoreVO> selectAll(){
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstt = conn.prepareStatement("SELECT * FROM FASTERO.Store");
				ResultSet rSet = pstt.executeQuery()
		){
//			store_id, store_name, store_address, store_longitude, store_latitude, store_phone, 
//			store_email, store_admin_account, store_admin_password, store_admin_phone, 
//			store_admin_address, store_preview_img, store_introduction, store_open_status, 
//			store_account_status, store_admin_name, store_admin_id, store_build_time, 
//			store_update_time, store_comment_number, store_total_star, store_business_time
			List<StoreVO> list = new ArrayList<>();
			while (rSet.next()) {
				StoreVO storeVO = new StoreVO();
				storeVO.setStoreID(rSet.getInt("store_id"));
				storeVO.setStorename(rSet.getString("store_name"));
				storeVO.setStoreaddress(rSet.getNString("store_address"));
				storeVO.setLongitude(rSet.getNString("store_longitude"));
				storeVO.setLatitude(rSet.getString("store_latitude"));
				storeVO.setStorephone(rSet.getNString("store_phone"));
				storeVO.setStoreemail(rSet.getNString("store_email"));
				storeVO.setStoreadminaccount(rSet.getNString("store_admin_account"));
				storeVO.setStoreadminpassword(rSet.getNString("store_admin_password"));
				storeVO.setStoreadminphone(rSet.getNString("store_admin_phone"));
				storeVO.setStoreadminaddress(rSet.getNString("store_admin_address"));
				storeVO.setStoreimg(rSet.getBlob("store_preview_img"));
				storeVO.setStoreintroduction(rSet.getNString("store_introduction"));
				storeVO.setStoreopenstatus(rSet.getByte("store_open_status"));
				storeVO.setStoreaccountstatus(rSet.getInt("store_account_status"));
				storeVO.setStoreadminname(rSet.getNString("store_admin_name"));
				storeVO.setStoreadminID(rSet.getNString("store_admin_id"));
				storeVO.setStorebuildtime(rSet.getDate("store_build_time"));
				storeVO.setStoreupdtetime(rSet.getDate("store_update_time"));
				storeVO.setStorecommentnumber(rSet.getInt("store_comment_number"));
				storeVO.setStoretotalstar(rSet.getInt("store_total_star"));
				storeVO.setStorebusinesstime(rSet.getString("store_business_time"));
				list.add(storeVO);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
