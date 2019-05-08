package com.learn.spingboot.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private Integer age;
    private Integer phone;
    private String email;
}
