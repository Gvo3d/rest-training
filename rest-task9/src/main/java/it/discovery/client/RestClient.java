package it.discovery.client;

import it.discovery.model.Book;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lenovo on 23.04.2017.
 */
public class RestClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        RestClient restClient = new RestClient();
//        Book book = restClient.getBook();
//        if (null==book) {
//            System.out.println("Book is null");
//        } else System.out.println(book.toString());

        System.out.println(restClient.saveBook());
    }

    public Book getBook(){
        return restTemplate.getForObject("http://localhost:8080/book/2",Book.class);
    }

    public int saveBook(){
        return restTemplate.postForObject("http://localhost:8080/book", new Book(),Integer.class);
    }
}
