package com.learn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController {

    @RequestMapping("/model")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("WEB-INF/hello.jsp");
        modelAndView.addObject("h","h");
        return modelAndView;
    }
}
