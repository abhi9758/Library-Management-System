package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.repository.BookRepository;

@Service
public  class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public List<Books>getAllBooks()
	{
		return bookRepo.findAll();
	}

	@Override
	public void saveBook(Books books) {
		// TODO Auto-generated method stub
		this.bookRepo.save(books);
	}

	@Override
	public Books getBooksById(Integer bookCode) {
		// TODO Auto-generated method stub
		Optional<Books> optional = bookRepo.findById(bookCode);
		Books books = null;
		if(optional.isPresent())
		{
			books = optional.get();
		}
		else
		{
			throw new RuntimeException("Employee Not Found fro bookCode ::" + bookCode);
		}
		return books;
	}

	@Override
	public void deleteEmployeeById(Integer bookCode) {
		// TODO Auto-generated method stub
		this.bookRepo.deleteById(bookCode);
	}
	
}
