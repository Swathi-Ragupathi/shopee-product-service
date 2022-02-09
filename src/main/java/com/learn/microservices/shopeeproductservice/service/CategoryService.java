package com.learn.microservices.shopeeproductservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.learn.microservices.shopeeproductservice.annotation.constants.ErrorConstants;
import com.learn.microservices.shopeeproductservice.dto.CategoryDTO;
import com.learn.microservices.shopeeproductservice.exception.ProductException;
import com.learn.microservices.shopeeproductservice.mapper.EntityToDtoMapper;
import com.learn.microservices.shopeeproductservice.model.Category;
import com.learn.microservices.shopeeproductservice.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private EntityToDtoMapper entityToDtoMapper;
	
	public CategoryDTO addCategory(String categoryName) {
		Category category = new Category();
		category.setCategory(categoryName);
		category.setActive(true);
		categoryRepository.save(category);
		return entityToDtoMapper.categoryEntityToDTO(category);
	}

	public List<CategoryDTO> getAllCategory() {
		List<Category> categoryList = categoryRepository.findAllByActive(true);
		if(CollectionUtils.isEmpty(categoryList)) {
			throw new ProductException(ErrorConstants.MATCHING_CATEGORY_NOT_FOUND);
		}
		return entityToDtoMapper.categoryEntityToDTO(categoryList);
	}
	
	public CategoryDTO getCategoryById(Long categoryId) {
		Category category = categoryRepository.findByIdAndActive(categoryId);
		if(category == null) {
			throw new ProductException(ErrorConstants.MATCHING_CATEGORY_NOT_FOUND);
		}
		return entityToDtoMapper.categoryEntityToDTO(category);
	}
	
	public CategoryDTO getCategoryByName(String categoryName) {
		Category category = categoryRepository.findByNameAndActive(categoryName);
		if(category == null) {
			throw new ProductException(ErrorConstants.MATCHING_CATEGORY_NOT_FOUND);
		}
		return entityToDtoMapper.categoryEntityToDTO(category);
	}
	
	public CategoryDTO updateCategory(Long categoryId, String categoryName) {
		Category category = categoryRepository.findByIdAndActive(categoryId);
		if(category == null) {
			throw new ProductException(ErrorConstants.MATCHING_CATEGORY_NOT_FOUND);
		}
		category.setCategory(categoryName);
		categoryRepository.save(category);
		return entityToDtoMapper.categoryEntityToDTO(category);
	}

	public CategoryDTO disableCategory(Long categoryId) {
		Category category = categoryRepository.findByIdAndActive(categoryId);
		if(category == null) {
			throw new ProductException(ErrorConstants.MATCHING_CATEGORY_NOT_FOUND);
		}
		category.setActive(false);
		categoryRepository.save(category);
		return entityToDtoMapper.categoryEntityToDTO(category);
	}
}
