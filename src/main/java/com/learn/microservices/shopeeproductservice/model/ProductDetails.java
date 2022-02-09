package com.learn.microservices.shopeeproductservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.learn.microservices.shopeeproductservice.annotation.constants.CurrencyCode;

@Entity
@Table
public class ProductDetails extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String name;
	
	@Column(columnDefinition = "MEDIUMTEXT")
	private String description;
	
	private Double mrp;
	private Double actualPrice;
	
	@Enumerated(value = EnumType.STRING)
	private CurrencyCode currencyCode;

	@Column(columnDefinition = "TEXT")
	private String imageUrl;

	private Integer availableStock;

	@Column(columnDefinition = "TINYINT")
	private boolean inStock;

	@Column(columnDefinition = "TINYINT")
	private boolean active;

//	@Column(columnDefinition = "MEDIUMTEXT")
//	private String metadata;


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrency(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

//	public String getMetadata() {
//		return metadata;
//	}
//
//	public void setMetadata(String metadata) {
//		this.metadata = metadata;
//	}

}
