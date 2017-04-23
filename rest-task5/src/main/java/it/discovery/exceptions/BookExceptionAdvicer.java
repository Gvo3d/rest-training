package it.discovery.exceptions;

import it.discovery.model.Book;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Lenovo on 22.04.2017.
 */
@ControllerAdvice
public class BookExceptionAdvicer extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Book> handleError(BookNotFoundException ex, HttpRequest request){
        System.out.println("handleError");
        return ResponseEntity.badRequest().build();
    }
}
