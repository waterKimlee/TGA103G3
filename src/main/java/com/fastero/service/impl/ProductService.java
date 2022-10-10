package com.fastero.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.fastero.dao.impl.ProductDAOim;
import com.fastero.dao.intf.ProductDAOintf;
import com.fastero.vo.ProductVO;

public class ProductService {
	private ProductDAOim dao = new ProductDAOim();

	public ProductVO addProduct(Integer storeId, String productName, String productIntroduction,
			Integer productPrice, Integer productSatus, Integer productWaitTime)
			{

		ProductVO productVO = new ProductVO();

		productVO.setStoreId(storeId);
		productVO.setProductName(productName);
		productVO.setProductIntroduction(productIntroduction);
		productVO.setProductPrice(productPrice);
		productVO.setProductStatus(productSatus);
		productVO.setProductWaitTime(productWaitTime);
		dao.insert(productVO);

		return productVO;
	}

	public ProductVO updateProduct(Integer productId, String productName,
			String productIntroduction, Integer productPrice, Integer productSatus, Integer productWaitTime)
			{
		ProductVO productVO = new ProductVO();

		productVO.setProductId(productId);
		productVO.setProductName(productName);
		productVO.setProductIntroduction(productIntroduction);
		productVO.setProductPrice(productPrice);
		productVO.setProductStatus(productSatus);
		productVO.setProductWaitTime(productWaitTime);
		dao.insert(productVO);
		return productVO;
		
	}
	public void deleteProduct(Integer productId) {
		dao.delete(productId);
	
	}

	public ProductVO getOneProduct(Integer storeId) {
		return dao.findByPrimaryKey(storeId);
	}
	public List<ProductVO> getAllProduct(){
		try {
			return dao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}