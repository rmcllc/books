package com.ryan.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ryan.books.models.Book;
import com.ryan.books.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	//returns all books
	public List<Book> allBooks() {
		return (List<Book>) bookRepo.findAll();
	}
	//creates a book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	//retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	//updates a book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			Book editBook = optionalBook.get();
			editBook.setId(id);
			editBook.setTitle(lang);
			editBook.setDescription(desc);
			editBook.setLanguage(lang);
			editBook.setNumberOfPages(numOfPages);
			bookRepo.save(editBook);
		} else {
			return null;
		}
		return null;
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	//deletes book
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			Book deleteThisBook = optionalBook.get();
			bookRepo.delete(deleteThisBook);
		}
	}
}
