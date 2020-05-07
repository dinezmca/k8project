package com.model;

import java.util.List;

public class ProductDTO {
	private Long productId;
	private String productName;
	private Long quantity;
	private Long price;
	private List<Specification> specfication;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public List<Specification> getSpecfication() {
		return specfication;
	}

	public void setSpecfication(List<Specification> specfication) {
		this.specfication = specfication;
	}
}
