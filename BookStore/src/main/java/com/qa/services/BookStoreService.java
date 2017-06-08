package com.qa.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Books;
import com.qa.repositories.BookStoreRepository;

@Service
public class BookStoreService {
	
	@Autowired
	private BookStoreRepository bookStoreRepository;
	
	public Books createBookRecord(Books b) {
		return bookStoreRepository.save(b);
		
	}
	
	public Iterable<Books> getAllBooks(){
		return bookStoreRepository.findAll();
	}
	
	public Iterable<Books> getBooksByName(String bookName) {
		return bookStoreRepository.getBooksByName(bookName);
	}

}
