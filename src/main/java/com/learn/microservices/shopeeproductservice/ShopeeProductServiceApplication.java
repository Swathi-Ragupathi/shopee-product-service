package com.learn.microservices.shopeeproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootApplication
public class ShopeeProductServiceApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(ShopeeProductServiceApplication.class, args);
	}

}
