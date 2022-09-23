package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.UserVO;


public interface UserDAOIn {

	public List<UserVO> getAll() throws Exception;

	public List<UserVO> getById(Integer id);

}
