package it.discovery.repository;

import java.util.List;

import it.discovery.model.Book;

public interface BookRepository {
	Book findById(int id);
	
	List<Book> findAll();
	
	int save(Book book);
	
	boolean delete(int id);

}
