package com.nn.rudra.dao.productDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public ProductDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String, Object>> getProductList(Map<String, Object> paramMap) throws Exception {
		int offset = Integer.parseInt(paramMap.getOrDefault("offset", 0).toString());
		Map<String, Object> namedParam = new HashMap<>();
		namedParam.put("offset", offset);
		String query = "SELECT * FROM public.product_details OFFSET :offset LIMIT 10";
		return jdbcTemplate.queryForList(query, namedParam);
	}

	public List<Map<String, Object>> getProductDetail(Map<String, Object> paramMap) throws Exception {
		String productId = paramMap.getOrDefault("productId","").toString();
		Map<String, Object> namedParam = new HashMap<>();
		namedParam.put("productId", productId);
		String query = "SELECT * FROM public.product_details where product_id = :productId limit 1";
		return jdbcTemplate.queryForList(query, namedParam);
	}
	
	public List<Map<String, Object>> getProductSuggestion(Map<String, Object> paramMap) throws Exception {
		String productId = paramMap.getOrDefault("productId","").toString();
		int offset = Integer.parseInt(paramMap.getOrDefault("offset", 0).toString());
		Map<String, Object> namedParam = new HashMap<>();
		namedParam.put("offset", offset);
		namedParam.put("productId", "%" + productId + "%");
		String query = "SELECT * FROM public.product_details where product_id ilike :productId offset :offset limit 5";
		return jdbcTemplate.queryForList(query, namedParam);
	}
	
	public Map<String, Object> upsertProductDetail(List<Map<String, Object>> upsertList) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		String query = "INSERT INTO public.product_details (product_id, product_name, product_sgst, product_cgst, profit, discount) values (:productId, :productName, :sgst, :cgst, :profit, :discount) ON CONLICT (product_id) DO UPDATE set product_name = EXCLUDED.product_name, productSgst = EXCLUDED.productSgst, productCgst = EXCLUDED.productCgst, profit = EXCLUDED.profit, discount = EXCLUDED.discount";
		SqlParameterSource[] batchParams = SqlParameterSourceUtils.createBatch(upsertList);
		returnMap.put("upsertedRows", jdbcTemplate.batchUpdate(query, batchParams).length);
		return returnMap;
	}
	
	public Map<String, Object> addProductStocks(List<Map<String, Object>> upsertList) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		String query = "update public.product_details SET stock_count = (stock_count + :stockCount), cost_per_unit = ((stock_count * cost_per_unit) + (:stockCount * :actualCost)) / (stock_count + :stockCount) where product_id = :productId";
		SqlParameterSource[] batchParams = SqlParameterSourceUtils.createBatch(upsertList);
		returnMap.put("upsertedRows", jdbcTemplate.batchUpdate(query, batchParams).length);
		return returnMap;
	}
	
}
