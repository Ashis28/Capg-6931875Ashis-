package com.capg.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.book.entity.Book;
import com.capg.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book book) {
		return service.addBook(book);
	}
	
	@GetMapping("/getallbooks")
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@GetMapping("/getbook/{id}")
	public Book getBookById(@PathVariable long id) {
		return service.getBookByID(id);
	}
	
	@GetMapping("/getbooks/{category}")
	public List<Book> getBooksByCategory(@PathVariable String category){
		return service.getBooksByCategory(category);
	}
	
	@PutMapping("/updatebook/{id}")
	public Book updateBook(@PathVariable long id,@RequestBody Book book) {
		return service.updateBook(id, book);
	}
	
	@DeleteMapping("/deletebok")
	public String deleteBook(@RequestBody Book book) {
		service.deleteBook(book);
		
		return "Book Deleted Successfully!!";
	}
}
