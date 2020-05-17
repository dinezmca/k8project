package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.model.CartItem;
import com.model.CartItemDeserializer;
import com.model.Customer;
import com.model.Payment;
import com.repo.PaymentRepository;

@RestController
public class PaymentController {

	@Autowired
	RestTemplate resttemple;

	@Autowired
	PaymentRepository paymentRepository;

	@RequestMapping(value = "pay")
	public List<Payment> doCheckOut(@RequestParam Long custid) {

		List<Payment> paymentList = new ArrayList<Payment>();

		String customerUrl = "http://customerservice/getCustomer?id=" + custid;

		Customer customer = resttemple.getForObject(customerUrl, Customer.class);

		String cartUrl = "http://cartservice/getItems?custid=" + custid;

		ResponseEntity<List<CartItem>> cartItem = resttemple.exchange(cartUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CartItem>>() {
				});

		if (customer != null) {
			
			// cartItem = (List<CartItem>) resttemple.getForObject(cartUrl, CartItem.class);
			for (CartItem item : cartItem.getBody()) {
				Payment payment = new Payment();
				payment.setPaidStaus(Boolean.TRUE);
				item.setShippingStatus(Boolean.TRUE);
				payment.setCartItem(item);
				payment.setCustomerId(customer.getCustomerid());
				payment.setCardnumber(123456789L);
				payment.setPaidStaus(Boolean.TRUE);
				payment.setCartId(item.getCartId());
				paymentList.add(payment);
				paymentRepository.save(payment);
				paymentRepository.flush();
				updateCartStatus(item, custid);
			}
		}
		return paymentList;
	}

	private void updateCartStatus(CartItem item, Long custid) {
		String cartUrl = "http://cartservice/update";
		try {
			item.setShippingStatus(Boolean.TRUE);
			item.setCartId(custid);
			resttemple.put(cartUrl, item);
			System.out.println("Cart item updated--------->" + "Sucess");
		} catch (Exception e) {
			System.out.println("Cart item update --------->" + "failed");
			e.printStackTrace();

		}
	}
}
