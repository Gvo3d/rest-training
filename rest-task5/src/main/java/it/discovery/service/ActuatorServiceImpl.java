package it.discovery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 22.04.2017.
 */
@Service
public class ActuatorServiceImpl implements ActuatorService{
    private final CounterService counterService;

    @Autowired
    public ActuatorServiceImpl(CounterService counterService) {
        this.counterService = counterService;
    }

    public void exampleMethod() {
        this.counterService.increment("services.system.bookrepositoryused.invoked");
    }
}
