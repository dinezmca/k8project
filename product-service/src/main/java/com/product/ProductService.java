package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.repo")
@ComponentScan(basePackages = "com.controller")
@EntityScan(basePackages = "com.model")
@EnableEurekaClient
public class ProductService {
	public static void main(String[] args) {
		SpringApplication.run(ProductService.class,args);
	}
}
