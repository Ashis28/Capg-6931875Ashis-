package com.capg.order.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.order.entities.Book;

@FeignClient(name = "CS01-BookService")
public interface BookClient {
	
	@GetMapping("/book/getbook/{id}")
	public Book getBookById(@PathVariable long id);
}
