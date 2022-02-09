package com.learn.microservices.shopeeproductservice.exception;

import org.springframework.http.HttpStatus;

import com.learn.microservices.shopeeproductservice.annotation.constants.ErrorConstants;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductException extends RuntimeException {

	private String code;
	private String message;
	private String status = HttpStatus.INTERNAL_SERVER_ERROR.name();
	private int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

	public ProductException(ErrorConstants error) {
		this.code = error.getCode();
		this.message = error.getMessage();
		this.statusCode = error.getHttpStatus().value();
		this.status = error.getHttpStatus().name();
	}

	public ProductException(String message) {
		this.message = message;
	}

}
