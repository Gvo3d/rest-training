package it.discovery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Lenovo on 22.04.2017.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookNotFoundException extends RuntimeException {
}
