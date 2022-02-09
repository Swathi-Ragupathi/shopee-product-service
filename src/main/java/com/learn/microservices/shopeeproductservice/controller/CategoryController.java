package com.learn.microservices.shopeeproductservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservices.shopeeproductservice.dto.CategoryDTO;
import com.learn.microservices.shopeeproductservice.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/add/{name}")
	public ResponseEntity<CategoryDTO> addCategory(@PathVariable("name") String categoryName) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(categoryName));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") Long categoryId){
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		return ResponseEntity.ok(categoryService.getAllCategory());
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable("name") String categoryName){
		return ResponseEntity.ok(categoryService.getCategoryByName(categoryName));
	}
	
	@PutMapping("/{id}/{name}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") Long categoryId,
			@PathVariable("name") String categoryName) {
		return ResponseEntity.ok().body(categoryService.updateCategory(categoryId, categoryName));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryDTO> disableCategory(@PathVariable("id") Long categoryId) {
		return ResponseEntity.ok().body(categoryService.disableCategory(categoryId));
	}
}
