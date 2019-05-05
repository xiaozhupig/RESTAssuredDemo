package com.learn.spring_boot2_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/index")
    public String sayHello(){
        return "Hello spring_boot2";
    }

}
