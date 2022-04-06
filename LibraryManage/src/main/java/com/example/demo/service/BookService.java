package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Books;


public interface BookService {
	
	List<Books>getAllBooks();
	void saveBook(Books books);
	Books getBooksById(Integer bookCode);
	void deleteEmployeeById(Integer bookCode);
	
}
