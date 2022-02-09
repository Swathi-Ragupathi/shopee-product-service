package com.learn.microservices.shopeeproductservice.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetailsInfoRequest {

	@JsonProperty("categoryId")
	@NotNull(message = "Category Id cannot be empty")
	private Long categoryId;
	
	@JsonProperty("name")
	@NotBlank(message = "Product name cannot be empty")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("mrp")
	private Double mrp;
	
	@JsonProperty("actualPrice")
	@NotNull(message = "Price cannot be empty")
	private Double actualPrice;
	
	@JsonProperty("currencyCode")
	@NotBlank(message = "Currency code cannot be empty")
	private String currencyCode;
	
	@JsonProperty("imageUrl")
	private String imageUrl;
	
	@JsonProperty("availableStock")
	private Integer availableStock;
	
	//private Map<String, String> metadataMap;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
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

	/*
	 * @JsonAnyGetter public Map<String, String> getMetadataMap() { return
	 * metadataMap; }
	 * 
	 * public void setMetadataMap(Map<String, String> metadata) { this.metadataMap =
	 * metadata; }
	 * 
	 * @JsonAnySetter public void putMetaDataMap(String key, String value) { if
	 * (metadataMap == null) metadataMap = new HashMap<>(); metadataMap.put(key,
	 * value); }
	 */

}
