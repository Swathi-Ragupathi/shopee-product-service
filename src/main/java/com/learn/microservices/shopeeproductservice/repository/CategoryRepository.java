package com.learn.microservices.shopeeproductservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learn.microservices.shopeeproductservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(value = "Select * from category where name = ?1 and active = 1", nativeQuery = true)
	Category findByNameAndActive(String categoryName);

	@Query(value = "Select * from category where id = ?1 and active = 1", nativeQuery = true)
	Category findByIdAndActive(Long categoryId);

	List<Category> findAllByActive(boolean active);

}
