package it.discovery.repository;

import it.discovery.model.Book;

import java.util.List;

public interface BookRepository {
	Book findById(int id);
	
	List<Book> findAll();
	
	int save(Book book);
	
	boolean delete(int id);

}
