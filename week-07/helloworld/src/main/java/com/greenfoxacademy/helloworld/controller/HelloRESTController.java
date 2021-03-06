package com.greenfoxacademy.helloworld.controller;

import com.greenfoxacademy.helloworld.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {
    AtomicLong atomicLong = new AtomicLong();

    @RequestMapping("greeting")
    public Greeting greeting(@RequestParam("name") String name) {

        return new Greeting(atomicLong.incrementAndGet(),"Hello, " + name);
    }
}
