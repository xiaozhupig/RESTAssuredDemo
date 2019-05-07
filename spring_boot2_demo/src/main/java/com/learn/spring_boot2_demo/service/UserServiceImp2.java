package com.learn.spring_boot2_demo.service;

import org.springframework.stereotype.Service;

@Service("Imp2")
public class UserServiceImp2 implements  UserService{
    @Override
    public void select() {
        System.out.println("select 222**");
    }

    @Override
    public void deleteId() {
        System.out.println("dele 222--");
    }
}
