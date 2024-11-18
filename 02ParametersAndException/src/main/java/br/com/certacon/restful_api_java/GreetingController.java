package br.com.certacon.restful_api_java;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class GreetingController {
    private static final String template = "hello %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    private Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
