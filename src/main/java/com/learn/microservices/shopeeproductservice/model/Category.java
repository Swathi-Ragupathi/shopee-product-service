package com.learn.microservices.shopeeproductservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Category extends BaseEntity{

	@Column(length = 100, unique = true, nullable = false)
	private String category;

	@Column(columnDefinition = "TINYINT")
	private boolean active;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
}
