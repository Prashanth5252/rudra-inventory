package com.nn.rudra.repo.importProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nn.rudra.entity.importProductEntity.ImportProduct;

public interface ImportProductRepository extends JpaRepository<ImportProduct, String> {

	

}
