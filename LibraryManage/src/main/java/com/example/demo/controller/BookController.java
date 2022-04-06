package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Books;
import com.example.demo.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listBooks" ,bookService.getAllBooks());
		return "index";
	}
	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model)
	{
		Books books = new Books();
		model.addAttribute("books", books);
		return "new_book";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Books book)
	{
		bookService.saveBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{bookCode}")
	public String showFormForUpdate(@PathVariable (value = "bookCode") Integer bookCode , Model model)
	{
		Books books = bookService.getBooksById(bookCode);
		
		model.addAttribute("books", books);
		return "update_book";
	}
	@GetMapping("/deleteBook/{bookCode}")
	public String deleteBook(@PathVariable (value = "bookCode") Integer bookCode)
	{
		this.bookService.deleteEmployeeById(bookCode);
		return "redirect:/";
	}
}
