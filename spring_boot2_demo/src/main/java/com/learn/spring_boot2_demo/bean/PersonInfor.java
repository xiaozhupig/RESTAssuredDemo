package com.learn.spring_boot2_demo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@Setter
@ToString
public class PersonInfor {

    private String address;
    private String tel;
    private String Email;
}
