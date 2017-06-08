package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Customer;
import com.qa.repositories.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomerRecord(Customer c) {
		return customerRepository.save(c);
	}
	
	public Customer login(String email, String password) {
		return customerRepository.login(email, password);
	}
	
	
	public Customer getCustomerById(int id) {
		return customerRepository.getCustomerById(id);
	}
	
	public Customer getCustomerByEmail(String email) {
		return customerRepository.getCustomerByEmail(email);
	}
	
	public int updateFirstNameById(int id, String firstName) {
		return customerRepository.updateFirstNameById(id, firstName);
	}
	
	public int updateLastNameById(int id, String lastName) {
		return customerRepository.updateLastNameById(id, lastName);
	}
	
	public int updateEmailById(int id, String email) {
		return customerRepository.updateEmailById(id, email);
	}
	
	public int updatePasswordById(int id, String password) {
		return customerRepository.updatePasswordById(id, password);
	}
	
	public int getUser(int id, String firstName, String lastName, String email, String password) {
		return customerRepository.getUser(id, firstName, lastName, email, password);
	}
}
