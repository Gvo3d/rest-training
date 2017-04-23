package it.discovery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Lenovo on 22.04.2017.
 */
@Controller
@RequestMapping("/utils")
public class RestController {

    @ResponseBody
    @RequestMapping("/date")
    public String getDate(){
        return LocalDate.now().toString();
    }

    @ResponseBody
    @RequestMapping("/time")
    public String getTime(){
        return LocalTime.now().toString();
    }

    @GetMapping("/book")
    public String getBook(){
        return LocalTime.now().toString();
    }
}
