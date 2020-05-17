package com.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CartItemDeserializer extends StdDeserializer<CartItem> {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartItemDeserializer() {
        this(null);
    }
 
    public CartItemDeserializer(Class<?> vc) {
        super(vc);
    }
 
    @Override
    public CartItem deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
  
        JsonNode cartNode = jp.getCodec().readTree(jp);
        CartItem cartItem = new CartItem();
        
        cartItem.setCartId(Long.valueOf(cartNode.get("cartId").textValue()));
        cartItem.setProdcutId(Long.valueOf(cartNode.get("prodcutId").textValue()));
        cartItem.setQuantity(Long.valueOf(cartNode.get("quantity").textValue()));
        cartItem.setPrice(new BigDecimal(cartNode.get("price").textValue()));     
        cartItem.setSubTotal(new BigDecimal(cartNode.get("subTotal").textValue()));     
        cartItem.setShippingCost(new BigDecimal(cartNode.get("shippingCost").textValue()));     
        cartItem.setGrandTotal(new BigDecimal(cartNode.get("grandTotal").textValue()));     
        cartItem.setShippingStatus(Boolean.valueOf(cartNode.get("shippingStatus").textValue()));     
        cartItem.setEstimatedTime(LocalDate.now());     

        return cartItem;
    }
}