package com.learn.spring_boot2_demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/start")
    public String start(Model model){
        model.addAttribute("content","hello,thymeleaf");
        return "start";
    }
}
