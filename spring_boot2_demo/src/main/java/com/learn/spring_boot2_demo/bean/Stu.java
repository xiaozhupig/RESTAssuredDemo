package com.learn.spring_boot2_demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Stu {

    private PersonInfor infor;

    @Autowired
    public void setStu(PersonInfor infor){
        this.infor = infor;
    }
}
