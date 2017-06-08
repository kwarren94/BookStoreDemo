package com.qa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.qa.models.ShoppingCart;


@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer>{
	
	@Modifying
	@Transactional
	@Query("UPDATE ShoppingCart s set s.bookQuantity = :bookQuantity where s.customerId = :customerId and s.id = :id")
	public int updateBookQuantityByOneById( @Param("customerId") int customerId, @Param("id")int id,@Param("bookQuantity") int bookQuantity);

	
	@Modifying
	@Transactional
	@Query("UPDATE ShoppingCart s set s.bookQuantity = :bookQuantity where s.customerId = :customerId and s.id = :id")
	public int removeBookFromCartByOneById( @Param("customerId") int customerId, @Param("id")int id, @Param("bookQuantity") int bookQuantity);

	@Query("SELECT s from ShoppingCart s where s.customerId = :customerId")
	public Iterable<ShoppingCart> getOrderByCustomerId(@Param("customerId") int customerId);
	
	@Modifying
	@Transactional
	@Query("DELETE from ShoppingCart s where s.customerId = :customerId and s.id = :id")
	public int removeEmptyBook(@Param("customerId") int customerId, @Param("id") int id);

}
