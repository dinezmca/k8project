package com.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.CartItem;
import com.model.Customer;
import com.repo.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@PostConstruct
	@Transactional(readOnly = true)
	public void customerConfig() {
		/*
		 * LocalDate today = LocalDate.now(); Customer customer = new Customer();
		 * customer.setFirstName("Dinesh"); customer.setLastName("Bosegandhi");
		 * customer.setAddress("Al Malaz"); customer.setMobileNumber(509150366L);
		 * customer.setRegisteredDate(today); customerRepository.save(customer);
		 */}

	@RequestMapping("/customers")
	public List<Customer> getCustomers() {

		List<Customer> custs = customerRepository.findAll();

		return custs;
	}

	@RequestMapping("/getCustomer")
	public Customer getProduct(@RequestParam Long id) {

		Customer cutomer = customerRepository.findByCustomerid(id);
		return cutomer;
	}

	@RequestMapping("/hello")
	public String getHello(@RequestParam Long id) {

		Optional<Customer> cutomer = customerRepository.findById(id);

		String data = "";
		data = data.concat(cutomer.toString());

		return "Customer----" + data;
	}

	@RequestMapping("/register")
	public Customer userCreation(@RequestParam Long mobileNumber) {
		LocalDate today = LocalDate.now();
		Customer customer = new Customer();
		customer.setFirstName("Kumar");
		customer.setLastName("Bose");
		customer.setAddress("RIYADH");
		customer.setMobileNumber(mobileNumber);
		customer.setRegisteredDate(today);
		customer.setEmail("kumar.b3@cognizant.com");
		customerRepository.save(customer);
		return customer;
	}
	@RequestMapping(value="getAllItems")
	public Customer getAllItems(@RequestParam Long custid){
		return customerRepository.findByCustomerid(custid);
	}
	
}
