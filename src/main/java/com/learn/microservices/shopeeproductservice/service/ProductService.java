package com.learn.microservices.shopeeproductservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.microservices.shopeeproductservice.annotation.constants.CurrencyCode;
import com.learn.microservices.shopeeproductservice.annotation.constants.ErrorConstants;
import com.learn.microservices.shopeeproductservice.config.CustomBeanUtils;
import com.learn.microservices.shopeeproductservice.dto.ProductDetailsDTO;
import com.learn.microservices.shopeeproductservice.exception.ProductException;
import com.learn.microservices.shopeeproductservice.mapper.EntityToDtoMapper;
import com.learn.microservices.shopeeproductservice.model.Category;
import com.learn.microservices.shopeeproductservice.model.ProductDetails;
import com.learn.microservices.shopeeproductservice.repository.CategoryRepository;
import com.learn.microservices.shopeeproductservice.repository.ProductDetailsRepository;
import com.learn.microservices.shopeeproductservice.request.ProductDetailsInfoRequest;

@Service
public class ProductService {

//	@Autowired
//	private JsonConverter jsonConverter;

	@Autowired
	private ProductDetailsRepository productDetailsRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	public ProductDetailsDTO addProduct(ProductDetailsInfoRequest productInfoRequest) {

		if (productInfoRequest.getCategoryId() == null) {
			throw new ProductException(ErrorConstants.CATEGORY_EMPTY);
		}
		Category category = categoryRepository.getById(productInfoRequest.getCategoryId());
		if (category == null) {
			throw new ProductException(ErrorConstants.MATCHING_CATEGORY_NOT_FOUND);
		}
		try {
			ProductDetails productDetails = new ProductDetails();
			CustomBeanUtils.copyProperties(productInfoRequest, productDetails);
			productDetails.setCurrency(CurrencyCode.valueOf(productInfoRequest.getCurrencyCode()));
			productDetails.setActive(true);
			productDetails.setInStock(productDetails.getAvailableStock()>0);
			productDetails.setCategory(category);
			//productDetails.setMetadata(jsonConverter.convertMapToString(productInfoRequest.getMetadataMap()));
			productDetailsRepository.save(productDetails);
			return entityToDtoMapper.productDetailsEntityToDTO(productDetails);
		} catch (Exception e) {
			throw new ProductException(ErrorConstants.UNABLE_TO_PROCESS);
		}

	}

	public List<ProductDetailsDTO> allProductByCategory(Long categoryId) {
		if (categoryId == null) {
			throw new ProductException(ErrorConstants.CATEGORY_EMPTY);
		}

		List<ProductDetails> productDetailsByCategory = productDetailsRepository
				.findAllByCategoryIdAndActive(categoryId);

		return entityToDtoMapper.productDetailsEntityToDTO(productDetailsByCategory);
	}

	public ProductDetailsDTO getProductById(Long productDetailsId) {

		ProductDetails productDetails = activeProductById(productDetailsId);
		return entityToDtoMapper.productDetailsEntityToDTO(productDetails);
	}

	public ProductDetailsDTO updateProduct(Long productDetailsId, @Valid ProductDetailsInfoRequest productInfoRequest) {
		if (productInfoRequest.getCategoryId() == null) {
			throw new ProductException(ErrorConstants.CATEGORY_EMPTY);
		}
		Category category = categoryRepository.getById(productInfoRequest.getCategoryId());
		if (category == null) {
			throw new ProductException(ErrorConstants.MATCHING_CATEGORY_NOT_FOUND);
		}
		ProductDetails productDetails = activeProductById(productDetailsId);
		try {
			CustomBeanUtils.copyProperties(productInfoRequest, productDetails);
			productDetails.setCurrency(CurrencyCode.valueOf(productInfoRequest.getCurrencyCode()));
			productDetails.setCategory(category);
			//productDetails.setMetadata(jsonConverter.convertMapToString(productInfoRequest.getMetadataMap()));
			productDetailsRepository.save(productDetails);
			return entityToDtoMapper.productDetailsEntityToDTO(productDetails);
		} catch (Exception e) {
			throw new ProductException(ErrorConstants.UNABLE_TO_PROCESS);
		}
	}

	public boolean disableProduct(Long productDetailsId) {
		ProductDetails productDetails = activeProductById(productDetailsId);
		productDetails.setActive(false);
		productDetailsRepository.save(productDetails);
		return true;
	}

	public ProductDetails activeProductById(Long productDetailsId) {
		ProductDetails productDetails = productDetailsRepository.findByIdAndActive(productDetailsId);
		if (productDetails == null) {
			throw new ProductException(ErrorConstants.MATCHING_PRODUCT_NOT_FOUND);
		}
		return productDetails;
	}
}
