package com.learn.spingboot.demo.javaconfig;

import com.learn.spingboot.demo.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:config.properties",ignoreResourceNotFound = true)
public class Myconfig {

    @Bean
    public Stu getStu(){
        return  new Stu();
    }
}
