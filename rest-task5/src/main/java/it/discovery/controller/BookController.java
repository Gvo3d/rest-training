package it.discovery.controller;

import it.discovery.exceptions.BookNotFoundException;
import it.discovery.model.Book;
import it.discovery.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id){
        Book book = bookService.findById(id);
        if (null==book) {throw new BookNotFoundException();
        }
        else return new ResponseEntity(book,HttpStatus.OK);
    }

    @PostMapping
    public void doPost(@RequestBody Book book){
        bookService.save(book);
    }

    @PutMapping(value = "/{id}")
    public void puPut(@RequestParam("id") int id, @RequestBody Book book){
        bookService.save(book);
    }

    @DeleteMapping(value = "/{id}")
    public boolean doDelete(@PathVariable("id") Integer id){
        return bookService.delete(id);
    }

    private void validate(Book book){
        if (null==book) {
            BookNotFoundException exception = new BookNotFoundException();
            try {
                throw exception;
            } catch (BookNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
