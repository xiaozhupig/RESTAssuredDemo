package com.learn.spingboot.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Setter
@Getter
@ToString
public class Stu {
    @Value("${stuName}")
    private String name;
    @Value("${stuAge}")
    private Integer age;
    @Value("${stuAddress}")
    private String  Address;
}
