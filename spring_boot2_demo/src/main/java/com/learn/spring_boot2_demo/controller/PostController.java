package com.learn.spring_boot2_demo.controller;



import com.learn.spring_boot2_demo.bean.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {

    private final Map<String,String> map = new HashMap<>();

    @PostMapping("/home")
    public Object postPara(@RequestParam(value = "name",defaultValue = "halou") String name12, @RequestParam(value = "city",defaultValue = "sh") String city123){
        map.put("name","hi");
        map.put("city","bj");
        return map;
    }


    @PostMapping("/hello")
    public String post2(@RequestBody String jsonString){
        System.out.println(jsonString);
        return jsonString;
    }

    @PostMapping("/hello1")
    public String post3(@RequestBody Person person){
        System.out.println(person.toString());
        return person.toString();
    }
}
