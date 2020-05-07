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

@Entity
@Table(name="Payment_info")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="PAY_SEQ")
	@SequenceGenerator(sequenceName = "PAY_SEQ", allocationSize = 100, name = "PAY_SEQ")
	@Column(name="PAYMENT_ID", unique = true, precision = 10000)
	private Long paymentId;
	
	@Column(name="CART_ID")
	private Long cartId;

	@Column(name="CUSTOMER_ID")
	private Long customerId;
	
	@OneToOne(mappedBy ="payment" , cascade = CascadeType.MERGE )
	private CartItem cartItem;
	
	@Column(name="CARD_NUMBER")
	private Long cardnumber;
	
	@Column(name="PAYMENT_STATUS")
	private Boolean paidStaus;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public Long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(Long cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Boolean getPaidStaus() {
		return paidStaus;
	}

	public void setPaidStaus(Boolean paidStaus) {
		this.paidStaus = paidStaus;
	}
	
}
