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
public class CategoryDTO {

	@IgnoreCopy
	private Long id;
	private String category;
	private boolean active;
	@IgnoreCopy
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	@IgnoreCopy
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date modifiedDate;

}
