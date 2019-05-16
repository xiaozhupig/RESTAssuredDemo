package com.learn.controller;

import com.learn.pojo.Student;
import com.learn.pojo.exception.CustomException;
import com.learn.valid.ValidGroup2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StuController {
    @Autowired
    private Student student;
    @RequestMapping("/springmvc5_demo_war_exploded/saveOrUpdate")
    public String saveOrUpdate(@Validated(value = {ValidGroup2.class}) Student student, BindingResult bindingResult, Model model) throws CustomException {
        List<ObjectError> allErrors = bindingResult.getAllErrors();

        try {
            int i = 3/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("未知错误...");
        }
        System.out.println(allErrors.size());
        for (ObjectError error : allErrors){
            System.out.println(error.getDefaultMessage());
        }
        if(allErrors.size()>0){
            model.addAttribute("error",allErrors);
            return "error";
        }
        return "redirect:/sucess";

    }
}
