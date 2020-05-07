package com.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exception.NotFoundException;
import com.model.CartItem;
import com.model.Customer;
import com.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.repo.CartItemRepository;


@RestController
public class CartController {
	
	@Autowired
	CartItemRepository cartRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/hystrix")
	public String home() {
		return "forward:/hystrix";
	}	
	private CartItem myFirstFallBack(String customerId, Long productId) {
		System.out.println("Invoked my fallback ----->"+customerId);
		return new CartItem();
	}
	
	@RequestMapping(value="selected")
	@HystrixCommand(fallbackMethod = "myFirstFallBack")
	public CartItem getWishedItems(@RequestParam String customerId, Long productId){

		String url = "http://productservice/getProduct?productId=" +productId; 
		
		String customerUrl = "http://customerservice/getCustomer?id=" + customerId;

		Customer customer = restTemplate.getForObject(customerUrl, Customer.class);

		if(customer==null ) {
			throw new NotFoundException("customerId", customerId);
		}
		
		
		Product product = restTemplate.getForObject(url,Product.class);
		
		CartItem cardItem = new CartItem();
		LocalDate today = LocalDate.now();
		cardItem.setCustomer(customer);
		cardItem.setEstimatedTime(today);
		cardItem.setProdcutId(productId);
		cardItem.setQuantity(1L);
		cardItem.setShippingCost(new BigDecimal(30));
		cardItem.setShippingStatus(Boolean.FALSE);
		cardItem.setSubTotal(new BigDecimal(product.getPrice()));
		cardItem.setGrandTotal(cardItem.getShippingCost().add(cardItem.getSubTotal()));
		cartRepository.save(cardItem);
		cartRepository.flush();
		return cardItem;
	}
	
	@RequestMapping(value="getCart")
	public CartItem getItem(@RequestParam Long cartId){
		return cartRepository.findBycartId(cartId);
	}
	
	@RequestMapping(value="update")
	public Integer updateCart(@RequestParam Long cartid, Long custid){
		return cartRepository.updateCartStatus(cartid, custid); 
	}

	@RequestMapping(value="getItems")
	public List<CartItem> getItems(@RequestParam Long custid){
		return cartRepository.getCartItems(custid);
	}
	
	@RequestMapping(value="getAllItems")
	public List<CartItem> getAllItems(@RequestParam Long custid){
		return cartRepository.findByCustomer(custid);
	}
}
