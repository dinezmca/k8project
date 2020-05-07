package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductId(Long productId);
	
	@Query("SELECT P FROM Product P WHERE lower(P.productName) =lower(:productName)")
	List<Product> findByProductName(String productName);
	
}
