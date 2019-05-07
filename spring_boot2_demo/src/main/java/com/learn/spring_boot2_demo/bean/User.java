package com.learn.spring_boot2_demo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class User {

    private String name;
    private Integer age;
    private PersonInfor infor;
}
