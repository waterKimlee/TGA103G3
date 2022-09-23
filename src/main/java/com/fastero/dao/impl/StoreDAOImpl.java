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
			List<StoreVO> list = new ArrayList<>();
			while (rSet.next()) {
				StoreVO storeVO = new StoreVO();
				storeVO.setStoreID(rSet.getInt("storeID"));
				storeVO.setStorename(rSet.getString("storename"));
				storeVO.setStoreaddress(rSet.getNString("storeaddress"));
				storeVO.setLongitude(rSet.getNString("longitude"));
				storeVO.setLatitude(rSet.getString("latitude"));
				storeVO.setStorephone(rSet.getNString("storephone"));
				storeVO.setStoreemail(rSet.getNString("storeemail"));
				storeVO.setStoreadminaccount(rSet.getNString("storeadminaccount"));
				storeVO.setStoreadminpassword(rSet.getNString("storeadminpassword"));
				storeVO.setStoreadminphone(rSet.getNString("storeadminphone"));
				storeVO.setStoreadminaddress(rSet.getNString("storeadminaddress"));
				storeVO.setStoreimg(rSet.getBlob("storeimg"));
				storeVO.setStoreintroduction(rSet.getNString("storeintroduction"));
				storeVO.setStoreopenstatus(rSet.getByte("storeopenstatus"));
				storeVO.setStoreaccountstatus(rSet.getInt("storeaccountstatus"));
				storeVO.setStoreadminname(rSet.getNString("storeadminname"));
				storeVO.setStoreadminID(rSet.getNString("storeadminID"));
				storeVO.setStorebuildtime(rSet.getDate("storebuildtime"));
				storeVO.setStoreupdtetime(rSet.getDate("storeupdtetime"));
				storeVO.setStorecommentnumber(rSet.getInt("storecommentnumber"));
				storeVO.setStoretotalstar(rSet.getInt("storetotalstar"));
				storeVO.setStorebusinesstime(rSet.getString("storebusinesstime"));
				list.add(storeVO);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
