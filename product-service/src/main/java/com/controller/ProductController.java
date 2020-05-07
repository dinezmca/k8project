package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.model.Specification;
import com.repo.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository prodRepo;
	
	@RequestMapping("addproduct")
	public String addProdcut() {
	
		Product product = new Product();
		product.setProductName("MAC PRO");
		product.setPrice(20000L);
		Specification specfication = new Specification();
		specfication.setColor("SPACE GRAY");
		specfication.setColor("SILVER");
		specfication.setRam("8GB");
		specfication.setProcessor("I7CORE");
		specfication.setProduct(product);
		product.setSpecfication(specfication);
		prodRepo.save(product);
		return product.toString();
	}
	@RequestMapping(value="getProductName")
	public List<Product> getProducts(@RequestParam String productName){
		List<Product> products = prodRepo.findByProductName(productName);
		System.out.println(products.size());
		return products;
	}
	@RequestMapping(value="getProduct")
	public Product getProduct(@RequestParam Long productId){
		Product product = prodRepo.findByProductId(productId);
		return product;
	}
}
