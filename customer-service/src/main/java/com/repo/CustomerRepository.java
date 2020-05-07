package com.repo;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Customer;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	    List<Customer> findByEmail(String email);

	    List<Customer> findByregisteredDate(Date date);
	    
	    Customer findByCustomerid(Long id);
	    
		// custom query example and return a stream
	    @Query("select c from Customer c where c.email = :email")
	    Stream<Customer> findByEmailReturnStream(@Param("email") String email);

}
