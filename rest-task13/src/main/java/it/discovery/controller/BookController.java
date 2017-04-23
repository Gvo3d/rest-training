package it.discovery.controller;

import it.discovery.model.Book;
import it.discovery.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Resource<Book> getBook(@PathVariable("id") Integer id) {

		Book book = bookRepository.findById(id);
		Resource<Book> resource = new Resource<Book>(book);
		resource.add(linkTo(methodOn(BookController.class).doDelete(book.getId())).withRel("delete"));
		return resource;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Resource<Book>> getBooks() {
		List<Book> books = bookRepository.findAll();
		List<Resource<Book>> resources = new ArrayList<>();
		for (Book book:books){
			Resource<Book> resource = new Resource<Book>(book);
			resource.add(linkTo(methodOn(BookController.class).getBook(book.getId())).withSelfRel());
			resources.add(resource);
		}
		return resources;
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
	public ResponseEntity<Boolean> doDelete(@PathVariable("id") Integer id) {
		return new ResponseEntity<Boolean>(bookRepository.delete(id),HttpStatus.OK);
	}

}
