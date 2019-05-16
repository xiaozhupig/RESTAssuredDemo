package com.learn.pojo.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        e.printStackTrace();;
        CustomException e1 = null;

        if(e instanceof CustomException){  //如果抛出是系统自定义异常则直接转换
             e1 = (CustomException) e;
        }else{                             //如果抛出的不是系统自定义异常则重新构造一个未知错误异常
            e1 =new CustomException("未知错误，请联系系统管理员");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",e1.getMesssage());
        modelAndView.setViewName("exception");
        return modelAndView;
    }
}
