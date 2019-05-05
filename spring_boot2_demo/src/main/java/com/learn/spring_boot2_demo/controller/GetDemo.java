package com.learn.spring_boot2_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController
public class GetDemo {
    private  final Map<String ,Object>  map = new HashMap<>();
//    @RequestMapping(value = "/{city}/{user}",method = RequestMethod.GET)
//    @ResponseBody

    @GetMapping("/{city}/{user}")
    public  Object findObj(@PathVariable("city") String city1, @PathVariable("user") String user12){
        map.put("city","bj");
        map.put("user","hi123");
        return map;
    }

}
