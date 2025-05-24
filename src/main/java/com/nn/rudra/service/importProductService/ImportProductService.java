package com.nn.rudra.service.importProductService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nn.rudra.entity.importProductEntity.ImportProduct;

@Service
public interface ImportProductService {

	public List<ImportProduct> getImportProducts(Map<String, Object> paramMap);
}
