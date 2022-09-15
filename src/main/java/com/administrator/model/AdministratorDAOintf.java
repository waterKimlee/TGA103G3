package com.administrator.model;

import java.util.List;



public interface AdministratorDAOintf {
	public void insert(AdministratorVO administratorVO);
    public void update(AdministratorVO administratorVO);
    public void delete(Integer administratorId);
    public AdministratorVO findByPrimaryKey(Integer administratorId);
    public List<AdministratorVO> getAll();
    
    public AdministratorVO login(AdministratorVO loginAdmin);
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
