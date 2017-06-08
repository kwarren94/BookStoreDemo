package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.ShoppingCart;
import com.qa.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public ShoppingCart createOrder(ShoppingCart s) {
		return shoppingCartRepository.save(s);
	}
	
	public Iterable<ShoppingCart> getOrders(){
		return shoppingCartRepository.findAll();
	}
	
	public int updateBookQuantityByOneById(int customerId, int id, int bookQuantity) {
		
		return shoppingCartRepository.updateBookQuantityByOneById(customerId, id, bookQuantity);
		
	}
	
	public int removeBookFromCartByOneById(int customerId, int id, int bookQuantity) {
		
		return shoppingCartRepository.removeBookFromCartByOneById(customerId, id, bookQuantity );
		
	}

	public Iterable<ShoppingCart> getOrderByCustomerId(int customerId) {
		return shoppingCartRepository.getOrderByCustomerId(customerId);
	}
	
	public int removeEmptyBook(int customerId, int id) {
		return shoppingCartRepository.removeEmptyBook(customerId, id);
	}
	
}
