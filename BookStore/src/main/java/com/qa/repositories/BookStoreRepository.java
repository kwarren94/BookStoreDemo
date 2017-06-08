package com.qa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.models.Books;

@Repository
public interface BookStoreRepository extends CrudRepository<Books, Integer>{
	
	@Query("SELECT b from Books b where b.bookName like %:bookName%")
	public Iterable<Books> getBooksByName(@Param("bookName") String bookName);

}
