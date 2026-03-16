package com.capg.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.book.entity.Book;
import com.capg.book.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookrepo;

	public Book addBook(Book book) {
		return bookrepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookrepo.findAll();
	}

	@Override
	public Book getBookByID(long id) {
		return bookrepo.findById(id);
	}

	@Override
	public Book updateBook(long id, Book book) {
		
		Book book1 = bookrepo.findById(id);
		
		book1.setTitle(book.getTitle());
		
		book1.setCategory(book.getCategory());
		
		book1.setPrice(book.getPrice());
		
		book1.setAuthor(book.getAuthor());
		
		return book1;
	}

	@Override
	public void deleteBook(Book book) {
		bookrepo.delete(book);
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		return bookrepo.findByCategory(category);
	}
	
}
