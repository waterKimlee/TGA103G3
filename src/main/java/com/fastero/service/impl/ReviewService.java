package com.fastero.service.impl;

import java.util.List;

import com.fastero.dao.impl.ReviewDAO;
import com.fastero.dao.intf.ReviewDAOIntf;
import com.fastero.vo.ReviewVO;
//
public class ReviewService {
	private ReviewDAOIntf dao;

	public ReviewService() {

		dao = new ReviewDAO();
	}

	public ReviewVO addReview(Integer user_id, Integer store_id,
			Integer review_point, String review_text, String review_store_response, java.sql.Date review_time) {

		ReviewVO reviewVO = new ReviewVO();

		reviewVO.setUser_id(user_id);
		reviewVO.setStore_id(store_id);
		reviewVO.setReview_point(review_point);
		reviewVO.setReview_text(review_text);
		reviewVO.setReview_store_response(review_store_response);
		reviewVO.setReview_time(review_time);
		dao.insert(reviewVO);

		return reviewVO;
	}

	public ReviewVO updateReview( Integer user_id, Integer store_id,
			Integer review_point, String review_text, String review_store_response) {

		ReviewVO reviewVO = new ReviewVO();

		reviewVO.setUser_id(user_id);
		reviewVO.setStore_id(store_id);
		reviewVO.setReview_point(review_point);
		reviewVO.setReview_text(review_text);
		reviewVO.setReview_store_response(review_store_response);
		dao.update(reviewVO);

		return reviewVO;
	}
	
	public void deleteReview(Integer review_id) {
		dao.delete(review_id);
	
	}
	
	public ReviewVO getOneReview(Integer review_id) {
		return dao.findByPrimaryKey(review_id);
	}

	public List<ReviewVO> getAll() {
		return dao.getAll();
	}

}
