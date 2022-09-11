package com.administrator.model;

import java.util.List;



public class AdministratorService {
	private AdministratorDAOintf dao;

	public AdministratorService() {
		dao = new AdministratorDAO();
	}
	
	public AdministratorVO addAdministrator(String administratorAccount, String administratorPassword, String administratorName, String administratorPhone,Integer administratorRight) {
		//, java.sql.Date administratorAccountBuildTime,Integer administratorRight
		AdministratorVO administratorVO = new AdministratorVO();
		
		administratorVO.setAdministratorAccount(administratorAccount);
		administratorVO.setAdministratorPassword(administratorPassword);
		administratorVO.setAdministratorName(administratorName);
		administratorVO.setAdministratorPhone(administratorPhone);
//		administratorVO.setAdministratorAccountBuildTime(administratorAccountBuildTime);
		administratorVO.setAdministratorRight(administratorRight);
		dao.insert(administratorVO);
	
		return administratorVO;
		
	}
	
	public AdministratorVO updateAdministrator(Integer administratorId, String administratorAccount, String administratorPassword, String administratorName, String administratorPhone, 
			Integer administratorRight) {
		
		AdministratorVO administratorVO = new AdministratorVO();
		
		administratorVO.setAdministratorId(administratorId);
		administratorVO.setAdministratorAccount(administratorAccount);
		administratorVO.setAdministratorPassword(administratorPassword);
		administratorVO.setAdministratorName(administratorName);
		administratorVO.setAdministratorPhone(administratorPhone);
//		administratorVO.setAdministratorAccountBuildTime(administratorAccountBuildTime);
		administratorVO.setAdministratorRight(administratorRight);
		dao.update(administratorVO);
	
		return administratorVO;
		
	}
	public void deleteEmp(Integer administratorId) {
		dao.delete(administratorId);
	}

	public AdministratorVO getOneAdmin(Integer administratorId) {
		return dao.findByPrimaryKey(administratorId);
	}

	public List<AdministratorVO> getAll() {
		return dao.getAll();
	}
	
	
	

	public AdministratorVO getlogin(AdministratorVO loginAdmin) {
		// TODO Auto-generated method stub 
		return dao.login(loginAdmin);
	}
}
