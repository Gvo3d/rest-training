package it.discovery.service;

import it.discovery.model.Book;

import java.util.List;

/**
 * Created by Lenovo on 22.04.2017.
 */
public interface BookService {
    Book findById(int id);

    List<Book> findAll();

    void save(Book book);

    boolean delete(int id);
}
