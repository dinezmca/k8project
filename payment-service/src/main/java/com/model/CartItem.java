package com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="Cart_info")
@DynamicUpdate
@JsonDeserialize(using = CartItemDeserializer.class)
public class CartItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="CART_SEQ")
	@SequenceGenerator(sequenceName = "CART_SEQ", allocationSize = 100, name = "CART_SEQ")
	@Column(name="CART_ID")
	private Long cartId;
	
	@Column(name="PRODUCT_ID")
	private Long prodcutId;
	
	@Column(name="QAUNTITY")
	private Long quantity;
	
	@Column(name="PRICE")
	private BigDecimal price;
	
	@Column(name="SUB_TOTAL")
	private BigDecimal subTotal;

	@Column(name="SHIPPING_COST")
	private BigDecimal shippingCost;
	
	@Column(name="GRAND_TOTAL")
	private BigDecimal grandTotal;
	
	@Column(name="SHIPPING_STATUS", columnDefinition = "boolean default false")
	private Boolean shippingStatus;
	
	@Column(name="Delivery_Date")
	private LocalDate estimatedTime;
	
	@ManyToOne()
	@JoinColumn(name="CUSTOMER_ID")
	@JsonBackReference
	private Customer customer;

	@OneToOne
	@JoinColumn(name="CART_ID")
	private Payment payment;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProdcutId() {
		return prodcutId;
	}

	public void setProdcutId(Long prodcutId) {
		this.prodcutId = prodcutId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Boolean getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(Boolean shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public LocalDate getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(LocalDate estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}	
}
