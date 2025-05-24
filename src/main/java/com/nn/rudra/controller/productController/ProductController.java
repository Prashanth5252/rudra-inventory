package com.nn.rudra.controller.productController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nn.rudra.service.productService.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/getProductList")
	public Map<String, Object> getProductList(@RequestBody Map<String, Object> requestParam){
		Map<String, Object> responseData = new HashMap<>();
		try {
			responseData.put("data", productService.getProductList(requestParam));
			responseData.put("status", true);
			responseData.put("statusCode", 200);
		} catch(Exception e) {
			System.out.println("Execption : " + e);
			responseData.put("status", false);
			responseData.put("errorMessage", e);
			responseData.put("statusCode", 500);
		}
		return responseData;
	}
	
	@GetMapping("/getProductDetail")
	public Map<String, Object> getProductDetail(@RequestBody Map<String, Object> requestParam){
		Map<String, Object> responseData = new HashMap<>();
		try {
			responseData.put("data", productService.getProductDetail(requestParam));
			responseData.put("status", true);
			responseData.put("statusCode", 200);
		} catch(Exception e) {
			System.out.println("Execption : " + e);
			responseData.put("status", false);
			responseData.put("errorMessage", e);
			responseData.put("statusCode", 500);
		}
		return responseData;
	}
	
	@GetMapping("/getProductSuggestion")
	public Map<String, Object> getProductSuggestion(@RequestBody Map<String, Object> requestParam){
		Map<String, Object> responseData = new HashMap<>();
		try {
			responseData.put("data", productService.getProductDetail(requestParam));
			responseData.put("status", true);
			responseData.put("statusCode", 200);
		} catch(Exception e) {
			System.out.println("Execption : " + e);
			responseData.put("status", false);
			responseData.put("errorMessage", e);
			responseData.put("statusCode", 500);
		}
		return responseData;
	}
	
	@PostMapping("/addProduct")
	public Map<String, Object> addProduct(@RequestBody Map<String, Object> requestMap) {
		Map<String, Object> responseData = new HashMap<>();
		try {
			responseData.put("data", productService.addProduct(requestMap));
			responseData.put("status", true);
			responseData.put("statusCode", 200);
		} catch(Exception e) {
			System.out.println("Execption : " + e);
			responseData.put("status", false);
			responseData.put("errorMessage", e);
			responseData.put("statusCode", 500);
		}
		return responseData;
	}
}
