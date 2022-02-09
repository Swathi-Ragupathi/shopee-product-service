package com.learn.microservices.shopeeproductservice.annotation.constants;

import org.springframework.http.HttpStatus;

public enum ErrorConstants {

	UNABLE_TO_PROCESS("1000", "Failure Occurs", HttpStatus.INTERNAL_SERVER_ERROR),
	CATEGORY_EMPTY("1001", "Category info is missing", HttpStatus.BAD_REQUEST),
	MATCHING_CATEGORY_NOT_FOUND("1002", "Requested category not found", HttpStatus.NOT_FOUND),
	MATCHING_PRODUCT_NOT_FOUND("1003", "Requested product not found", HttpStatus.NOT_FOUND);

	String code;
	String message;
	HttpStatus httpStatus;

	ErrorConstants(String code, String message, HttpStatus statusCode) {
		this.code = code;
		this.message = message;
		this.httpStatus = statusCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus statusCode) {
		this.httpStatus = statusCode;
	}

}
