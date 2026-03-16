package com.capg.book.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capg.book.entity.Book;

public interface BookRepository extends MongoRepository<Book,Integer>{
	
	public Book findById(long id);
	
	public List<Book> findByCategory(String category);
}
