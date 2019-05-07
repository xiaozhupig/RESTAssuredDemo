package com.learn.spring_boot2_demo.config;


import com.learn.spring_boot2_demo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {
    @Bean
    public User user(){
        return  new User();
    }

   /* @Bean
    public Stu stu(){
        return  new Stu();
    }*/
}
