package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	

	@GetMapping("/api/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBook());
	}
	
	@PostMapping("/api/books")
	public ResponseEntity<Book> createANewBook(@RequestBody Book book)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
	}
	
	@GetMapping("/api/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
	}
	
}
