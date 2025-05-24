package com.nn.rudra.service.productService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nn.rudra.dao.productDao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	public List<Map<String, Object>> getProductList(Map<String, Object> paramMap) throws Exception {
		List<Map<String, Object>> productList = new ArrayList<>();
		{
			productList = productDao.getProductList(paramMap);
		}
		return productList;
	}

	public List<Map<String, Object>> getProductDetail(Map<String, Object> requestParam) throws Exception {
		List<Map<String, Object>> productList = new ArrayList<>();
		{
			productList = productDao.getProductDetail(requestParam);
		}
		return productList;
	}

	public List<Map<String, Object>> getProductSuggestion(Map<String, Object> requestParam) throws Exception {
		List<Map<String, Object>> productList = new ArrayList<>();
		{
			productList = productDao.getProductSuggestion(requestParam);
		}
		return productList;
	}

	@Override
	public Object addProduct(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
