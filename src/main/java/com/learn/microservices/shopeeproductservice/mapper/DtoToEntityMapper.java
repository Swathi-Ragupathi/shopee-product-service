package com.learn.microservices.shopeeproductservice.mapper;

import org.springframework.stereotype.Component;

import com.learn.microservices.shopeeproductservice.annotation.constants.CurrencyCode;
import com.learn.microservices.shopeeproductservice.config.CustomBeanUtils;
import com.learn.microservices.shopeeproductservice.dto.CategoryDTO;
import com.learn.microservices.shopeeproductservice.dto.ProductDetailsDTO;
import com.learn.microservices.shopeeproductservice.model.Category;
import com.learn.microservices.shopeeproductservice.model.ProductDetails;

@Component
public class DtoToEntityMapper {

//	@Autowired
//	private JsonConverter jsonConverter;
	
	public ProductDetails productDetailsDtoToEntity(ProductDetailsDTO productDetailsDTO) {
		ProductDetails productDetailsEntity = new ProductDetails();
		CustomBeanUtils.copyProperties(productDetailsDTO, productDetailsEntity);
		productDetailsEntity.setCurrencyCode(CurrencyCode.valueOf(productDetailsDTO.getCurrencyCode()));
		//productDetailsEntity.setMetadata(jsonConverter.convertJsonToString(productDetailsDTO.getOtherInfo()));
		return productDetailsEntity;
	}
	
	public Category categoryDtoToEntity(CategoryDTO categoryDTO) {
		Category categoryEntity = new Category();
		CustomBeanUtils.copyProperties(categoryDTO, categoryEntity);
		return categoryEntity;
	}
}
