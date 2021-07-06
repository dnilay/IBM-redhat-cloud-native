package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController

public class BookController {

	private BookService bookServiceImpl;

	@Autowired
	public BookController(BookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	@GetMapping("/api/books")
	public ResponseEntity<Collection<Book>> displayAllBook()
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.displayAllBook());
	}

}
