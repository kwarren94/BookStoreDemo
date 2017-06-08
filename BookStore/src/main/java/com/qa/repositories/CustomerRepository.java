package com.qa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qa.models.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	
	@Query("SELECT c from Customer c where c.email = :email and c.password = :password")
	public Customer login(@Param("email")String email,@Param("password") String password);
	
	@Query("SELECT c from Customer c where c.id = :id")
	public Customer getCustomerById(@Param("id") int id);
	
	@Query("SELECT c from Customer c where c.email = :email")
	public Customer getCustomerByEmail(@Param("email") String email);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c.firstName = :firstName where c.id = :id")
	public int updateFirstNameById(@Param("id")int id,@Param("firstName") String firstName);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c.lastName = :lastName where c.id = :id")
	public int updateLastNameById(@Param("id")int id,@Param("lastName") String lastName);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c.email = :email where c.id = :id")
	public int updateEmailById(@Param("id")int id,@Param("email") String email);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c set c.password = :password where c.id = :id")
	public int updatePasswordById(@Param("id")int id,@Param("password") String password);
	
	@Query("SELECT c from Customer c where c.firstName = :firstName and c.lastName = :lastName and c.email = :email and c.password = :password and c.id = :id")
	public int getUser(@Param("id")int id,@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("password")String password);
}


