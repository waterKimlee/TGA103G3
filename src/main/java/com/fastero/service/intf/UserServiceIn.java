package com.fastero.service.intf;

import java.util.List;

import com.fastero.common.Result;
import com.fastero.vo.UserVO;

public interface UserServiceIn {

	public List<UserVO> getAll() throws Exception;

	public UserVO getById(Integer id);
	
	public void updateStatus(UserVO vo);

}
