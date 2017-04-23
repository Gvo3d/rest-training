package it.discovery.actuator;

import it.discovery.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Lenovo on 22.04.2017.
 */
@Component
public class NoBookHealth implements HealthIndicator {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Health health() {
        System.out.println("actuator used");
        List books = bookRepository.findAll();
        if (books.isEmpty()) return Health.down().withDetail("nobooks",true).build();
        return Health.up().build();
    }
}
