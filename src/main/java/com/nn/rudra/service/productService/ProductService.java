package com.nn.rudra.service.productService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

	public List<Map<String, Object>> getProductList(Map<String, Object> paramMap) throws Exception;

	public List<Map<String, Object>> getProductDetail(Map<String, Object> requestParam) throws Exception;

	public List<Map<String, Object>> getProductSuggestion(Map<String, Object> requestParam) throws Exception;

	public Object addProduct(Map<String, Object> paramMap) throws Exception;
}
