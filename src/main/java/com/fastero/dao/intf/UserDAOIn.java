package com.fastero.dao.intf;

import java.sql.SQLException;
import java.util.List;

import com.fastero.vo.UserVO;


public interface UserDAOIn {

	public List<UserVO> getAll() throws Exception;

	public UserVO getById(Integer id) throws SQLException;
	
	public Integer updateStatus(UserVO vo) throws SQLException;

}
