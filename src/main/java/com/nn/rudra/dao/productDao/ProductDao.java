package com.nn.rudra.dao.productDao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
	
	public List<Map<String, Object>> getProductList(Map<String, Object> paramMap) throws Exception;

	public List<Map<String, Object>> getProductDetail(Map<String, Object> paramMap) throws Exception;

	public List<Map<String, Object>> getProductSuggestion(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> addProductStocks(List<Map<String, Object>> upsertList) throws Exception;

}
