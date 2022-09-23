package com.fastero.vo;


import java.sql.Date;
//
	public class ReviewVO implements java.io.Serializable{
		
		private static final long serialVersionUID = 1L;
		
		private Integer review_id;
		private Integer user_id;
		private Integer store_id;
		private Integer review_point;
		private String review_text;
		private String review_store_response;
		private Date review_time;
		
		
		public ReviewVO(Integer review_id, Integer user_id, Integer store_id, Integer review_point, String review_text,
				String review_store_response, Date review_time) {
			super();
			this.review_id = review_id;
			this.user_id = user_id;
			this.store_id = store_id;
			this.review_point = review_point;
			this.review_text = review_text;
			this.review_store_response = review_store_response;
			this.review_time = review_time;
		}
		public ReviewVO() {
			// TODO Auto-generated constructor stub
		}
		public Integer getReview_id() {
			return review_id;
		}
		public void setReview_id(Integer review_id) {
			this.review_id = review_id;
		}
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		public Integer getStore_id() {
			return store_id;
		}
		public void setStore_id(Integer store_id) {
			this.store_id = store_id;
		}
		public Integer getReview_point() {
			return review_point;
		}
		public void setReview_point(Integer review_point) {
			this.review_point = review_point;
		}
		public String getReview_text() {
			return review_text;
		}
		public void setReview_text(String review_text) {
			this.review_text = review_text;
		}
		public String getReview_store_response() {
			return review_store_response;
		}
		public void setReview_store_response(String review_store_response) {
			this.review_store_response = review_store_response;
		}
		public Date getReview_time() {
			return review_time;
		}
		public void setReview_time(Date review_time) {
			this.review_time = review_time;
		}

	

}
