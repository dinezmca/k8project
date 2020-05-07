package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Product_info")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="PRODUCT_SEQ")
	@SequenceGenerator(sequenceName = "PRODUCT_SEQ", allocationSize = 1, name = "PRODUCT_SEQ")
	@Column(name="PRODUCT_ID", unique = true, precision = 22)
	private Long productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRICE")
	private Long price;
	
	@OneToOne(mappedBy ="product",  cascade = CascadeType.ALL)
	@JsonBackReference
	private Specification specfication;

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Specification getSpecfication() {
		return specfication;
	}

	public void setSpecfication(Specification specfication) {
		this.specfication = specfication;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}

}
