package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Payment;

@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment, Long>{
 
   Payment findBypaymentId(Long paymentId);	
}
