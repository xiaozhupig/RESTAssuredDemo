package com.learn.controller;

import com.learn.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test1")
    @ResponseBody
    public User test1(User user){
        user.setName("lili");
        user.setAge(23);
        user.setBirth(new Date());
        return  user;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public User test2(User user){
        System.out.println(user);
        return  user;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/test3")
    public ModelAndView test3(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println(date);
        return null;
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password, ModelAndView modelAndView, HttpSession httpSession){
        if(username!=null && username.equals("lili") && password!=null &password.equals("123")){
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setBirth(new Date());
            user.setAge(23);
            httpSession.setAttribute("user",user);
            modelAndView.setViewName("user");

        }else {
            modelAndView.addObject("message","登录用户名或密码错误，请重新输入");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
