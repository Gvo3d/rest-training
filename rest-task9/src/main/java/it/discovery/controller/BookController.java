package it.discovery.controller;

import it.discovery.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.discovery.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {

        Book book = bookRepository.findById(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @PostMapping
    public int doPost(@RequestBody Book book) {
        int id = bookRepository.save(book);
        return id;
    }

    @PutMapping(value = "/{id}")
    public void puPut(@RequestParam("id") int id, @RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping(value = "/{id}")
    public boolean doDelete(@PathVariable("id") Integer id) {
        return bookRepository.delete(id);
    }

}


