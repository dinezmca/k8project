package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.CartItem;

@Repository
@Transactional
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	CartItem findBycartId(Long id);

	List<CartItem> findByCustomer(Long id);

	@Query("select c from CartItem c where c.customer.customerid = :id")
	List<CartItem> getCartItems(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query("update CartItem c set c.shippingStatus=1 where c.customer.customerid = :custid and c.cartId=:cartid")
	Integer updateCartStatus(@Param("cartid") Long cartid, @Param("custid") Long custid);
}