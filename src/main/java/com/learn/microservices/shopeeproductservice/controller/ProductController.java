package com.learn.microservices.shopeeproductservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservices.shopeeproductservice.annotation.constants.ErrorConstants;
import com.learn.microservices.shopeeproductservice.dto.ProductDetailsDTO;
import com.learn.microservices.shopeeproductservice.exception.ProductException;
import com.learn.microservices.shopeeproductservice.request.ProductDetailsInfoRequest;
import com.learn.microservices.shopeeproductservice.response.ResponseData;
import com.learn.microservices.shopeeproductservice.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<ResponseData> register(@RequestBody @Valid ProductDetailsInfoRequest productInfoRequest) {
		productService.addProduct(productInfoRequest);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseData(HttpStatus.CREATED.name(), "Product added Successfully"));
	}

	@GetMapping("/all/{categoryId}")
	public ResponseEntity<List<ProductDetailsDTO>> allProductByCategory(@PathVariable("categoryId") Long categoryId) {
		return ResponseEntity.ok().body(productService.allProductByCategory(categoryId));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDetailsDTO> productById(@PathVariable("id") Long productDetailsId) {
		return ResponseEntity.ok().body(productService.getProductById(productDetailsId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDetailsDTO> updateProduct(@PathVariable("id") Long productDetailsId,
			@RequestBody @Valid ProductDetailsInfoRequest productInfoRequest) {
		return ResponseEntity.ok().body(productService.updateProduct(productDetailsId, productInfoRequest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseData> disableProduct(@PathVariable("id") Long productDetailsId) {
		if (productService.disableProduct(productDetailsId)) {
			return ResponseEntity.ok().body(new ResponseData(HttpStatus.OK.name(), "Product Deleted Successfully"));
		}
		throw new ProductException(ErrorConstants.UNABLE_TO_PROCESS);

	}
}
