package com.learn.microservices.shopeeproductservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learn.microservices.shopeeproductservice.annotation.IgnoreCopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDTO {
	@IgnoreCopy
	private Long id;
	private Long categoryId;
	private String name;
	private String description;
	private Double mrp;
	private Double actualPrice;
	private String currencyCode;
	private String imageUrl;
	private Integer availableStock;
	private boolean inStock;
	private boolean active;
	@IgnoreCopy
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	@IgnoreCopy
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedDate;

}
