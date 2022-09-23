package com.fastero.dao.intf;

import java.util.List;

import com.fastero.vo.ReviewVO;




//
public interface ReviewDAOIntf {
	public void insert(ReviewVO reviewVO);
    public void update(ReviewVO reviewVO);
    public void delete(Integer review_id);
    public ReviewVO findByPrimaryKey(Integer review_id);
    public List<ReviewVO> getAll();
	
	
}