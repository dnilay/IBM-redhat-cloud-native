package com.example.spring_hibernate_integration;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring_hibernate_integration.model.Book;
import com.example.spring_hibernate_integration.repo.BookReporitory;
import com.example.spring_hibernate_integration.repo.BookReporitoryImpl;


public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        try {
        	
        	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        	BookReporitory bookReporitory=context.getBean("bookReporitoryImpl",BookReporitory.class);
        	//Book book=bookReporitory.createBook(new Book(new Random().nextInt(100000), "Pro Node", 110.0));
        	//System.out.println(book);
        	List<Book> list=bookReporitory.getAllBook();
        	for(Book b:list)
        	{
        		System.out.println(b);
        	}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
