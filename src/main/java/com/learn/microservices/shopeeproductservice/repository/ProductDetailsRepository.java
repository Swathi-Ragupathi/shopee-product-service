package com.learn.microservices.shopeeproductservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learn.microservices.shopeeproductservice.model.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

	@Query(value = "Select * from product_details where category_id = ?1 and active = 1", nativeQuery = true)
	List<ProductDetails> findAllByCategoryIdAndActive(Long categoryId);

	
	@Query(value = "Select * from product_details where id = ?1 and active = 1", nativeQuery = true)
	ProductDetails findByIdAndActive(Long productDetailsId);
}
