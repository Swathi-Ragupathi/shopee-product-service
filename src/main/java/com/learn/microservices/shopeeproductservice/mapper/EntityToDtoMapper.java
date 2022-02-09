package com.learn.microservices.shopeeproductservice.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.learn.microservices.shopeeproductservice.config.CustomBeanUtils;
import com.learn.microservices.shopeeproductservice.dto.CategoryDTO;
import com.learn.microservices.shopeeproductservice.dto.ProductDetailsDTO;
import com.learn.microservices.shopeeproductservice.model.Category;
import com.learn.microservices.shopeeproductservice.model.ProductDetails;

@Component
public class EntityToDtoMapper {

//	@Autowired
//	private JsonConverter jsonConverter;
//	
	public ProductDetailsDTO productDetailsEntityToDTO(ProductDetails productDetailsEntity) {
		ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
		CustomBeanUtils.copyProperties(productDetailsEntity, productDetailsDTO);
		productDetailsDTO.setCategoryId(productDetailsEntity.getCategory().getId());
		productDetailsDTO.setCurrencyCode(productDetailsEntity.getCurrencyCode().name());
		//productDetailsDTO.setOtherInfo(jsonConverter.convertStringToJson(productDetailsEntity.getMetadata()));
		return productDetailsDTO;
	}
	
	public CategoryDTO categoryEntityToDTO(Category categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		CustomBeanUtils.copyProperties(categoryEntity, categoryDTO);
		return categoryDTO;
	}
	
	public List<ProductDetailsDTO> productDetailsEntityToDTO(List<ProductDetails> productDetailsEntityList) {
		List<ProductDetailsDTO> productDetailsDTOList = new ArrayList<>();
		if (CollectionUtils.isEmpty(productDetailsEntityList))
			return productDetailsDTOList;
		
		return productDetailsEntityList.stream().map(prodEntity -> {
			return productDetailsEntityToDTO(prodEntity);
		}).collect(Collectors.toList());
	}
	
	public List<CategoryDTO> categoryEntityToDTO(List<Category> categoryEntityList ) {
		List<CategoryDTO> categoryDTOList = new ArrayList<>();
		if (CollectionUtils.isEmpty(categoryEntityList))
			return categoryDTOList;
		
		return categoryEntityList.stream().map(categoryEntity -> {
			return categoryEntityToDTO(categoryEntity);
		}).collect(Collectors.toList());
	}
}
