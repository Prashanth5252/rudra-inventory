package com.nn.rudra.service.importProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nn.rudra.dao.productDao.ProductDao;
import com.nn.rudra.entity.importProductEntity.ImportProduct;
import com.nn.rudra.repo.importProductRepository.ImportProductRepository;

@Service
public class ImportProductServiceImpl implements ImportProductService {

	@Autowired
	private ImportProductRepository importProductRepo;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ImportProduct> getImportProducts(Map<String, Object> paramMap) {
		Sort sort = Sort.by("import_date").descending();
		int offset = Integer.parseInt(paramMap.getOrDefault("offset", 0).toString());
		Pageable pageable = PageRequest.of(offset, 10, sort);
		List<ImportProduct> importProducts = (List<ImportProduct>) importProductRepo.findAll(pageable);
		return importProducts;
	}

	@Override
	public Map<String, Object> saveImportProducts(List<ImportProduct> importProducts) throws Exception{
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("affectedRows", importProductRepo.saveAll(importProducts).size());
		List<Map<String, Object>> updateStocksList =  importProducts.stream().map(mapper -> {
			Map<String, Object> map = new HashMap<>();
			map.put("productId", mapper.getProduct_id());
			map.put("stockCount", mapper.getQuantity());
			map.put("actualCost", mapper.getCost_per_unit());
			return map;
			})
		.collect(Collectors.toList());
		productDao.addProductStocks(updateStocksList);
		return returnMap;
	}
	
	

}
